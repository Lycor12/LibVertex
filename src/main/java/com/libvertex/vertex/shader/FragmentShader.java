package com.libvertex.vertex.shader;

import com.libvertex.vertex.shader.util.ShaderLoader;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL32;
import java.io.IOException;

public class FragmentShader extends ShaderProgram {
    public FragmentShader(String filePath) throws IOException {
        attachShader(ShaderLoader.loadShader(filePath, GL20.GL_FRAGMENT_SHADER));
    }
}

