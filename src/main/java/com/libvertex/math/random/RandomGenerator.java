package com.libvertex.math.random;

import java.util.Random;

public class RandomGenerator {
    private Random random;

    public RandomGenerator() {
        random = new Random();
    }

    public RandomGenerator(long seed) {
        random = new Random(seed);
    }

    public float randomFloat(float min, float max) {
        return min + random.nextFloat() * (max - min);
    }

    public int randomInt(int min, int max) {
        return min + random.nextInt((max - min) + 1);
    }

    public boolean randomBoolean() {
        return random.nextBoolean();
    }

    public float randomGaussian() {
        return (float) random.nextGaussian();
    }

    public float randomInRange(float mean, float stdDeviation) {
        return mean + (float) random.nextGaussian() * stdDeviation;
    }

    // Add more distributions (e.g., exponential, binomial) as needed
}
