package com.libvertex;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LogManager {
    private static String filename;
    private static String LOG_FILE = filename;

    public static void setLogFilename(String filename) {
        LogManager.filename = filename;
    }

    public static void log(String message) {
        try (PrintWriter out = new PrintWriter(new FileWriter(LOG_FILE, true))) {
            out.println(message);
        } catch (IOException e) {
            System.err.println("Failed to write to log file: " + e.getMessage());
        }
    }
}
