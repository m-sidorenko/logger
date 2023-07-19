package src.coroutine

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onEmpty
import kotlinx.coroutines.flow.onStart
import src.Logger.d
import src.LifecycleLog.e

/**
 * The `log` function is an extension function for the `Flow` class in Kotlin coroutines. 
 * It is used to add logging statements to a flow, allowing you to observe 
 * the flow's behavior during runtime. 
 *  
 * @param tag A string representing the tag or label for the log message.
 * @param name A name of the flow.
 */
fun <T> Flow<T>.log(
    tag: String,
    name: String,
    withValue: Boolean = true,
    valueMapper: (T) -> Any? = { it }
): Flow<T> {
    return this
        .onStart {
            d(tag, name, "onStart")
        }
        .onEach { value ->
            if (withValue) {
                d(tag, name, "onEach", valueMapper(value) ?: "null")
            } else {
                d(tag, name, "onEach")
            }
        }
        .onCompletion { throwable ->
            when (throwable) {
                null -> d(tag, name, "onCompleted")
                is CancellationException -> d(tag, name, "onCancelled")
                else -> e(tag, name, throwable)
            }
        }
        .onEmpty {
            d(tag, name, "onEmpty")
        }
}
