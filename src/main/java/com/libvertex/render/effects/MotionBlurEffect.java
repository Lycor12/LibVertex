package com.libvertex.render.effects;

import org.lwjgl.opengl.GL30;
import com.libvertex.render.Shader;

public class MotionBlurEffect extends PostProcessingEffect {
    private int blurAmount;
    private float[] prevFrameTexture;

    public MotionBlurEffect(Shader shader, int blurAmount) {
        super(shader);
        this.blurAmount = blurAmount;
    }

    @Override
    protected void render() {
        //accumulate the current frame with the previous frame
        //apply a blur based on the blurAmount parameter

        GL30.glBindTexture(GL30.GL_TEXTURE_2D, framebufferTexture);
        shader.setUniform("blurAmount", blurAmount);

        //rendering quad with motion blur applied
        GL30.glDrawArrays(GL30.GL_TRIANGLES, 0, 6);
    }
}

