package com.libvertex;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import com.libvertex.vertex.render.RenderProfiler;

public class DebugOverlay {
    private RenderProfiler profiler;
    private LogManager logManager;

    public DebugOverlay(RenderProfiler profiler) {
        this.profiler = profiler;
        this.logManager = new LogManager();
    }

    public void displayOverlay() {
        System.out.println("Frame time: " + profiler.getFrameTime() + " ms");
        System.out.println("Draw calls: " + profiler.getDrawCalls());
        System.out.println("Memory usage: " + getMemoryUsage() + " MB");
    }

    public void handleCrash(Exception e) {
        String errorDetails = "Error: " + e.getMessage() + "\nStack Trace:\n";
        for (StackTraceElement element : e.getStackTrace()) {
            errorDetails += element.toString() + "\n";
        }
        String systemInfo = "System specs:\n" + getSystemInfo();
        LogManager.log(errorDetails + systemInfo);
        System.err.println("A critical error occurred. Check log for details.");
    }

    private String getMemoryUsage() {
        MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage heapMemoryUsage = memoryBean.getHeapMemoryUsage();
        long usedMemory = heapMemoryUsage.getUsed() / (1024 * 1024);
        return usedMemory + " MB";
    }

    private String getSystemInfo() {
        return "OS: " + System.getProperty("os.name") + "\n"
                + "OS Version: " + System.getProperty("os.version") + "\n"
                + "Architecture: " + System.getProperty("os.arch") + "\n";
    }
}
