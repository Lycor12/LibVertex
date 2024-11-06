package com.libvertex.geometry;

import java.nio.FloatBuffer;

import com.libvertex.render.Mesh;
import org.lwjgl.assimp.*;

public class Shape3D extends Mesh {
    public Shape3D(String objFilePath) {
        super(loadModel(objFilePath));
    }

    private static float[] loadModel(String objFilePath) {
        AIScene scene = Assimp.aiImportFile(objFilePath, Assimp.aiProcess_Triangulate);
        if (scene == null) {
            throw new RuntimeException("Error loading model");
        }

        AIMesh mesh = AIMesh.create(scene.mMeshes().get(0));

        int numVertices = mesh.mNumVertices();
        float[] vertexArray = new float[numVertices * 3];  // Each vertex has x, y, z

        // Iterate over each vertex
        for (int i = 0; i < numVertices; i++) {
            vertexArray[i * 3] = mesh.mVertices().get(i).x();
            vertexArray[i * 3 + 1] = mesh.mVertices().get(i).y();
            vertexArray[i * 3 + 2] = mesh.mVertices().get(i).z();
        }

        Assimp.aiReleaseImport(scene);
        return vertexArray;
    }
}
