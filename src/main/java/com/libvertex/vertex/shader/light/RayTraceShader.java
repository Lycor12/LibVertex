package com.libvertex.vertex.shader.light;

import com.libvertex.vertex.shader.ShaderProgram;
import com.libvertex.vertex.shader.util.ShaderLoader;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL43;

public class RayTraceShader extends ShaderProgram {
    public RayTraceShader(String filePath) {
        try {
            attachShader(ShaderLoader.loadShader(filePath, GL43.GL_COMPUTE_SHADER));
            link();
        } catch (Exception e) {
            System.err.println("Failed to load ray tracing shader: " + e.getMessage());
        }
    }

    public void traceRays(int width, int height) {
        // Dispatch the ray tracing compute shader
        GL43.glDispatchCompute(width / 16, height / 16, 1);
    }
}
