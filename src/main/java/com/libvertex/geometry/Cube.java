package com.libvertex.geometry;

import com.libvertex.render.Mesh;

public class Cube extends Mesh {

    public Cube(float size) {
        super(generateCubeVertices(size));
    }


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

