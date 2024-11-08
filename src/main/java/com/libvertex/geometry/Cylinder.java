package com.libvertex.geometry;
import com.libvertex.render.Mesh;

import java.util.ArrayList;
import java.util.List;
 /**
 * Represents a 3D cylinder mesh with specified dimensions.
 * This class extends the base Mesh class to create a cylindrical shape
 * with customizable radius, height, and number of segments.
 */
public class Cylinder extends Mesh {
    public Cylinder(float radius, float height, int segments) {
        super(generateCylinderVertices(radius, height, segments));
    }

    /**
     * Generates the vertex coordinates for a cylinder mesh.
     *
     * @param radius The radius of the cylinder
     * @param height The height of the cylinder
     * @param segments The number of segments around the cylinder circumference
     * @return A float array containing the vertex coordinates for the cylinder mesh
     */
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
        float[] result = new float[vertices.size()];
        for (int i = 0; i < vertices.size(); i++) {
            result[i] = vertices.get(i);
        }
        return result;
    }
}

