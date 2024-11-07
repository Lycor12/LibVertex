package com.libvertex.math.util.curve;

import org.joml.Vector3f;

public class CubicBezierCurve {
    private Vector3f p0, p1, p2, p3;

    public CubicBezierCurve(Vector3f p0, Vector3f p1, Vector3f p2, Vector3f p3) {
        this.p0 = p0;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    // Calculates a point on the cubic Bezier curve at parameter t (0 to 1)
    public Vector3f calculate(float t) {
        float u = 1 - t;
        float tt = t * t;
        float uu = u * u;
        float uuu = uu * u;
        float ttt = tt * t;

        Vector3f point = new Vector3f(p0).mul(uuu);            // u^3 * p0
        point.add(new Vector3f(p1).mul(3 * uu * t));           // 3 * u^2 * t * p1
        point.add(new Vector3f(p2).mul(3 * u * tt));           // 3 * u * t^2 * p2
        point.add(new Vector3f(p3).mul(ttt));                  // t^3 * p3
        return point;
    }
}
