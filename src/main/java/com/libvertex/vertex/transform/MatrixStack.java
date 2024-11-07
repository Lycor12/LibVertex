package com.libvertex.vertex.transform;

import java.util.Stack;

public class MatrixStack {
    private final Stack<TransformationMatrix> stack = new Stack<>();

    public MatrixStack() {
        stack.push(new TransformationMatrix());
    }

    public void pushMatrix() {
        stack.push(new TransformationMatrix(stack.peek()));
    }

    public void popMatrix() {
        if (stack.size() > 1) stack.pop();
    }

    public TransformationMatrix peek() {
        return stack.peek();
    }

    public void loadIdentity() {
        stack.peek().identity();
    }
}
