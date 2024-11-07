package com.libvertex.math.random;

import java.util.Random;

public class RandomRange {
    private Random random = new Random();

    public float randomFloatInRange(float min, float max) {
        return min + random.nextFloat() * (max - min);
    }

    public int randomIntInRange(int min, int max) {
        return min + random.nextInt((max - min) + 1);
    }

    public boolean randomBoolean() {
        return random.nextBoolean();
    }
}

