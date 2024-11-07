package com.libvertex.math.random;

import java.util.Random;

public class RandomInstance {
    private Random random;

    public RandomInstance(int randomKey) {
        random = new Random(randomKey);
    }

    public float randomFloat(float min, float max) {
        return min + random.nextFloat() * (max - min);
    }

    public int randomInt(int min, int max) {
        return min + random.nextInt(max - min + 1);
    }

    public void resetSeed(int newSeed) {
        random = new Random(newSeed);
    }
}

