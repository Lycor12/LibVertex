package com.libvertex.math.util.curve;

import org.joml.Vector3f;

public class CatmullRomSpline {
    private Vector3f p0, p1, p2, p3;

    public CatmullRomSpline(Vector3f p0, Vector3f p1, Vector3f p2, Vector3f p3) {
        this.p0 = p0;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    // Calculates a point on the Catmull-Rom spline at parameter t
    public Vector3f calculate(float t) {
        float t2 = t * t;
        float t3 = t2 * t;

        return new Vector3f()
                .set(p0).mul(-0.5f * t3 + t2 - 0.5f * t)
                .add(new Vector3f(p1).mul(1.5f * t3 - 2.5f * t2 + 1))
                .add(new Vector3f(p2).mul(-1.5f * t3 + 2.0f * t2 + 0.5f * t))
                .add(new Vector3f(p3).mul(0.5f * t3 - 0.5f * t2));
    }
}
