package com.libvertex.math.util;

public class TimeHelper {
    private static long lastTime = System.nanoTime();
    private static double deltaTime = 0;

    public static void update() {
        long currentTime = System.nanoTime();
        deltaTime = (currentTime - lastTime) / 1000000000.0;
        lastTime = currentTime;
    }

    public static double getDeltaTime() {
        return deltaTime;
    }

    public static void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
