package com.libvertex.vertex.transform;

import org.lwjgl.BufferUtils;

import java.nio.FloatBuffer;

public class TransformationMatrix {
    final float[] matrix = new float[16];

    public TransformationMatrix() {
        identity();
    }

    public TransformationMatrix(TransformationMatrix peek) {
    }

    public void identity() {
        for (int i = 0; i < 16; i++) matrix[i] = (i % 5 == 0) ? 1.0f : 0.0f;
    }

    public void translate(float x, float y, float z) {
        matrix[12] += matrix[0] * x + matrix[4] * y + matrix[8] * z;
        matrix[13] += matrix[1] * x + matrix[5] * y + matrix[9] * z;
        matrix[14] += matrix[2] * x + matrix[6] * y + matrix[10] * z;
    }

    public void scale(float x, float y, float z) {
        matrix[0] *= x;
        matrix[5] *= y;
        matrix[10] *= z;
    }

    public void rotate(float angle, float x, float y, float z) {
        // Calculate rotation matrix and multiply it with this matrix
        float radians = (float) Math.toRadians(angle);
        float cos = (float) Math.cos(radians);
        float sin = (float) Math.sin(radians);
        float oneMinusCos = 1.0f - cos;

        float[] rotationMatrix = new float[]{
                cos + x * x * oneMinusCos, x * y * oneMinusCos - z * sin, x * z * oneMinusCos + y * sin, 0,
                y * x * oneMinusCos + z * sin, cos + y * y * oneMinusCos, y * z * oneMinusCos - x * sin, 0,
                z * x * oneMinusCos - y * sin, z * y * oneMinusCos + x * sin, cos + z * z * oneMinusCos, 0,
                0, 0, 0, 1
        };

        multiply(rotationMatrix);
    }

    public void multiply(float[] matrix) {
        float[] result = new float[16];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                result[i * 4 + j] =
                        this.matrix[i * 4] * matrix[j] +
                                this.matrix[i * 4 + 1] * matrix[4 + j] +
                                this.matrix[i * 4 + 2] * matrix[8 + j] +
                                this.matrix[i * 4 + 3] * matrix[12 + j];
            }
        }
        System.arraycopy(result, 0, this.matrix, 0, 16);
    }

    public FloatBuffer toFloatBuffer() {
        FloatBuffer buffer = BufferUtils.createFloatBuffer(16);
        buffer.put(matrix).flip();
        return buffer;
    }
}
