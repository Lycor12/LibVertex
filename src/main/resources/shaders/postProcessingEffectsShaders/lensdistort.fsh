#version 330 core

in vec2 fragTexCoord;
out vec4 FragColor;

uniform sampler2D screenTexture;  // The input texture (screen texture)
uniform float distortionStrength;  // Strength of the lens distortion

void main() {
    vec2 center = vec2(0.5, 0.5);  // Center of the screen
    vec2 uv = fragTexCoord - center;  // Offset from center

    // Apply lens distortion
    float len = length(uv);
    uv *= 1.0 + distortionStrength * pow(len, 2.0);  // Barrel distortion effect

    // Apply the distorted texture
    vec4 color = texture(screenTexture, uv + center);

    FragColor = color;
}
