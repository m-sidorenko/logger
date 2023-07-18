package net.nomia.utils.logger

import net.nomia.utils.logger.impl.ConsoleLogger

object Logger {
    private var log: Loggable = ConsoleLogger()
    private var level: LogLevel = LogLevel.Debug

    /**
     * The function sets the logger.
     * 
     * @param logger The `logger` parameter is an object that implements the `Loggable` interface.
     */
    fun setLogger(logger: Loggable) {
        log = logger
    }

    /**
     * The function sets the level for logger.
     * 
     * @param logLevel The logLevel parameter is of type LogLevel.
     */
    fun setLevel(logLevel: LogLevel) {
        level = logLevel
    }

    /**
     * The `log` function is used to execute a block of code only if the current log level is equal to
     * or higher than the target log level.
     * 
     * @param targetLevel Log level
     * @param block The `block` parameter is a lambda function that takes no arguments and returns no
     * value. It is a block of code that will be executed if the current log level is greater than or
     * equal to the target log level.
     */
    private inline fun log(targetLevel: LogLevel, block: () -> Unit) {
        if (level.value >= targetLevel.value) {
            block.invoke()
        }
    }

    /**
     * The function "t" is a logging function in Kotlin that logs a trace message with a given tag and
     * message, and supports formatting arguments.
     * 
     * @param tag A string representing the tag or identifier for the log message. It is used to
     * categorize or group log messages together.
     * @param message The `message` parameter is a string that represents the log message to be logged.
     * It can contain placeholders for any additional arguments that are passed in the `args`
     * parameter.
     * @param args The `args` parameter is a vararg parameter, which means it can accept zero or more
     * arguments of any type. In this case, it is used to pass additional arguments that can be used to
     * format the `message` string using `String.format()`.
     */
    fun t(tag: String, message: String, vararg args: Any){
        log(LogLevel.Trace) {
            log.t(tag, if (args.isEmpty()) message else String.format(message, *args))
        }
    }

    fun t(tag: String, lazyMessage: () -> String) {
        log(LogLevel.Trace) {
            log.t(tag, lazyMessage.invoke())
        }
    }

    fun d(tag: String, message: String, vararg args: Any) {
        log(LogLevel.Debug) {
            log.d(tag, if (args.isEmpty()) message else String.format(message, *args))
        }
    }

    fun d(tag: String, lazyMessage: () -> String) {
        log(LogLevel.Debug) {
            log.d(tag, lazyMessage.invoke())
        }
    }

    fun i(tag: String, message: String, vararg args: Any) {
        log(LogLevel.Info) {
            log.i(tag, if (args.isEmpty()) message else String.format(message, *args))
        }
    }

    fun w(tag: String, message: String, vararg args: Any) {
        log(LogLevel.Warn) {
            log.w(tag, if (args.isEmpty()) message else String.format(message, *args))
        }
    }

    fun e(tag: String, throwable: Throwable, message: String, vararg args: Any) {
        log(LogLevel.Warn) {
            log.e(tag, throwable, if (args.isEmpty()) message else String.format(message, *args))
        }
    }

    fun e(tag: String, throwable: Throwable) {
        log(LogLevel.Warn) {
            log.e(tag, throwable)
        }
    }
}

