package com.libvertex.vertex.transform;

import org.joml.Vector3f;

public class Transform {
    private final Vector3f position;
    private final Vector3f scale;
    private Quaternion rotation;

    public Transform() {
        position = new Vector3f(0, 0, 0);
        scale = new Vector3f(1, 1, 1);
        rotation = new Quaternion(0, 0, 0, 1);
    }

    public void translate(float x, float y, float z) {
        position.x += x;
        position.y += y;
        position.z += z;
    }

    public void scale(float x, float y, float z) {
        scale.x *= x;
        scale.y *= y;
        scale.z *= z;
    }

    public void rotate(float angle, float x, float y, float z) {
        Quaternion q = new Quaternion(x, y, z, angle);
        rotation = rotation.multiply(q).normalize();
    }

    public TransformationMatrix getTransformationMatrix() {
        TransformationMatrix matrix = new TransformationMatrix();
        matrix.translate(position.x, position.y, position.z);
        matrix.rotate(rotation.w, rotation.x, rotation.y, rotation.z);
        matrix.scale(scale.x, scale.y, scale.z);
        return matrix;
    }
}
