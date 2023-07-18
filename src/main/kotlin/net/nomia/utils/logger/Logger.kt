package net.nomia.utils.logger

import net.nomia.utils.logger.impl.ConsoleLogger

object Logger {
    private var log: Loggable = ConsoleLogger()
    private var level: LogLevel = LogLevel.Debug

    fun setLogger(logger: Loggable) {
        log = logger
    }

    fun setLevel(logLevel: LogLevel) {
        level = logLevel
    }

    fun t(tag: String, message: String, vararg args: Any){
        log(LogLevel.Trace) {
            log.t(tag, message = if (args.isEmpty()) message else String.format(message, *args))
        }
    }

    fun t(tag: String, lazyMessage: () -> String) {
        log(LogLevel.Trace) {
            log.t(tag, message = lazyMessage.invoke())
        }
    }

    fun d(tag: String, message: String, vararg args: Any) {
        log(LogLevel.Debug) {
            log.d(tag, message = if (args.isEmpty()) message else String.format(message, *args))
        }
    }

    fun d(tag: String, lazyMessage: () -> String) {
        log(LogLevel.Debug) {
            log.d(tag, message = lazyMessage.invoke())
        }
    }

    fun i(tag: String, message: String, vararg args: Any) {
        log(LogLevel.Info) {
            log.i(tag, message = if (args.isEmpty()) message else String.format(message, *args))
        }
    }

    fun w(tag: String, message: String, vararg args: Any) {
        log(LogLevel.Warn) {
            log.w(tag, message = if (args.isEmpty()) message else String.format(message, *args))
        }
    }

    fun e(tag: String, throwable: Throwable, message: String, vararg args: Any) {
        log(LogLevel.Warn) {
            log.e(tag, throwable, message = if (args.isEmpty()) message else String.format(message, *args))
        }
    }

    fun e(tag: String, throwable: Throwable) {
        log(LogLevel.Warn) {
            log.e(tag, throwable)
        }
    }

    private inline fun log(targetLevel: LogLevel, block: () -> Unit) {
        if (level.value >= targetLevel.value) {
            block.invoke()
        }
    }
}

