package com.libvertex.render.effects;

import org.lwjgl.opengl.GL30;
import com.libvertex.render.Shader;

public class DepthOfFieldEffect extends PostProcessingEffect {
    private float focusDistance;
    private float aperture;

    public DepthOfFieldEffect(Shader shader, float focusDistance, float aperture) {
        super(shader);
        this.focusDistance = focusDistance;
        this.aperture = aperture;
    }

    @Override
    protected void render() {
        //apply logic
        //calculate the blur based on the focusDistance and aperture

        GL30.glBindTexture(GL30.GL_TEXTURE_2D, framebufferTexture);
        shader.setUniform("focusDistance", focusDistance);
        shader.setUniform("aperture", aperture);

        //render the quad
        GL30.glDrawArrays(GL30.GL_TRIANGLES, 0, 6);
    }
}

