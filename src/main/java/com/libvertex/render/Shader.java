package com.libvertex.render;

import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.lwjgl.opengl.GL20;
import org.lwjgl.system.MemoryStack;

import java.nio.FloatBuffer;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Shader {
    private final int programId;

    public Shader(String vertexPath, String fragmentPath) throws Exception {
        int vertexShaderId = createShader(loadShader(vertexPath), GL20.GL_VERTEX_SHADER);
        int fragmentShaderId = createShader(loadShader(fragmentPath), GL20.GL_FRAGMENT_SHADER);

        programId = GL20.glCreateProgram();
        GL20.glAttachShader(programId, vertexShaderId);
        GL20.glAttachShader(programId, fragmentShaderId);
        GL20.glLinkProgram(programId);

        if (GL20.glGetProgrami(programId, GL20.GL_LINK_STATUS) == 0) {
            throw new RuntimeException("Error linking shader program: " + GL20.glGetProgramInfoLog(programId));
        }

        GL20.glDetachShader(programId, vertexShaderId);
        GL20.glDetachShader(programId, fragmentShaderId);
        GL20.glDeleteShader(vertexShaderId);
        GL20.glDeleteShader(fragmentShaderId);
    }

    public void bind() {
        GL20.glUseProgram(programId);
    }

    public void unbind() {
        GL20.glUseProgram(0);
    }

    public void setUniform(String name, int value) {
        int location = GL20.glGetUniformLocation(programId, name);
        GL20.glUniform1i(location, value);
    }

    public void setUniform(String name, float value) {
        int location = GL20.glGetUniformLocation(programId, name);
        GL20.glUniform1f(location, value);
    }

    public void setUniform(String name, Vector3f value) {
        int location = GL20.glGetUniformLocation(programId, name);
        GL20.glUniform3f(location, value.x, value.y, value.z);
    }

    public void setUniform(String name, Matrix4f value) {
        int location = GL20.glGetUniformLocation(programId, name);
        try (MemoryStack stack = MemoryStack.stackPush()) {
            FloatBuffer fb = stack.mallocFloat(16);
            value.get(fb);
            GL20.glUniformMatrix4fv(location, false, fb);
        }
    }

    public void cleanup() {
        GL20.glDeleteProgram(programId);
    }

    private String loadShader(String path) throws Exception {
        return new String(Files.readAllBytes(Paths.get(path)));
    }

    private int createShader(String shaderCode, int shaderType) {
        int shaderId = GL20.glCreateShader(shaderType);
        GL20.glShaderSource(shaderId, shaderCode);
        GL20.glCompileShader(shaderId);

        if (GL20.glGetShaderi(shaderId, GL20.GL_COMPILE_STATUS) == 0) {
            throw new RuntimeException("Error compiling shader: " + GL20.glGetShaderInfoLog(shaderId));
        }
        return shaderId;
    }
}
