package com.libvertex.vertex.core;

import org.lwjgl.opengl.GL30;
import java.util.ArrayList;
import java.util.List;

public class VertexSchema {
    private final List<VertexAttribute> attributes = new ArrayList<>();
    private int stride = 0;

    public VertexSchema addAttribute(int index, int size, int type, boolean normalized) {
        attributes.add(new VertexAttribute(index, size, type, normalized, stride));
        stride += size * Float.BYTES; // assuming float type for simplicity
        return this;
    }

    public void apply(int vaoId) {
        GL30.glBindVertexArray(vaoId);
        for (VertexAttribute attribute : attributes) {
            GL30.glEnableVertexAttribArray(attribute.index);
            GL30.glVertexAttribPointer(
                    attribute.index,
                    attribute.size,
                    attribute.type,
                    attribute.normalized,
                    stride,
                    attribute.offset
            );
        }
        GL30.glBindVertexArray(0);
    }
}

class VertexAttribute {
    int index;
    int size;
    int type;
    boolean normalized;
    int offset;

    VertexAttribute(int index, int size, int type, boolean normalized, int offset) {
        this.index = index;
        this.size = size;
        this.type = type;
        this.normalized = normalized;
        this.offset = offset;
    }
}
