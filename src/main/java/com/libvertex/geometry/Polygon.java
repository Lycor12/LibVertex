
package com.libvertex.geometry;

import com.libvertex.render.Mesh;

import java.util.ArrayList;
import java.util.List;

/**
 * A class representing a regular polygon in 3D space.
 * This class extends the Mesh class and creates a flat polygon with a specified number of sides and radius.
 */
public class Polygon extends Mesh {
    /**
     * Constructs a regular polygon with the specified number of sides and radius.
     *
     * @param sides  the number of sides of the polygon
     * @param radius the distance from the center to any vertex of the polygon
     */
    public Polygon(int sides, float radius) {
        super(generatePolygonVertices(sides, radius));
    }

    /**
     * Generates the vertex coordinates for a regular polygon.
     * The polygon is created on the XZ plane (y = 0) with its center at the origin.
     *
     * @param sides  the number of sides of the polygon
     * @param radius the distance from the center to any vertex of the polygon
     * @return an array of float values representing the vertex coordinates (x, y, z)
     */
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
        float[] result = new float[vertices.size()];
        for (int i = 0; i < vertices.size(); i++) {
            result[i] = vertices.get(i);
        }
        return result;
    }
}