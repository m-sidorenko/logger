package net.nomia.utils.logger

/**
 * The `interface Loggable` is defining a contract for classes that want to implement logging
 * functionality. 
 */
interface Loggable {

    /**
     * The function "t" prints a trace level log message with a given tag.
     * 
     * @param tag A string representing the tag or label for the log message.
     * @param message The `message` parameter is a string that represents the message to be printed.
     */
    fun t(tag: String, message: String)
    
    /**
     * The function "d" prints a debug level log message with a given tag.
     * 
     * @param tag A string representing the tag or label for the log message.
     * @param message The `message` parameter is a string that represents the message to be printed.
     */
    fun d(tag: String, message: String)

    /**
     * The function "d" prints a info level log message with a given tag.
     * 
     * @param tag A string representing the tag or label for the log message.
     * @param message The `message` parameter is a string that represents the message to be printed.
     */
    fun i(tag: String, message: String)
    
    /**
     * The function "d" prints a warning level log message with a given tag.
     * 
     * @param tag A string representing the tag or label for the log message.
     * @param message The `message` parameter is a string that represents the message to be printed.
     */
    fun w(tag: String, message: String)
    
    /**
     * The function "e" logs an error message along with the tag and throwable information.
     * 
     * @param tag A string representing the tag or identifier for the log message. It is used to
     * categorize and filter log messages.
     * @param throwable The `throwable` parameter is an instance of the `Throwable` class, which
     * represents an error or exception that has occurred during the execution of a program. It can be
     * used to capture and handle errors or exceptions in a structured way.
     */
    fun e(tag: String, throwable: Throwable)

    /**
     * The function prints a message with a tag and then prints the stack trace of a throwable object.
     * 
     * @param tag A string that represents a tag or identifier for the log message. It is typically
     * used to categorize or filter log messages.
     * @param throwable The `throwable` parameter is an instance of the `Throwable` class, which
     * represents an error or exception that has occurred. It contains information about the error,
     * such as the error message and the stack trace.
     * @param message The `message` parameter is a string that represents the message you want to
     * print.
     */
    fun e(tag: String, throwable: Throwable, message: String)
}
