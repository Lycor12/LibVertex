package com.libvertex.math.util.curve;

import org.joml.Vector3f;

public class HermiteSpline {
    private Vector3f p0, p1, m0, m1;  // Endpoints and tangents

    public HermiteSpline(Vector3f p0, Vector3f m0, Vector3f p1, Vector3f m1) {
        this.p0 = p0;
        this.p1 = p1;
        this.m0 = m0;
        this.m1 = m1;
    }

    // Calculates a point on the Hermite spline at parameter t
    public Vector3f calculate(float t) {
        float t2 = t * t;
        float t3 = t2 * t;
        float h00 = 2 * t3 - 3 * t2 + 1;
        float h10 = t3 - 2 * t2 + t;
        float h01 = -2 * t3 + 3 * t2;
        float h11 = t3 - t2;

        return new Vector3f()
                .set(p0).mul(h00)
                .add(new Vector3f(m0).mul(h10))
                .add(new Vector3f(p1).mul(h01))
                .add(new Vector3f(m1).mul(h11));
    }
}
