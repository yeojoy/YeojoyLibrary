package me.yeojoy.yeojoylibrary.log;

import android.util.Log;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;

/**
 * Created by yeojoy on 15. 7. 15..
 */
public class MyLog {

    // Debug
    public static void d(String tag, String message) {
        Log.d(tag, getLoggerLocation() + message);
    }

    public static void d(String tag) {
        Log.d(tag, getLoggerLocation());
    }

    // Warning
    public static void w(String tag, String message) {
        Log.w(tag, getLoggerLocation() + message);
    }

    public static void w(String tag) {
        Log.w(tag, getLoggerLocation());
    }

    // Info
    public static void i(String tag, String message) {
        Log.i(tag, getLoggerLocation() + message);
    }

    public static void i(String tag) {
        Log.i(tag, getLoggerLocation());
    }


    // Error
    public static void e(String tag, String message) {
        Log.e(tag, getLoggerLocation() + message);
    }

    public static void e(String tag) {
        Log.e(tag, getLoggerLocation());
    }

    // using Throwable
    // Debug
    public static void d(String tag, Throwable tr) {
        Log.d(tag, getLoggerLocation() + getStackTraceString(tr));
    }

    // Warning
    public static void w(String tag, Throwable tr) {
        Log.w(tag, getLoggerLocation() + getStackTraceString(tr));
    }

    // Info
    public static void i(String tag, Throwable tr) {
        Log.i(tag, getLoggerLocation() + getStackTraceString(tr));
    }

    // Error
    public static void e(String tag, Throwable tr) {
        Log.e(tag, getLoggerLocation() + getStackTraceString(tr));
    }

    /**
     * Class 이름, method이름, line number를 가져옴.
     * @return
     */
    private static String getLoggerLocation() {
        StackTraceElement ste = Thread.currentThread().getStackTrace()[4];
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(ste.getFileName().substring(0, ste.getFileName().indexOf(".")));
        sb.append(" > ");
        sb.append(ste.getMethodName());
        sb.append(" > #");
        sb.append(ste.getLineNumber());
        sb.append("] ");

        return sb.toString();
    }

    /**
     * Throwable에 있는 Error message를 가져옴
     * @param tr
     * @return
     */
    private static String getStackTraceString(Throwable tr) {
        if (tr == null) {
            return "";
        }

        // This is to reduce the amount of log spew that apps do in the non-error
        // condition of the network being unavailable.
        Throwable t = tr;
        while (t != null) {
            if (t instanceof UnknownHostException) {
                return "";
            }
            t = t.getCause();
        }

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        tr.printStackTrace(pw);
        pw.flush();
        return sw.toString();
    }
}
