package com.libvertex.math.animation;

import org.joml.Matrix4f;
import org.joml.Vector3f;

public class Transform {
        private Vector3f position;
        private Vector3f rotation;
        private Vector3f scale;
        private Matrix4f transformationMatrix;

        public Transform() {
            position = new Vector3f(0, 0, 0);
            rotation = new Vector3f(0, 0, 0);
            scale = new Vector3f(1, 1, 1);
            transformationMatrix = new Matrix4f();
        }

        public void setPosition(float x, float y, float z) {
            position.set(x, y, z);
        }

        public void setRotation(float x, float y, float z) {
            rotation.set(x, y, z);
        }

        public void setScale(float x, float y, float z) {
            scale.set(x, y, z);
        }

        public Matrix4f getTransformationMatrix() {
            transformationMatrix.identity()
                    .translate(position)
                    .rotateX((float)Math.toRadians(rotation.x))
                    .rotateY((float)Math.toRadians(rotation.y))
                    .rotateZ((float)Math.toRadians(rotation.z))
                    .scale(scale);
            return transformationMatrix;
        }

        public void animate(Vector3f targetPosition, Vector3f targetRotation, Vector3f targetScale, float deltaTime) {
            position.lerp(targetPosition, deltaTime);
            rotation.lerp(targetRotation, deltaTime);
            scale.lerp(targetScale, deltaTime);
        }
    }


