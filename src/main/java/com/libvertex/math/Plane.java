package com.libvertex.math;

import org.joml.Matrix4f;
import org.joml.Vector3f;

public class Plane {
    private Vector3f normal;
    private float distance;

    public Plane(Vector3f normal, float distance) {
        this.normal = normal;
        this.distance = distance;
    }

    public float distanceToPoint(Vector3f point) {
        return normal.dot(point) + distance;
    }

    public static Plane[] extractPlanes(Matrix4f combinedMatrix) {
        Plane[] planes = new Plane[6];
        Vector3f normal;
        float distance;

        // Left plane
        normal = new Vector3f(combinedMatrix.m30() + combinedMatrix.m00(), combinedMatrix.m31() + combinedMatrix.m01(), combinedMatrix.m32() + combinedMatrix.m02());
        distance = combinedMatrix.m33() + combinedMatrix.m03();
        planes[0] = new Plane(normal.normalize(), distance);

        // Right plane
        normal = new Vector3f(combinedMatrix.m30() - combinedMatrix.m00(), combinedMatrix.m31() - combinedMatrix.m01(), combinedMatrix.m32() - combinedMatrix.m02());
        distance = combinedMatrix.m33() - combinedMatrix.m03();
        planes[1] = new Plane(normal.normalize(), distance);

        // Bottom plane
        normal = new Vector3f(combinedMatrix.m30() + combinedMatrix.m10(), combinedMatrix.m31() + combinedMatrix.m11(), combinedMatrix.m32() + combinedMatrix.m12());
        distance = combinedMatrix.m33() + combinedMatrix.m13();
        planes[2] = new Plane(normal.normalize(), distance);

        // Top plane
        normal = new Vector3f(combinedMatrix.m30() - combinedMatrix.m10(), combinedMatrix.m31() - combinedMatrix.m11(), combinedMatrix.m32() - combinedMatrix.m12());
        distance = combinedMatrix.m33() - combinedMatrix.m13();
        planes[3] = new Plane(normal.normalize(), distance);

        // Near plane
        normal = new Vector3f(combinedMatrix.m30() + combinedMatrix.m20(), combinedMatrix.m31() + combinedMatrix.m21(), combinedMatrix.m32() + combinedMatrix.m22());
        distance = combinedMatrix.m33() + combinedMatrix.m23();
        planes[4] = new Plane(normal.normalize(), distance);

        // Far plane
        normal = new Vector3f(combinedMatrix.m30() - combinedMatrix.m20(), combinedMatrix.m31() - combinedMatrix.m21(), combinedMatrix.m32() - combinedMatrix.m22());
        distance = combinedMatrix.m33() - combinedMatrix.m23();
        planes[5] = new Plane(normal.normalize(), distance);

        return planes;
    }
}
