package com.libvertex.vertex.render;

import org.joml.Vector3f;

public class LODManager {
    public void applyLOD(Renderable renderable, Vector3f cameraPosition) {
        float distance = renderable.getPosition().distance(cameraPosition);

        if (distance < 10) {
            renderable.setLODLevel(0); // Highest quality
        } else if (distance < 50) {
            renderable.setLODLevel(1); // Medium quality
        } else {
            renderable.setLODLevel(2); // Low quality
        }
    }
}
