package com.libvertex.vertex.render;

public class InstanceRenderer {
    public void renderInstances(Renderable renderable, int count) {
        // Render multiple instances of the same object efficiently using instancing
        for (int i = 0; i < count; i++) {
            renderable.renderInstance(i);
        }
    }
}
