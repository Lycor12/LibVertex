package com.libvertex.geometry;

import com.libvertex.render.Mesh;

import java.util.ArrayList;
import java.util.List;

public class Polygon2D extends Mesh {
    public Polygon2D(int sides, float radius) {
        super(generatePolygon2DVertices(sides, radius));
    }

    private static float[] generatePolygon2DVertices(int sides, float radius) {
        List<Float> vertices = new ArrayList<>();
        for (int i = 0; i < sides; i++) {
            double angle = 2 * Math.PI * i / sides;
            float x = (float) (radius * Math.cos(angle));
            float y = (float) (radius * Math.sin(angle));
            vertices.add(x);
            vertices.add(y);
        }
        return vertices.stream().mapToFloat(f -> f).toArray();
    }
}

