package com.libvertex.geometry;
import com.libvertex.render.Mesh;

import java.util.ArrayList;
import java.util.List;

public class Cylinder extends Mesh {
    public Cylinder(float radius, float height, int segments) {
        super(generateCylinderVertices(radius, height, segments));
    }

    private static float[] generateCylinderVertices(float radius, float height, int segments) {
        List<Float> vertices = new ArrayList<>();
        float halfHeight = height / 2;

        for (int i = 0; i <= segments; i++) {
            double angle = 2 * Math.PI * i / segments;
            float x = (float) (radius * Math.cos(angle));
            float z = (float) (radius * Math.sin(angle));

            // Top circle
            vertices.add(x);
            vertices.add(halfHeight);
            vertices.add(z);

            // Bottom circle
            vertices.add(x);
            vertices.add(-halfHeight);
            vertices.add(z);
        }
        return vertices.stream().mapToFloat(f -> f).toArray();
    }
}

