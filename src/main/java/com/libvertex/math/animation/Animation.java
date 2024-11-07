package com.libvertex.math.animation;

import com.libvertex.vertex.transform.Transform;

import java.util.List;

public class Animation {
    private List<Transform> frames;
    private float frameDuration;
    private boolean looping;
    private int currentFrame;
    private float timeAccumulator;

    public Animation(List<Transform> frames, float frameDuration, boolean looping) {
        this.frames = frames;
        this.frameDuration = frameDuration;
        this.looping = looping;
        this.currentFrame = 0;
        this.timeAccumulator = 0;
    }

    public Transform update(float deltaTime) {
        timeAccumulator += deltaTime;
        if (timeAccumulator >= frameDuration) {
            timeAccumulator -= frameDuration;
            currentFrame++;
            if (currentFrame >= frames.size()) {
                currentFrame = looping ? 0 : frames.size() - 1;
            }
        }
        return frames.get(currentFrame);
    }

    public void reset() {
        currentFrame = 0;
        timeAccumulator = 0;
    }

    public boolean isComplete() {
        return !looping && currentFrame == frames.size() - 1;
    }
}
