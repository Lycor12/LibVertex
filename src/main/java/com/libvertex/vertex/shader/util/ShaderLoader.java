package com.libvertex.vertex.shader.util;

import org.lwjgl.opengl.GL20;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;

public class ShaderLoader {
    public static int loadShader(String filePath, int shaderType) throws IOException {
        // Read shader code from file
        String shaderCode = Files.readString(Path.of(filePath));
        int shaderId = GL20.glCreateShader(shaderType);
        GL20.glShaderSource(shaderId, shaderCode);
        GL20.glCompileShader(shaderId);

        // Check for compilation errors
        if (GL20.glGetShaderi(shaderId, GL20.GL_COMPILE_STATUS) == 0) {
            throw new RuntimeException("Failed to compile shader: " + GL20.glGetShaderInfoLog(shaderId));
        }
        return shaderId;
    }
}
