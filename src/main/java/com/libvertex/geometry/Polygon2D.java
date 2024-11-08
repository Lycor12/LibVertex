
package com.libvertex.geometry;

import com.libvertex.render.Mesh;

import java.util.ArrayList;
import java.util.List;

/**
 * The Polygon2D class creates a 2-dimensional regular polygon mesh.
 * A class representing a 2D polygon shape that extends the Mesh class.
 * This class generates a regular polygon with a specified number of sides and radius.
 */
public class Polygon2D extends Mesh {
    /**
     * Constructs a new Polygon2D with the specified number of sides and radius.
     *
     * @param sides  the number of sides of the polygon
     * @param radius the distance from the center to any vertex of the polygon
     */
    public Polygon2D(int sides, float radius) {
        super(generatePolygon2DVertices(sides, radius));
    }

    /**
     * Generates the vertex coordinates for a regular polygon.
     * The vertices are generated in counter-clockwise order starting from the rightmost point.
     *
     * @param sides  the number of sides of the polygon
     * @param radius the distance from the center to any vertex of the polygon
     * @return an array of float values representing the x and y coordinates of the vertices
     */
    private static float[] generatePolygon2DVertices(int sides, float radius) {
        List<Float> vertices = new ArrayList<>();
        for (int i = 0; i < sides; i++) {
            double angle = 2 * Math.PI * i / sides;
            float x = (float) (radius * Math.cos(angle));
            float y = (float) (radius * Math.sin(angle));
            vertices.add(x);
            vertices.add(y);
        }
        float[] result = new float[vertices.size()];
        for (int i = 0; i < vertices.size(); i++) {
            result[i] = vertices.get(i);
        }
        return result;
    }
}
