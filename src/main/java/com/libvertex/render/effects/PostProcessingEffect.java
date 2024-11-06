package com.libvertex.render.effects;

import com.libvertex.render.Shader;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL30;

public abstract class PostProcessingEffect {
    protected Shader shader;
    protected int framebufferTexture;

    public PostProcessingEffect(Shader shader) {
        this.shader = shader;
    }

    public void apply(int framebufferTexture) {
        this.framebufferTexture = framebufferTexture;
        shader.bind();
        render();
        shader.unbind();
    }

    protected abstract void render();

    //helper for binding and unbinding the shader and framebuffer
    protected void prepareForRendering() {
        // Activate the shader
        shader.bind();

        //bind the framebuffer texture as a 2D texture
        GL30.glBindTexture(GL30.GL_TEXTURE_2D, framebufferTexture);

        //set up OpenGL state for rendering
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glDisable(GL11.GL_CULL_FACE);
        GL11.glDisable(GL11.GL_BLEND);
    }

    protected void finalizeRendering() {
        // reset OpenGL state after rendering
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glEnable(GL11.GL_CULL_FACE);
        GL11.glEnable(GL11.GL_BLEND);

        shader.unbind();
    }
}

