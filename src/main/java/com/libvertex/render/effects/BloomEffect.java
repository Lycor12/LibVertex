package com.libvertex.render.effects;
import org.lwjgl.opengl.GL30;
import com.libvertex.render.Shader;

public class BloomEffect extends PostProcessingEffect {
    public BloomEffect(Shader shader) {
        super(shader);
    }

    @Override
    protected void render() {
        //bind framebuffer texture and apply bloom effect
        GL30.glBindTexture(GL30.GL_TEXTURE_2D, framebufferTexture);
        //render quad
        GL30.glDrawArrays(GL30.GL_TRIANGLES, 0, 6);
    }
}

