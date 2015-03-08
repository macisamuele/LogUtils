package it.macisamuele.utilities;

import android.util.Log;

/**
 * A simple wrapper of android.util.log that allows to have well formatted log
 * (adding at the end of the string some information about the line of the source that
 * calls the log function)
 *
 * @author Samuele Maci (macisamuele@gmail.com)
 */
public class LogUtils {

    private LogUtils() {
        throw new UnsupportedOperationException("Cannot initialize " + getClass().getCanonicalName() + " class");
    }

    /**
     * @return well formatted string with the information of the caller
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
     * Calls {@code android.util.Log.i(tag, str)}
     * where {@code tag} is {@code obj} if is an instance of String otherwise the class name of {@code obj}
     *
     * @param obj TAG of the log entry, if {@code obj instanceof String} than {@code obj} will be the TAG otherwise {@code obj.getSimpleName()} will be the TAG
     * @param str message to put in the log
     * @see android.util.Log#i(String, String)
     */
    public static void i(Object obj, Object str) {
        if (obj != null && str != null) {
            Log.i(obj instanceof String ? (String) obj : obj.getClass().getSimpleName(), str.toString().trim() + addCallerInformation());
        }

    }

    /**
     * Calls {@code android.util.Log.e(tag, str)}
     * where {@code tag} is {@code obj} if is an instance of String otherwise the class name of {@code obj}
     *
     * @param obj TAG of the log entry, if {@code obj instanceof String} than {@code obj} will be the TAG otherwise {@code obj.getSimpleName()} will be the TAG
     * @param str message to put in the log
     * @see android.util.Log#i(String, String)
     */
    public static void e(Object obj, Object str) {
        if (obj != null && str != null) {
            Log.e(obj instanceof String ? (String) obj : obj.getClass().getSimpleName(), str.toString().trim() + addCallerInformation());
        }
    }

    /**
     * Calls {@code android.util.Log.d(tag, str)}
     * where {@code tag} is {@code obj} if is an instance of String otherwise the class name of {@code obj}
     *
     * @param obj TAG of the log entry, if {@code obj instanceof String} than {@code obj} will be the TAG otherwise {@code obj.getSimpleName()} will be the TAG
     * @param str message to put in the log
     * @see android.util.Log#i(String, String)
     */
    public static void d(Object obj, Object str) {
        if (obj != null && str != null) {
            Log.d(obj.getClass().getSimpleName(), str.toString().trim() + addCallerInformation());
        }
    }

    /**
     * Calls {@code android.util.Log.v(tag, str)}
     * where {@code tag} is {@code obj} if is an instance of String otherwise the class name of {@code obj}
     *
     * @param obj TAG of the log entry, if {@code obj instanceof String} than {@code obj} will be the TAG otherwise {@code obj.getSimpleName()} will be the TAG
     * @param str message to put in the log
     * @see android.util.Log#i(String, String)
     */
    public static void v(Object obj, Object str) {
        if (obj != null && str != null) {
            Log.v(obj instanceof String ? (String) obj : obj.getClass().getSimpleName(), str.toString().trim() + addCallerInformation());
        }
    }

    /**
     * Calls {@code android.util.Log.w(tag, str)}
     * where {@code tag} is {@code obj} if is an instance of String otherwise the class name of {@code obj}
     *
     * @param obj TAG of the log entry, if {@code obj instanceof String} than {@code obj} will be the TAG otherwise {@code obj.getSimpleName()} will be the TAG
     * @param str message to put in the log
     * @see android.util.Log#i(String, String)
     */
    public static void w(Object obj, Object str) {
        if (obj != null && str != null) {
            Log.w(obj instanceof String ? (String) obj : obj.getClass().getSimpleName(), str.toString().trim() + addCallerInformation());
        }
    }

    /**
     * Calls {@code android.util.Log.wtf(tag, str)}
     * where {@code tag} is {@code obj} if is an instance of String otherwise the class name of {@code obj}
     *
     * @param obj TAG of the log entry, if {@code obj instanceof String} than {@code obj} will be the TAG otherwise {@code obj.getSimpleName()} will be the TAG
     * @param str message to put in the log
     * @see android.util.Log#i(String, String)
     */
    public static void wtf(Object obj, Object str) {
        if (obj != null && str != null) {
            Log.wtf(obj instanceof String ? (String) obj : obj.getClass().getSimpleName(), str.toString().trim() + addCallerInformation());
        }
    }
}