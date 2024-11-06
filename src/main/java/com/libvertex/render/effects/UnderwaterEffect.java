package com.libvertex.render.effects;

import org.lwjgl.opengl.GL30;
import com.libvertex.render.Shader;

public class UnderwaterEffect extends PostProcessingEffect {
    public UnderwaterEffect(Shader shader) {
        super(shader);
    }

    @Override
    protected void render() {
        shader.setUniform("waveIntensity", 0.3f);
        GL30.glBindTexture(GL30.GL_TEXTURE_2D, framebufferTexture);
        shader.bind();
        GL30.glDrawArrays(GL30.GL_TRIANGLES, 0, 6);
        shader.unbind();
    }
}

