package com.libvertex.vertex.render;


import com.libvertex.LogManager;

public class RenderProfiler {
    private long frameStartTime;
    private float frameTime;
    private int drawCalls;

    public void startProfiling() {
        frameStartTime = System.nanoTime();
        drawCalls = 0; // Reset draw calls count each frame
    }

    public void endProfiling() {
        frameTime = (System.nanoTime() - frameStartTime) / 1_000_000.0f;
    }

    public void logFrameData() {
        LogManager.log("Frame time: " + frameTime + " ms");
        LogManager.log("Draw calls: " + drawCalls);
    }

    public void incrementDrawCalls() {
        drawCalls++;
    }

    public int getDrawCalls() {
        return drawCalls;
    }

    public float getFrameTime() {
        return frameTime;
    }
}
