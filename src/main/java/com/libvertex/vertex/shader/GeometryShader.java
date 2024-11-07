package com.libvertex.vertex.shader;

import com.libvertex.vertex.shader.util.ShaderLoader;
import org.lwjgl.opengl.GL32;

import java.io.IOException;

public class GeometryShader extends ShaderProgram {
    public GeometryShader(String filePath) throws IOException {
        attachShader(ShaderLoader.loadShader(filePath, GL32.GL_GEOMETRY_SHADER));
    }
}
