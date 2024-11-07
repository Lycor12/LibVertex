package com.libvertex.vertex.render;

import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL33;

public class OcclusionQuery {
    private int queryId;
    private boolean isResultAvailable;

    public OcclusionQuery() {
        queryId = GL15.glGenQueries();
    }

    public void beginQuery() {
        GL33.glBeginQuery(GL33.GL_SAMPLES_PASSED, queryId);
        isResultAvailable = false;
    }

    public void endQuery() {
        GL33.glEndQuery(GL33.GL_SAMPLES_PASSED);
    }

    public boolean isVisible() {
        if (!isResultAvailable) {
            int result = GL15.glGetQueryObjecti(queryId, GL15.GL_QUERY_RESULT_AVAILABLE);
            isResultAvailable = (result == GL15.GL_TRUE);
        }
        return GL15.glGetQueryObjecti(queryId, GL15.GL_QUERY_RESULT) > 0;
    }

    public void deleteQuery() {
        GL15.glDeleteQueries(queryId);
    }
}
