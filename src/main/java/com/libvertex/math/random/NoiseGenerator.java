package com.libvertex.math.random;

import java.util.Random;

public class NoiseGenerator {
    private final Random random;
    private final int[] permutationTable;

    public NoiseGenerator(long seed) {
        random = new Random(seed);
        permutationTable = new int[512];
        for (int i = 0; i < 256; i++) {
            permutationTable[i] = i;
        }
        shuffle(permutationTable, random);
        System.arraycopy(permutationTable, 0, permutationTable, 256, 256);
    }

    // Perlin Noise: 2D implementation with gradient vectors
    public float perlinNoise(float x, float y) {
        int xi = (int)Math.floor(x) & 255;
        int yi = (int)Math.floor(y) & 255;

        float xf = x - (int)Math.floor(x);
        float yf = y - (int)Math.floor(y);

        float u = fade(xf);
        float v = fade(yf);

        int aa = permutationTable[permutationTable[xi] + yi];
        int ab = permutationTable[permutationTable[xi] + yi + 1];
        int ba = permutationTable[permutationTable[xi + 1] + yi];
        int bb = permutationTable[permutationTable[xi + 1] + yi + 1];

        return lerp(v, lerp(u, grad(aa, xf, yf), grad(ba, xf - 1, yf)),
                lerp(u, grad(ab, xf, yf - 1), grad(bb, xf - 1, yf - 1)));
    }

    // Simplex Noise: 2D implementation
    public float simplexNoise(float x, float y) {
        float skewFactor = 0.5f * (float)(Math.sqrt(3.0) - 1.0);
        float s = (x + y) * skewFactor;
        int i = (int)Math.floor(x + s);
        int j = (int)Math.floor(y + s);

        float unskewFactor = (3.0f - (float)Math.sqrt(3.0)) / 6.0f;
        float t = (i + j) * unskewFactor;
        float x0 = x - (i - t);
        float y0 = y - (j - t);

        int i1, j1;
        if (x0 > y0) { i1 = 1; j1 = 0; } else { i1 = 0; j1 = 1; }

        float x1 = x0 - i1 + unskewFactor;
        float y1 = y0 - j1 + unskewFactor;
        float x2 = x0 - 1.0f + 2.0f * unskewFactor;
        float y2 = y0 - 1.0f + 2.0f * unskewFactor;

        int gi0 = permutationTable[i + permutationTable[j]] % 12;
        int gi1 = permutationTable[i + i1 + permutationTable[j + j1]] % 12;
        int gi2 = permutationTable[i + 1 + permutationTable[j + 1]] % 12;

        float n0, n1, n2;

        float t0 = 0.5f - x0 * x0 - y0 * y0;
        n0 = t0 < 0 ? 0.0f : (float)Math.pow(t0, 4) * dot(grad2D[gi0], x0, y0);

        float t1 = 0.5f - x1 * x1 - y1 * y1;
        n1 = t1 < 0 ? 0.0f : (float)Math.pow(t1, 4) * dot(grad2D[gi1], x1, y1);

        float t2 = 0.5f - x2 * x2 - y2 * y2;
        n2 = t2 < 0 ? 0.0f : (float)Math.pow(t2, 4) * dot(grad2D[gi2], x2, y2);

        return 70.0f * (n0 + n1 + n2);
    }

    // Value Noise: Interpolated values based on grid points
    public float valueNoise(float x, float y) {
        int x0 = (int) Math.floor(x);
        int x1 = x0 + 1;
        int y0 = (int) Math.floor(y);
        int y1 = y0 + 1;

        float sx = fade(x - x0);
        float sy = fade(y - y0);

        float n0 = randomValue(x0, y0);
        float n1 = randomValue(x1, y0);
        float ix0 = lerp(n0, n1, sx);

        n0 = randomValue(x0, y1);
        n1 = randomValue(x1, y1);
        float ix1 = lerp(n0, n1, sx);

        return lerp(ix0, ix1, sy);
    }

    private float fade(float t) {
        return t * t * t * (t * (t * 6 - 15) + 10);
    }

    private float lerp(float a, float b, float t) {
        return a + t * (b - a);
    }

    private float grad(int hash, float x, float y) {
        int h = hash & 3;
        float u = h < 2 ? x : y;
        float v = h < 2 ? y : x;
        return ((h & 1) == 0 ? u : -u) + ((h & 2) == 0 ? v : -v);
    }

    private float randomValue(int x, int y) {
        int n = x + y * 57;
        n = (n << 13) ^ n;
        return (1.0f - ((n * (n * n * 15731 + 789221) + 1376312589) & 0x7fffffff) / 1073741824.0f);
    }

    private void shuffle(int[] array, Random rand) {
        for (int i = array.length - 1; i > 0; i--) {
            int index = rand.nextInt(i + 1);
            int temp = array[i];
            array[i] = array[index];
            array[index] = temp;
        }
    }

    private static final int[][] grad2D = {
            {1, 1}, {-1, 1}, {1, -1}, {-1, -1},
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    private float dot(int[] grad, float x, float y) {
        return grad[0] * x + grad[1] * y;
    }
}
