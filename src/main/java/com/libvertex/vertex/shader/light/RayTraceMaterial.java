package com.libvertex.vertex.shader.light;

public class RayTraceMaterial {
    private float reflectivity;
    private float refractivity;
    private float roughness;

    public RayTraceMaterial(float reflectivity, float refractivity, float roughness) {
        this.reflectivity = reflectivity;
        this.refractivity = refractivity;
        this.roughness = roughness;
    }

    public float getReflectivity() {
        return reflectivity;
    }

    public float getRoughness() {
        return roughness;
    }

    public float getRefractivity() {
        return refractivity;
    }
}
