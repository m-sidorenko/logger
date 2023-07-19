import src.LogLevel
import src.Logger

fun main() {
    val logger = Logger
    logger.setLevel(LogLevel.Trace)

    logger.d("Tag", "Message")
}