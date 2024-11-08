/**
 * Represents a 3D cube mesh in the geometry system.
 * This class extends the Mesh class and provides functionality to create
 * a cube with specified dimensions.
 */
package com.libvertex.geometry;

import com.libvertex.render.Mesh;

/**
 * A class representing a 3D cube geometry.
 * The cube is centered at the origin and has equal dimensions on all sides.
 */
public class Cube extends Mesh {

    /**
     * Constructs a new cube with the specified size.
     *
     * @param size The length of each side of the cube
     */
    public Cube(float size) {
        super(generateCubeVertices(size));
    }

    /**
     * Generates the vertex coordinates for a cube.
     * The cube is centered at the origin (0,0,0) and vertices are arranged
     * as triangles for rendering.
     *
     * @param size The length of each side of the cube
     * @return A float array containing the vertex coordinates for the cube,
     *         organized as triangles for each face (front, back, left, right, top, bottom)
     */
    private static float[] generateCubeVertices(float size) {
        // Vertices for a unit cube centered at the origin
        float half = size / 2;
        return new float[]{
                // Front face
                -half, -half,  half,
                half, -half,  half,
                half,  half,  half,
                half,  half,  half,
                -half,  half,  half,
                -half, -half,  half,

                // Back face
                -half, -half, -half,
                -half,  half, -half,
                half,  half, -half,
                half,  half, -half,
                half, -half, -half,
                -half, -half, -half,

                // Left face
                -half,  half,  half,
                -half,  half, -half,
                -half, -half, -half,
                -half, -half, -half,
                -half, -half,  half,
                -half,  half,  half,

                // Right face
                half,  half,  half,
                half, -half, -half,
                half,  half, -half,
                half, -half, -half,
                half,  half,  half,
                half, -half,  half,

                // Top face
                -half,  half,  half,
                half,  half,  half,
                half,  half, -half,
                half,  half, -half,
                -half,  half, -half,
                -half,  half,  half,

                // Bottom face
                -half, -half,  half,
                -half, -half, -half,
                half, -half, -half,
                half, -half, -half,
                half, -half,  half,
                -half, -half,  half
        };
    }
}
