package com.libvertex.math.util.wave;

public class SineWave {
    private float amplitude;
    private float frequency;
    private float phase;

    public SineWave(float amplitude, float frequency, float phase) {
        this.amplitude = amplitude;
        this.frequency = frequency;
        this.phase = phase;
    }

    public float calculate(float time) {
        return amplitude * (float)Math.sin(2 * Math.PI * frequency * time + phase);
    }
}
