package com.libvertex.render.effects;

import org.lwjgl.opengl.GL30;
import com.libvertex.render.Shader;

public class VignetteEffect extends PostProcessingEffect {
    private float radius;
    private float softness;

    public VignetteEffect(Shader shader, float radius, float softness) {
        super(shader);
        this.radius = radius;
        this.softness = softness;
    }

    @Override
    protected void render() {
        // Apply vignette effect based on radius and softness
        GL30.glBindTexture(GL30.GL_TEXTURE_2D, framebufferTexture);
        shader.setUniform("radius", radius);
        shader.setUniform("softness", softness);

        GL30.glDrawArrays(GL30.GL_TRIANGLES, 0, 6);
    }
}

