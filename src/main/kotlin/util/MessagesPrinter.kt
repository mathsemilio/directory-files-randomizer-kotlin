package util

object MessagesPrinter {

    fun printProgramHeader() {
        println("//* -------------------------------------------------------------------------------- //*")
        println("//*                            Directory Files Randomizer                            //*")
        println("//*                                 by Matt Menezes                                  //*")
        println("//* -------------------------------------------------------------------------------- //*")
    }

    fun printPromptUserMessage() = println("Please type the working path or \"No\" to exit.")

    fun printFileRenamedSuccessfullyMessage(fileName: String) = println("File renamed to: $fileName.")

    fun printFailedToRenameFileMessage(fileName: String) = println("Error renaming: $fileName.")
}
