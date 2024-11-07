package com.libvertex.vertex.shader.light;

import java.util.ArrayList;
import java.util.List;

public class LightManager {
    private List<Light> lights;

    public LightManager() {
        lights = new ArrayList<>();
    }

    public void addLight(Light light) {
        lights.add(light);
    }

    public List<Light> getLights() {
        return lights;
    }
}
