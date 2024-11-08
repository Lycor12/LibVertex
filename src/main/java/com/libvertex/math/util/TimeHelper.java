package com.libvertex.math.util;

public class TimeHelper {
    private static long lastTime = System.nanoTime();
    private static double deltaTime = 0;
    private static int frameCount = 0;
    private static double fps = 0;
    private static double fpsTimeAccumulator = 0;
    private static long startTime = System.nanoTime();

    public static void update() {
        long currentTime = System.nanoTime();
        deltaTime = (currentTime - lastTime) / 1000.0;
        lastTime = currentTime;

        frameCount++;
        fpsTimeAccumulator += deltaTime;
        // Update FPS every second
        double fpsUpdateInterval = 1.0;
        if (fpsTimeAccumulator >= fpsUpdateInterval) {
            fps = frameCount / fpsTimeAccumulator;
            frameCount = 0;
            fpsTimeAccumulator = 0;
        }
    }

    public static double getFPS() {
        return fps;
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

    public static double getElapsedTime() {
            return (System.nanoTime() - startTime) / 1000.0;
    }
    public static double secondsToMilliseconds(double seconds) {
        return seconds * 1000;
    }
    public static double millisecondsToSeconds(double milliseconds) {
        return milliseconds / 1000;
    }
    public static double secondsToNanoseconds(double seconds) {
        return seconds * 1000000000;
    }
    public static double nanosecondsToSeconds(double nanoseconds) {
        return nanoseconds / 1000000000;
    }
    public static class Timer {
        private long startTime;
        private long duration;

        public Timer(long duration) {
            this.duration = duration;
            this.startTime = System.nanoTime();
        }

        public boolean hasElapsed() {
            return (System.nanoTime() - startTime) >= duration * 1000000;
        }

        public void reset() {
            this.startTime = System.nanoTime();
        }
        private static boolean isPaused = false;
        private static long pauseTime = 0;

        public static void pause() {
            if (!isPaused) {
                pauseTime = System.nanoTime();
                isPaused = true;
            }
        }

        public static void resume() {
            if (isPaused) {
                long timerCurrentTime = System.nanoTime();
                int timerLastTime = 0;
                timerLastTime += (timerCurrentTime - pauseTime);
                isPaused = false;
            }
        }

        public static boolean isPaused() {
            return isPaused;
        }

    }

}
