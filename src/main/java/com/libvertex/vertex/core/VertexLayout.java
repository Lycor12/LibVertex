package com.libvertex.vertex.core;

public class VertexLayout {
    private final int stride;

    public VertexLayout(int stride) {
        this.stride = stride;
    }

    public int getStride() {
        return stride;
    }
}
