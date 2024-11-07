package com.libvertex.vertex.transform;

public class OrthographicProjection {
    public static TransformationMatrix create(float left, float right, float bottom, float top, float near, float far) {
        TransformationMatrix matrix = new TransformationMatrix();
        matrix.identity();
        matrix.matrix[0] = 2.0f / (right - left);
        matrix.matrix[5] = 2.0f / (top - bottom);
        matrix.matrix[10] = -2.0f / (far - near);
        matrix.matrix[12] = -(right + left) / (right - left);
        matrix.matrix[13] = -(top + bottom) / (top - bottom);
        matrix.matrix[14] = -(far + near) / (far - near);
        return matrix;
    }
}
