package com.libvertex.math.util.curve;

public class SinusoidalCurve {
    private float amplitude;
    private float frequency;
    private float phase;

    public SinusoidalCurve(float amplitude, float frequency, float phase) {
        this.amplitude = amplitude;
        this.frequency = frequency;
        this.phase = phase;
    }

    public float calculate(float t) {
        return amplitude * (float)Math.sin(2 * Math.PI * frequency * t + phase);
    }
}
