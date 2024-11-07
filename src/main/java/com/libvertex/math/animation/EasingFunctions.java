package com.libvertex.math.animation;

public class EasingFunctions {
    public static float easeInQuad(float t) {
        return t * t;
    }

    public static float easeOutQuad(float t) {
        return t * (2 - t);
    }

    public static float easeInOutQuad(float t) {
        return t < 0.5 ? 2 * t * t : -1 + (4 - 2 * t) * t;
    }
}
