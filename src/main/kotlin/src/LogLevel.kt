package src

/**
 * The enumeration of log levels with the priority
 */
enum class LogLevel(val value: Int) {
    Trace(5),
    Debug(4),
    Info(3),
    Warn(2),
    Error(1),
    Disabled(0),
}
