package com.libvertex.vertex.core;

import org.lwjgl.opengl.GL30;

public class VertexArray {
    final int vaoId;

    public VertexArray() {
        vaoId = GL30.glGenVertexArrays();
    }

    public void bind() {
        GL30.glBindVertexArray(vaoId);
    }

    public void unbind() {
        GL30.glBindVertexArray(0);
    }

    public void delete() {
        GL30.glDeleteVertexArrays(vaoId);
    }
}
