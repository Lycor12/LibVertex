package com.libvertex.geometry;

import com.libvertex.render.Mesh;

import java.util.ArrayList;
import java.util.List;

public class Polygon extends Mesh {
    public Polygon(int sides, float radius) {
        super(generatePolygonVertices(sides, radius));
    }

    private static float[] generatePolygonVertices(int sides, float radius) {
        List<Float> vertices = new ArrayList<>();
        for (int i = 0; i < sides; i++) {
            double angle = 2 * Math.PI * i / sides;
            float x = (float) (radius * Math.cos(angle));
            float z = (float) (radius * Math.sin(angle));
            vertices.add(x);
            vertices.add(0f);  // y-coordinate for flat polygon
            vertices.add(z);
        }
        return vertices.stream().mapToFloat(f -> f).toArray();
    }
}
