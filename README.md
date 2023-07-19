# logger ✍️
Kotlin logger, that can work with Flow. By default, the library uses console logging, but you can set your own way of logging.

- ### You can find a usage example in the file [`example.kt`](src/main/kotlin/example.kt)
- ### The library allows you to work with custom loggers:
  You need to implement the [`Loggable`](src/main/kotlin/src/Loggable.kt) interface, and then pass the object of the created class to the `setLogger(logger: Loggable)` method
