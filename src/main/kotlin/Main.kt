import filesystem.FilesRenamer
import util.MessagesPrinter
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    MessagesPrinter.printProgramHeader()
    MessagesPrinter.printPromptUserMessage()

    readLine()?.let { userInput ->
        if (userInput == "No") {
            exitProcess(1)
        } else {
            val filesRenamer = FilesRenamer()
            filesRenamer.start()
        }
    }
}
