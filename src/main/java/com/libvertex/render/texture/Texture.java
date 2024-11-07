package com.libvertex.render.texture;

import com.libvertex.render.util.TextureLoader;
import org.lwjgl.opengl.GL30;

public class Texture {
    private int textureId;

    public Texture(String filePath) {
        textureId = TextureLoader.loadTexture(filePath);
    }

    public void bind() {
        GL30.glBindTexture(GL30.GL_TEXTURE_2D, textureId);
    }

    public void unbind() {
        GL30.glBindTexture(GL30.GL_TEXTURE_2D, 0);
    }

    public void cleanup() {
        GL30.glDeleteTextures(textureId);
    }

    public int getTextureId() {
        return textureId;
    }
}
