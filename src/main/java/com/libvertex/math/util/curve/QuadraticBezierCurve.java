package com.libvertex.math.util.curve;

import org.joml.Vector3f;

public class QuadraticBezierCurve {
    private Vector3f p0, p1, p2;

    public QuadraticBezierCurve(Vector3f p0, Vector3f p1, Vector3f p2) {
        this.p0 = p0;
        this.p1 = p1;
        this.p2 = p2;
    }

    public Vector3f calculate(float t) {
        float u = 1 - t;
        float tt = t * t;
        float uu = u * u;

        Vector3f point = new Vector3f(p0).mul(uu);           // u^2 * p0
        point.add(new Vector3f(p1).mul(2 * u * t));          // 2 * u * t * p1
        point.add(new Vector3f(p2).mul(tt));                 // t^2 * p2
        return point;
    }
}
