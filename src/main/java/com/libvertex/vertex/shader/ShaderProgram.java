package com.libvertex.vertex.shader;

import org.lwjgl.opengl.GL20;

public class ShaderProgram {
    private int programId;

    public ShaderProgram() {
        // Create a new shader program ID
        programId = GL20.glCreateProgram();
        if (programId == 0) {
            throw new RuntimeException("Failed to create shader program");
        }
    }

    public void attachShader(int shaderId) {
        // Attach a compiled shader to the program
        GL20.glAttachShader(programId, shaderId);
    }

    public void link() {
        // Link the program to make it usable
        GL20.glLinkProgram(programId);
        if (GL20.glGetProgrami(programId, GL20.GL_LINK_STATUS) == 0) {
            throw new RuntimeException("Shader program linking failed: " + GL20.glGetProgramInfoLog(programId));
        }
    }

    public void bind() {
        // Use this shader program for rendering
        GL20.glUseProgram(programId);
    }

    public void unbind() {
        // Stop using this shader program
        GL20.glUseProgram(0);
    }

    public void cleanup() {
        // Detach and delete the shader program when done
        unbind();
        GL20.glDeleteProgram(programId);
    }
}
