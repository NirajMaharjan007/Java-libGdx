package project.misc;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {
    private final static Log INSTANCE = new Log();

    private PrintStream debugOutputStream;

    private Log() {
        try {
            debugOutputStream = new PrintStream(new FileOutputStream("./debug_log.log", true));
            debugOutputStream.println("Date_Time:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                    .format(new Date()));
        } catch (Exception e) {
            System.err.println("Log: " + e.getMessage() + "\n"
                    + e.getCause());
        }
    }

    public static Log getInstance() {
        return INSTANCE;
    }

    public void setLog(String log) {
        debugOutputStream.println(log);
    }

    public boolean check() {
        return debugOutputStream.checkError();
    }
}
