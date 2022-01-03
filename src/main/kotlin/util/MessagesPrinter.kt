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

package util

object MessagesPrinter {

    fun printProgramHeader() {
        println("//* -------------------------------------------------------------------------------- //*")
        println("//*                            Directory Files Randomizer                            //*")
        println("//*                                 by Matt Menezes                                  //*")
        println("//* -------------------------------------------------------------------------------- //*")
    }

    fun printPromptUserMessage() = println("Please type the working path or \"No\" to exit.")

    fun printFileRenamedSuccessfullyMessage(fileName: String) = println("File renamed to: $fileName")

    fun printFailedToRenameFileMessage(fileName: String) = println("Error renaming: $fileName")
}
