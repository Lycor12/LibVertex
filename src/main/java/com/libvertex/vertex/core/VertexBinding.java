package com.libvertex.vertex.core;

import org.lwjgl.opengl.GL30;

public class VertexBinding {
    public static void bindAttributes(VertexArray vao, VertexSchema schema) {
        vao.bind();
        schema.apply(vao.vaoId);
        vao.unbind();
    }
}
