/**
 * A debug overlay class that provides real-time performance metrics and crash handling functionality.
 * This class integrates with the rendering system to display frame times, draw calls, and memory usage,
 * while also providing comprehensive crash logging capabilities.
 */
package com.libvertex;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import com.libvertex.vertex.render.RenderProfiler;

public class DebugOverlay {
    private RenderProfiler profiler;
    private LogManager logManager;

    /**
     * Constructs a new DebugOverlay with the specified render profiler.
     *
     * @param profiler The RenderProfiler instance to monitor rendering performance
     */
    public DebugOverlay(RenderProfiler profiler) {
        this.profiler = profiler;
        this.logManager = new LogManager();
    }

    /**
     * Displays the current performance metrics including frame time, draw calls, and memory usage.
     * This method prints the information to the standard output stream.
     */
    public void displayOverlay() {
        System.out.println("Frame time: " + profiler.getFrameTime() + " ms");
        System.out.println("Draw calls: " + profiler.getDrawCalls());
        System.out.println("Memory usage: " + getMemoryUsage() + " MB");
    }

    /**
     * Handles application crashes by logging detailed error information and system specifications.
     *
     * @param e The Exception that caused the crash
     */
    public void handleCrash(Exception e) {
        String errorDetails = "Error: " + e.getMessage() + "\nStack Trace:\n";
        for (StackTraceElement element : e.getStackTrace()) {
            errorDetails += element.toString() + "\n";
        }
        String systemInfo = "System specs:\n" + getSystemInfo();
        LogManager.log(errorDetails + systemInfo);
        System.err.println("A critical error occurred. Check log for details.");
    }

    /**
     * Retrieves the current heap memory usage of the application.
     *
     * @return A string representing the used heap memory in megabytes
     */
    private String getMemoryUsage() {
        MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage heapMemoryUsage = memoryBean.getHeapMemoryUsage();
        long usedMemory = heapMemoryUsage.getUsed() / (1024 * 1024);
        return usedMemory + " MB";
    }

    /**
     * Retrieves the current system information including OS name, version, and architecture.
     *
     * @return A string containing formatted system information
     */
    private String getSystemInfo() {
        return "OS: " + System.getProperty("os.name") + "\n"
                + "OS Version: " + System.getProperty("os.version") + "\n"
                + "Architecture: " + System.getProperty("os.arch") + "\n";
    }
}
