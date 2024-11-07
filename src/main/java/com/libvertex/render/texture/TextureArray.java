package com.libvertex.render.texture;

import com.libvertex.render.util.TextureLoader;
import org.lwjgl.opengl.GL30;
import java.util.List;

public class TextureArray {
    private int textureArrayId;

    public TextureArray(List<String> textureFiles) {
        textureArrayId = TextureLoader.loadTextureArray(textureFiles);
    }

    public void bind() {
        GL30.glBindTexture(GL30.GL_TEXTURE_2D_ARRAY, textureArrayId);
    }

    public void unbind() {
        GL30.glBindTexture(GL30.GL_TEXTURE_2D_ARRAY, 0);
    }

    public void cleanup() {
        GL30.glDeleteTextures(textureArrayId);
    }

    public int getTextureArrayId() {
        return textureArrayId;
    }
}
