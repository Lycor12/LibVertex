package com.libvertex.math.util.curve;

public class ExponentialCurve {
    private float base;
    private float rate;

    public ExponentialCurve(float base, float rate) {
        this.base = base;
        this.rate = rate;
    }

    // Calculates the value of the exponential curve at parameter t
    public float calculate(float t) {
        return base * (float)Math.pow(Math.E, rate * t);
    }
}
