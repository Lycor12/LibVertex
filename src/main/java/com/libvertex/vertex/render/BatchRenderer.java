package com.libvertex.vertex.render;

import java.util.ArrayList;
import java.util.List;

public class BatchRenderer {
    private List<Renderable> renderQueue;

    public BatchRenderer() {
        renderQueue = new ArrayList<>();
    }

    public void beginBatch() {
        // Clear the queue to start a new batch
        renderQueue.clear();
    }

    public void addToBatch(Renderable renderable) {
        // Add renderable object to batch queue
        renderQueue.add(renderable);
    }

    public void renderBatch() {
        // Render each object in the batch
        for (Renderable renderable : renderQueue) {
            renderable.render();
        }
    }

    public void endBatch() {
        // Finalize the batch if needed
        renderQueue.clear();
    }
}
