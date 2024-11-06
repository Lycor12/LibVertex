package com.libvertex.geometry;

import com.libvertex.render.Mesh;

import java.util.ArrayList;
import java.util.List;

public class Sphere extends Mesh {
    public Sphere(int latitudeBands, int longitudeBands, float radius) {
        super(generateSphereVertices(latitudeBands, longitudeBands, radius));
    }

    private static float[] generateSphereVertices(int latitudeBands, int longitudeBands, float radius) {
        // Generate vertices based on latitude and longitude
        List<Float> vertices = new ArrayList<>();
        for (int latNumber = 0; latNumber <= latitudeBands; latNumber++) {
            float theta = (float) (latNumber * Math.PI / latitudeBands);
            float sinTheta = (float) Math.sin(theta);
            float cosTheta = (float) Math.cos(theta);

            for (int longNumber = 0; longNumber <= longitudeBands; longNumber++) {
                float phi = (float) (longNumber * 2 * Math.PI / longitudeBands);
                float sinPhi = (float) Math.sin(phi);
                float cosPhi = (float) Math.cos(phi);

                float x = cosPhi * sinTheta;
                float y = cosTheta;
                float z = sinPhi * sinTheta;

                vertices.add(radius * x);
                vertices.add(radius * y);
                vertices.add(radius * z);
            }
        }
        float[] vertexArray = new float[vertices.size()];
        for (int i = 0; i < vertices.size(); i++) {
            vertexArray[i] = vertices.get(i);
        }
        return vertexArray;
    }
}

