package com.libvertex.render.material;

import com.libvertex.render.texture.Texture;

public class PBRMaterial extends Material {
    private Texture metallicTexture;
    private Texture roughnessTexture;
    private Texture ambientOcclusionTexture;

    public PBRMaterial(Texture diffuse, Texture metallic, Texture roughness, Texture ao) {
        super(diffuse, 0);  // Specifying shininess for non-PBR can be ignored
        this.metallicTexture = metallic;
        this.roughnessTexture = roughness;
        this.ambientOcclusionTexture = ao;
    }

    public void apply() {
        super.apply();
        if (metallicTexture != null) metallicTexture.bind();
        if (roughnessTexture != null) roughnessTexture.bind();
        if (ambientOcclusionTexture != null) ambientOcclusionTexture.bind();
    }

    public void cleanup() {
        super.cleanup();
        if (metallicTexture != null) metallicTexture.cleanup();
        if (roughnessTexture != null) roughnessTexture.cleanup();
        if (ambientOcclusionTexture != null) ambientOcclusionTexture.cleanup();
    }
}
