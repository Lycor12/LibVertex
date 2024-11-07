package com.libvertex.vertex.render;

import com.libvertex.math.Frustum;
import org.joml.Vector3f;

public class FrustumCuller {
    private Frustum frustum;

    public FrustumCuller(Frustum frustum) {
        this.frustum = frustum;
    }

    public boolean isInView(Vector3f position) {
        // Check if the object's position is within the view frustum
        return frustum.contains(position);
    }
}
