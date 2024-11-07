package com.libvertex.vertex.shader;

import org.lwjgl.opengl.GL20;

public class ShaderUniform {
    private int location;

    public ShaderUniform(int programId, String uniformName) {
        location = GL20.glGetUniformLocation(programId, uniformName);
        if (location == -1) {
            System.err.println("Warning: Uniform " + uniformName + " not found in shader.");
        }
    }

    public void set(float value) {
        GL20.glUniform1f(location, value);
    }
}
