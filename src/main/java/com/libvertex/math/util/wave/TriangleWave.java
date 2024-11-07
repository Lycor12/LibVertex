package com.libvertex.math.util.wave;

public class TriangleWave {
    private float amplitude;
    private float frequency;

    public TriangleWave(float amplitude, float frequency) {
        this.amplitude = amplitude;
        this.frequency = frequency;
    }

    public float calculate(float time) {
        return amplitude * (float)(2 * Math.abs(2 * (time * frequency - Math.floor(time * frequency + 0.5))) - 1);
    }
}
