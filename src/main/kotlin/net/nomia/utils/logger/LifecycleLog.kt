package net.nomia.utils.logger

internal object LifecycleLog {
    // TAG: methodName [Thread] > onLifecycle
    fun d(tag: String, methodName: String, lifecycleName: String) {
        Logger.d(tag, "%s [%s] > %s", methodName, Thread.currentThread().name, lifecycleName)
    }

    // TAG: methodName [Thread] > onLifecycle: value
    fun d(tag: String, methodName: String, lifecycleName: String, arg: Any) {
        Logger.d(tag, "%s [%s] > %s: %s", methodName, Thread.currentThread().name, lifecycleName, arg)
    }

    // TAG: [Thread]: onError
    fun e(tag: String, methodName: String, throwable: Throwable) {
        Logger.e(tag, throwable, "%s [%s] > onError", methodName, Thread.currentThread().name)
    }
}
