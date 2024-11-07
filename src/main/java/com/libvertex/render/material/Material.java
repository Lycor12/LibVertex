package com.libvertex.render.material;

import com.libvertex.render.texture.Texture;

public class Material {
    private Texture diffuseTexture;
    private float shininess;

    public Material(Texture diffuseTexture, float shininess) {
        this.diffuseTexture = diffuseTexture;
        this.shininess = shininess;
    }

    public void apply() {
        if (diffuseTexture != null) diffuseTexture.bind();
    }

    public void cleanup() {
        if (diffuseTexture != null) diffuseTexture.cleanup();
    }
}
