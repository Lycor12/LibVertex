package com.libvertex.math.util;

import org.joml.Vector3f;

public class GeometryUtils {

    public static float distance(Vector3f point1, Vector3f point2) {
        return point1.distance(point2);
    }

    public static boolean isPointInsideCircle(Vector3f point, Vector3f center, float radius) {
        return distance(point, center) <= radius;
    }
}
