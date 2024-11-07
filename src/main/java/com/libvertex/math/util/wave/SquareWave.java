package com.libvertex.math.util.wave;

public class SquareWave {
    private float amplitude;
    private float frequency;

    public SquareWave(float amplitude, float frequency) {
        this.amplitude = amplitude;
        this.frequency = frequency;
    }

    public float calculate(float time) {
        return (Math.sin(2 * Math.PI * frequency * time) >= 0) ? amplitude : -amplitude;
    }
}
