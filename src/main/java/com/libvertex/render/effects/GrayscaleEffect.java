package com.libvertex.render.effects;

import org.lwjgl.opengl.GL30;
import com.libvertex.render.Shader;

public class GrayscaleEffect extends PostProcessingEffect {

    public GrayscaleEffect(Shader shader) {
        super(shader);
    }

    @Override
    protected void render() {
        // Apply grayscale effect
        GL30.glBindTexture(GL30.GL_TEXTURE_2D, framebufferTexture);
        shader.bind();
        GL30.glDrawArrays(GL30.GL_TRIANGLES, 0, 6);
        shader.unbind();
    }
}
