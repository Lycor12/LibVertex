package com.libvertex.vertex.core;

import org.lwjgl.opengl.GL15;
import org.lwjgl.system.MemoryUtil;

import java.nio.FloatBuffer;

public class VertexBuffer {
    private final int bufferId;

    public VertexBuffer(float[] data) {
        bufferId = GL15.glGenBuffers();
        uploadData(data);
    }

    private void uploadData(float[] data) {
        FloatBuffer buffer = MemoryUtil.memAllocFloat(data.length).put(data).flip();
        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, bufferId);
        GL15.glBufferData(GL15.GL_ARRAY_BUFFER, buffer, GL15.GL_STATIC_DRAW);
        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);
        MemoryUtil.memFree(buffer);
    }

    public void bind() {
        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, bufferId);
    }

    public void unbind() {
        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);
    }

    public void delete() {
        GL15.glDeleteBuffers(bufferId);
    }
}
