package net.nomia.utils.logger.impl

import net.nomia.utils.logger.Loggable

/**
 * The ConsoleLogger class is an implementation of the Loggable interface. 
 */
open class ConsoleLogger : Loggable {

    override fun t(tag: String, message: String) = println("$tag $message")

    override fun d(tag: String, message: String) = t(tag, message)

    override fun i(tag: String, message: String) = t(tag, message)

    override fun w(tag: String, message: String) = t(tag, message)

    override fun e(tag: String, throwable: Throwable) {
        e(tag, throwable, throwable.message ?: throwable.javaClass.simpleName)
    }

    override fun e(tag: String, throwable: Throwable, message: String) {
        System.err.println("$tag $message")
        throwable.printStackTrace()
    }
}
