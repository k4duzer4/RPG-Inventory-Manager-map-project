package utils;

import java.util.ArrayList;
import java.util.List;

public class Logger {
    private static final List<String> logs = new ArrayList<>();

    public static void log(String message) {
        logs.add(message);
    }

    public static void printLogs() {
        logs.forEach(System.out::println);
    }
}
