package com.libvertex.vertex.transform;

public class PerspectiveProjection {
    public static TransformationMatrix create(float fov, float aspectRatio, float near, float far) {
        TransformationMatrix matrix = new TransformationMatrix();
        float tanFOV = (float) Math.tan(Math.toRadians(fov / 2));
        matrix.identity();
        matrix.matrix[0] = 1.0f / (aspectRatio * tanFOV);
        matrix.matrix[5] = 1.0f / tanFOV;
        matrix.matrix[10] = -(far + near) / (far - near);
        matrix.matrix[11] = -1;
        matrix.matrix[14] = -(2 * far * near) / (far - near);
        matrix.matrix[15] = 0;
        return matrix;
    }
}
