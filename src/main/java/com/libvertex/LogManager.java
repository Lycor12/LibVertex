package com.libvertex;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * LogManager class handles logging operations for the application.
 * It provides functionality to set a log file name and write log messages to the specified file.
 */
public class LogManager {
    /** The name of the log file to be used */
    private static String filename;
    /** The actual log file path used for writing logs */
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
