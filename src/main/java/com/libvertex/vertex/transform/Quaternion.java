package com.libvertex.vertex.transform;

public class Quaternion {
    public float x, y, z, w;

    public Quaternion(float x, float y, float z, float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public Quaternion multiply(Quaternion other) {
        float nx = w * other.x + x * other.w + y * other.z - z * other.y;
        float ny = w * other.y - x * other.z + y * other.w + z * other.x;
        float nz = w * other.z + x * other.y - y * other.x + z * other.w;
        float nw = w * other.w - x * other.x - y * other.y - z * other.z;
        return new Quaternion(nx, ny, nz, nw);
    }

    public Quaternion normalize() {
        float length = (float) Math.sqrt(x * x + y * y + z * z + w * w);
        return new Quaternion(x / length, y / length, z / length, w / length);
    }
}
