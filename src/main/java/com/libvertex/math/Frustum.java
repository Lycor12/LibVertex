package com.libvertex.math;

import com.libvertex.vertex.render.Renderable;
import org.joml.Matrix4f;
import org.joml.Vector3f;

public class Frustum {
    private Plane[] planes;

    public Frustum() {
        this.planes = new Plane[6]; // Six planes: near, far, left, right, top, bottom
    }

    public void update(Matrix4f projectionMatrix, Matrix4f viewMatrix) {
        Matrix4f combinedMatrix = projectionMatrix.mul(viewMatrix, new Matrix4f());
        planes = Plane.extractPlanes(combinedMatrix);
    }

    public boolean contains(Vector3f point) {
        for (Plane plane : planes) {
            if (plane.distanceToPoint(point) < 0) {
                return false;
            }
        }
        return true;
    }

    public boolean contains(Renderable renderable) {
        return contains(renderable.getPosition());
    }
}
