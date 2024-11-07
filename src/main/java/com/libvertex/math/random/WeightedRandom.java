package com.libvertex.math.random;

import java.util.List;
import java.util.Random;

public class WeightedRandom<T> {
    private final List<T> items;
    private final List<Float> weights;
    private Random random = new Random();

    public WeightedRandom(List<T> items, List<Float> weights) {
        this.items = items;
        this.weights = weights;
    }

    public T getRandomItem() {
        float totalWeight = weights.stream().reduce(0f, Float::sum);
        float randomWeight = random.nextFloat() * totalWeight;

        float cumulativeWeight = 0;
        for (int i = 0; i < items.size(); i++) {
            cumulativeWeight += weights.get(i);
            if (randomWeight <= cumulativeWeight) {
                return items.get(i);
            }
        }
        return null;
    }
}
