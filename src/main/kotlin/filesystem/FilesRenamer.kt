/*
Copyright 2022 Matheus Menezes

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */

package filesystem

import util.*
import domain.model.DirectoryFile
import filesystem.directoryfilesmanager.RenameFileResult
import filesystem.directoryfilesmanager.RenameFileResult.*
import filesystem.directoryfilesmanager.DirectoryFilesManager

class FilesRenamer private constructor(path: String) {

    companion object {
        fun forDirectoryAt(path: String) = FilesRenamer(path)
    }

    private lateinit var file: DirectoryFile

    private val manager = DirectoryFilesManager.forDirectoryAt(path)
    private val numberGenerator = UniqueRandomNumberGenerator.withUpperBound(manager.numberOfFiles)

    fun start() {
        manager.files.forEach { file ->
            this.file = file
            inspectFileName()
        }
    }

    private fun inspectFileName() {
        if (file.name.containsNumbers())
            renameFileThatStartsWithNumbers()
        else
            renameFile("${buildPrefixWith(numberGenerator.randomNumber)} ${file.name}")
    }

    private fun renameFileThatStartsWithNumbers() {
        val newFileName = if (!file.name.containsHyphen())
            "${buildPrefixWith(numberGenerator.randomNumber)} ${file.name}"
        else
            file.name.replace(file.name.getPrefixBeforeBackspace(), "${numberGenerator.randomNumber}")

        renameFile(newFileName)
    }

    private fun renameFile(newFileName: String) = handleRenameFileResult(manager.rename(file, newFileName))

    private fun handleRenameFileResult(result: RenameFileResult) {
        when (result) {
            is FileRenamedSuccessfully -> MessagesPrinter.printFileRenamedSuccessfullyMessage(result.fileName)
            is RenameFileFailed -> MessagesPrinter.printFailedToRenameFileMessage(result.fileName)
        }
    }
}
