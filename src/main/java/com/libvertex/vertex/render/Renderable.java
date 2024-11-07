package com.libvertex.vertex.render;

import org.joml.Matrix4f;
import org.joml.Vector3f;

public abstract class Renderable {
    protected Vector3f position;
    protected Vector3f rotation;
    protected Vector3f scale;
    protected int lodLevel;

    public Renderable() {
        this.position = new Vector3f(0, 0, 0);
        this.rotation = new Vector3f(0, 0, 0);
        this.scale = new Vector3f(1, 1, 1);
        this.lodLevel = 0;
    }

    public abstract void render();
    public abstract void renderInstance(int instanceId);

    public Vector3f getPosition() {
        return position;
    }

    public void setPosition(Vector3f position) {
        this.position = position;
    }

    public Vector3f getRotation() {
        return rotation;
    }

    public void setRotation(Vector3f rotation) {
        this.rotation = rotation;
    }

    public Vector3f getScale() {
        return scale;
    }

    public void setScale(Vector3f scale) {
        this.scale = scale;
    }

    public void setLODLevel(int level) {
        this.lodLevel = level;
    }

    public int getLODLevel() {
        return lodLevel;
    }

    public Matrix4f getTransformationMatrix() {
        // Initialize transformation matrix
        Matrix4f transformationMatrix = new Matrix4f()
                .identity()
                .translate(position)
                .rotateX((float) Math.toRadians(rotation.x))
                .rotateY((float) Math.toRadians(rotation.y))
                .rotateZ((float) Math.toRadians(rotation.z))
                .scale(scale);
        return transformationMatrix;
    }
}
