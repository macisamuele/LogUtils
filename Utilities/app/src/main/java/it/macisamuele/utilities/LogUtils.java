/**
 * Copyright 2015 Samuele Maci (macisamuele@gmail.com)
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package it.macisamuele.utilities;

import android.util.Log;

/**
 * <p>
 * Simple wrapper that calls the standard logging system provided by android.utils.Log which
 * adds information about the filename and the line from which is called the logging function.
 * </p>
 * <p>
 * The wrapper exposes all the methods offered by the Android logging system.
 * </p>
 * <p>
 * The format of the methods is {@code LogUtils.*(Object obj, Object message)} or
 * {@code LogUtils.*(Object obj, Object msg, Throwable t)} where:
 * - {@code obj} is the usual TAG of the Android logging system ({@code obj instanceof CharSequence}) otherwise the TAG passed to the Android logging system is the class name (obtained from {@code obj.getClass().getClassName())}
 * - {@code message} is the message to inject in the log. It can be any kind of object and the message passed to the logging system is {@code message.toString()}
 * - {@code t} is the throwable to print in the log message
 * </p>
 * The calling messageategy implies all the drawbacks of the Android logging system with some additional effort to reach the right calling file and line.
 *
 * @author Samuele Maci (macisamuele@gmail.com)
 * @see android.util.Log
 */
public class LogUtils {

    private LogUtils() {
        throw new UnsupportedOperationException("Cannot initialize " + getClass().getCanonicalName() + " class");
    }

    /**
     * @return well formatted messageing with the information of the caller
     */
    @SuppressWarnings("StatementWithEmptyBody")
    private static String addCallerInformation() {
        int i, lio; //lio = lastIndexOf
        StackTraceElement stack[] = Thread.currentThread().getStackTrace();
        for (i = 0; !stack[i].getClassName().equals(LogUtils.class.getName()); i++) {
        }
        for (; stack[i].getClassName().equals(LogUtils.class.getName()); i++) {
        }
        lio = stack[i].getFileName().lastIndexOf('.');
        if (lio == -1) {
            return " (" + stack[i].getFileName() + ":" + stack[i].getLineNumber() + ")";
        } else {
            return " (" + stack[i].getFileName().substring(0, lio) + ":" + stack[i].getLineNumber() + ")";
        }
    }

    /**
     * Calls {@code android.util.Log.i(tag, message)}
     * where {@code tag} is {@code obj} if is an instance of String otherwise the class name of {@code obj}
     *
     * @param obj     TAG of the log entry, if {@code obj instanceof CharSequence} than {@code obj} will be the TAG otherwise {@code obj.getSimpleName()} will be the TAG
     * @param message The message you would like logged.
     * @see android.util.Log#i(String, String)
     */
    public static void i(Object obj, Object message) {
        if (obj != null && message != null) {
            Log.i(obj instanceof CharSequence ? obj.toString() : obj.getClass().getSimpleName(), message.toString().trim() + addCallerInformation());
        }

    }

    /**
     * Calls {@code android.util.Log.e(tag, message)}
     * where {@code tag} is {@code obj} if is an instance of String otherwise the class name of {@code obj}
     *
     * @param obj     TAG of the log entry, if {@code obj instanceof CharSequence} than {@code obj} will be the TAG otherwise {@code obj.getSimpleName()} will be the TAG
     * @param message The message you would like logged.
     * @see android.util.Log#i(String, String)
     */
    public static void e(Object obj, Object message) {
        if (obj != null && message != null) {
            Log.e(obj instanceof CharSequence ? obj.toString() : obj.getClass().getSimpleName(), message.toString().trim() + addCallerInformation());
        }
    }

    /**
     * Calls {@code android.util.Log.d(tag, message)}
     * where {@code tag} is {@code obj} if is an instance of String otherwise the class name of {@code obj}
     *
     * @param obj     TAG of the log entry, if {@code obj instanceof CharSequence} than {@code obj} will be the TAG otherwise {@code obj.getSimpleName()} will be the TAG
     * @param message The message you would like logged.
     * @see android.util.Log#i(String, String)
     */
    public static void d(Object obj, Object message) {
        if (obj != null && message != null) {
            Log.d(obj instanceof CharSequence ? obj.toString() : obj.getClass().getSimpleName(), message.toString().trim() + addCallerInformation());
        }
    }

    /**
     * Calls {@code android.util.Log.v(tag, message)}
     * where {@code tag} is {@code obj} if is an instance of String otherwise the class name of {@code obj}
     *
     * @param obj     TAG of the log entry, if {@code obj instanceof CharSequence} than {@code obj} will be the TAG otherwise {@code obj.getSimpleName()} will be the TAG
     * @param message The message you would like logged.
     * @see android.util.Log#i(String, String)
     */
    public static void v(Object obj, Object message) {
        if (obj != null && message != null) {
            Log.v(obj instanceof CharSequence ? obj.toString() : obj.getClass().getSimpleName(), message.toString().trim() + addCallerInformation());
        }
    }

    /**
     * Calls {@code android.util.Log.w(tag, message)}
     * where {@code tag} is {@code obj} if is an instance of String otherwise the class name of {@code obj}
     *
     * @param obj     TAG of the log entry, if {@code obj instanceof CharSequence} than {@code obj} will be the TAG otherwise {@code obj.getSimpleName()} will be the TAG
     * @param message The message you would like logged.
     * @see android.util.Log#i(String, String)
     */
    public static void w(Object obj, Object message) {
        if (obj != null && message != null) {
            Log.w(obj instanceof CharSequence ? obj.toString() : obj.getClass().getSimpleName(), message.toString().trim() + addCallerInformation());
        }
    }

