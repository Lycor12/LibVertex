package com.libvertex.math.util.wave;

public class SawtoothWave {
    private float amplitude;
    private float frequency;

    public SawtoothWave(float amplitude, float frequency) {
        this.amplitude = amplitude;
        this.frequency = frequency;
    }

    public float calculate(float time) {
        return (float) (amplitude * (2f * (time * frequency - Math.floor(0.5f + time * frequency))));
    }
}
