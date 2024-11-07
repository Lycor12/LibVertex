package com.libvertex.render.util;

import org.lwjgl.opengl.GL30;
import java.util.List;

public class TextureLoader {
    public static int loadTexture(String filePath) {
        int textureId = GL30.glGenTextures();
        // Load texture logic
        return textureId;
    }

    public static int loadTextureArray(List<String> filePaths) {
        int textureArrayId = GL30.glGenTextures();
        // Load texture array logic
        return textureArrayId;
    }
}
