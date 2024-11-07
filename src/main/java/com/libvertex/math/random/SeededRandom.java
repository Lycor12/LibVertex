package com.libvertex.math.random;

import java.util.Random;

public class SeededRandom {
    private Random random;

    public SeededRandom(long seed) {
        this.random = new Random(seed);
    }

    public float randomFloat() {
        return random.nextFloat();
    }

    public int randomInt(int bound) {
        return random.nextInt(bound);
    }

    public void setSeed(long seed) {
        random.setSeed(seed);
    }
}

