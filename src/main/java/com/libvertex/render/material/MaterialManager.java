package com.libvertex.render.material;

import java.util.HashMap;
import java.util.Map;

public class MaterialManager {
    private static Map<String, Material> materials = new HashMap<>();

    public static Material getMaterial(String name) {
        return materials.get(name);
    }

    public static void addMaterial(String name, Material material) {
        materials.put(name, material);
    }

    public static void cleanup() {
        for (Material material : materials.values()) {
            material.cleanup();
        }
        materials.clear();
    }
}
