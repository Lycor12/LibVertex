package com.libvertex.vertex.shader;

import java.util.HashMap;
import java.util.Map;

public class ShaderManager {
    private static Map<String, ShaderProgram> shaders = new HashMap<>();

    public static ShaderProgram getShader(String name) {
        return shaders.get(name);
    }

    public static void addShader(String name, ShaderProgram shader) {
        shaders.put(name, shader);
    }

    public static void cleanup() {
        for (ShaderProgram shader : shaders.values()) {
            shader.cleanup();
        }
        shaders.clear();
    }
}