    /**
     * Calls {@code android.util.Log.wtf(tag, message)}
     * where {@code tag} is {@code obj} if is an instance of String otherwise the class name of {@code obj}
     *
     * @param obj     TAG of the log entry, if {@code obj instanceof CharSequence} than {@code obj} will be the TAG otherwise {@code obj.getSimpleName()} will be the TAG
     * @param message The message you would like logged.
     * @see android.util.Log#i(String, String)
     */
    public static void wtf(Object obj, Object message) {
        if (obj != null && message != null) {
            Log.wtf(obj instanceof CharSequence ? obj.toString() : obj.getClass().getSimpleName(), message.toString().trim() + addCallerInformation());
        }
    }


    /**
     * Calls {@code android.util.Log.i(tag, message)}
     * where {@code tag} is {@code obj} if is an instance of String otherwise the class name of {@code obj}
     *
     * @param obj     TAG of the log entry, if {@code obj instanceof CharSequence} than {@code obj} will be the TAG otherwise {@code obj.getSimpleName()} will be the TAG
     * @param message The message you would like logged.
     * @param t       exception to log
     * @see android.util.Log#i(String, String)
     */
    public static void i(Object obj, Object message, Throwable t) {
        if (obj != null && message != null) {
            Log.i(obj instanceof CharSequence ? obj.toString() : obj.getClass().getSimpleName(), message.toString().trim() + addCallerInformation(), t);
        }

    }

    /**
     * Calls {@code android.util.Log.e(tag, message)}
     * where {@code tag} is {@code obj} if is an instance of String otherwise the class name of {@code obj}
     *
     * @param obj     TAG of the log entry, if {@code obj instanceof CharSequence} than {@code obj} will be the TAG otherwise {@code obj.getSimpleName()} will be the TAG
     * @param message The message you would like logged.
     * @param t       exception to log
     * @see android.util.Log#i(String, String)
     */
    public static void e(Object obj, Object message, Throwable t) {
        if (obj != null && message != null) {
            Log.e(obj instanceof CharSequence ? obj.toString() : obj.getClass().getSimpleName(), message.toString().trim() + addCallerInformation(), t);
        }
    }

    /**
     * Calls {@code android.util.Log.d(tag, message)}
     * where {@code tag} is {@code obj} if is an instance of String otherwise the class name of {@code obj}
     *
     * @param obj     TAG of the log entry, if {@code obj instanceof CharSequence} than {@code obj} will be the TAG otherwise {@code obj.getSimpleName()} will be the TAG
     * @param message The message you would like logged.
     * @param t       exception to log
     * @see android.util.Log#i(String, String)
     */
    public static void d(Object obj, Object message, Throwable t) {
        if (obj != null && message != null) {
            Log.d(obj instanceof CharSequence ? obj.toString() : obj.getClass().getSimpleName(), message.toString().trim() + addCallerInformation(), t);
        }
    }

    /**
     * Calls {@code android.util.Log.v(tag, message)}
     * where {@code tag} is {@code obj} if is an instance of String otherwise the class name of {@code obj}
     *
     * @param obj     TAG of the log entry, if {@code obj instanceof CharSequence} than {@code obj} will be the TAG otherwise {@code obj.getSimpleName()} will be the TAG
     * @param message The message you would like logged.
     * @param t       exception to log
     * @see android.util.Log#i(String, String)
     */
    public static void v(Object obj, Object message, Throwable t) {
        if (obj != null && message != null) {
            Log.v(obj instanceof CharSequence ? obj.toString() : obj.getClass().getSimpleName(), message.toString().trim() + addCallerInformation(), t);
        }
    }

    /**
     * Calls {@code android.util.Log.w(tag, message)}
     * where {@code tag} is {@code obj} if is an instance of String otherwise the class name of {@code obj}
     *
     * @param obj     TAG of the log entry, if {@code obj instanceof CharSequence} than {@code obj} will be the TAG otherwise {@code obj.getSimpleName()} will be the TAG
     * @param message The message you would like logged.
     * @param t       exception to log
     * @see android.util.Log#i(String, String)
     */
    public static void w(Object obj, Object message, Throwable t) {
        if (obj != null && message != null) {
            Log.w(obj instanceof CharSequence ? obj.toString() : obj.getClass().getSimpleName(), message.toString().trim() + addCallerInformation(), t);
        }
    }

    /**
     * Calls {@code android.util.Log.wtf(tag, message)}
     * where {@code tag} is {@code obj} if is an instance of String otherwise the class name of {@code obj}
     *
     * @param obj     TAG of the log entry, if {@code obj instanceof CharSequence} than {@code obj} will be the TAG otherwise {@code obj.getSimpleName()} will be the TAG
     * @param message The message you would like logged.
     * @param t       exception to log
     * @see android.util.Log#i(String, String)
     */
    public static void wtf(Object obj, Object message, Throwable t) {
        if (obj != null && message != null) {
            Log.wtf(obj instanceof CharSequence ? obj.toString() : obj.getClass().getSimpleName(), message.toString().trim() + addCallerInformation(), t);
        }
    }
}