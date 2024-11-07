package com.libvertex.vertex.shader;

import com.libvertex.vertex.shader.util.ShaderLoader;
import org.lwjgl.opengl.GL20;

import java.io.IOException;

public class VertexShader extends ShaderProgram {
    public VertexShader(String filePath) throws IOException {
        attachShader(ShaderLoader.loadShader(filePath, GL20.GL_VERTEX_SHADER));
    }
}
