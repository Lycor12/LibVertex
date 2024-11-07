package com.libvertex.vertex.core;

import org.lwjgl.opengl.GL15;
import org.lwjgl.system.MemoryUtil;

import java.nio.IntBuffer;

public class VertexIndexBuffer {
    private final int bufferId;

    public VertexIndexBuffer(int[] indices) {
        bufferId = GL15.glGenBuffers();
        uploadData(indices);
    }

    private void uploadData(int[] indices) {
        IntBuffer buffer = MemoryUtil.memAllocInt(indices.length).put(indices).flip();
        GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, bufferId);
        GL15.glBufferData(GL15.GL_ELEMENT_ARRAY_BUFFER, buffer, GL15.GL_STATIC_DRAW);
        MemoryUtil.memFree(buffer);
    }

    public void bind() {
        GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, bufferId);
    }

    public void unbind() {
        GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, 0);
    }

    public void delete() {
        GL15.glDeleteBuffers(bufferId);
    }
}
