package com.libvertex.render;

import org.lwjgl.opengl.GL30;

public abstract class Mesh {
    protected int vaoId;
    protected int vboId;
    protected int vertexCount;

    public Mesh(float[] vertices) {
        vaoId = GL30.glGenVertexArrays();
        vboId = GL30.glGenBuffers();

        GL30.glBindVertexArray(vaoId);
        GL30.glBindBuffer(GL30.GL_ARRAY_BUFFER, vboId);
        GL30.glBufferData(GL30.GL_ARRAY_BUFFER, vertices, GL30.GL_STATIC_DRAW);

        GL30.glVertexAttribPointer(0, 3, GL30.GL_FLOAT, false, 0, 0);
        GL30.glEnableVertexAttribArray(0);

        vertexCount = vertices.length / 3;

        GL30.glBindBuffer(GL30.GL_ARRAY_BUFFER, 0);
        GL30.glBindVertexArray(0);
    }

    public void render() {
        GL30.glBindVertexArray(vaoId);
        GL30.glDrawArrays(GL30.GL_TRIANGLES, 0, vertexCount);
        GL30.glBindVertexArray(0);
    }

    public void cleanup() {
        GL30.glDeleteBuffers(vboId);
        GL30.glDeleteVertexArrays(vaoId);
    }
}