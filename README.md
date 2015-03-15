# LogUtils
A simple wrapper of android.util.log that allows to have well formatted log

Simple wrapper that calls the standard logging system provided by `android.utils.Log` which adds information about the filename and the line from which is called the logging function.

This wrapper exposes **all** the methods offered by the Android logging system.

The format of the methods is `LogUtils.*(Object obj, Object message)` or `LogUtils.*(Object obj, Object msg, Throwable t)` where:
 - `obj` is the usual *TAG* of the Android logging system (if `obj instanceof String`) otherwise the *TAG* passed to the Android logging system is the class name (obtained from `obj.getClassName()`)
 - `msg` is the message to inject in the log. It can be any kind of object and the message passed to the logging system is `msg.toString()`
 - `t` is the throwable to print in the log message

The calling strategy implies all the drawbacks of the Android logging system with some additional effort to reach the right calling file and line.

**Anyway** it is a useful library for DEBUGGING pourposes.
