#version 330 core

in vec2 fragTexCoord;
out vec4 FragColor;

uniform sampler2D screenTexture;  // The input texture (screen texture)
uniform float waveIntensity;      // Intensity of the wave effect

void main() {
    vec2 offset = vec2(sin(fragTexCoord.y * 10.0) * waveIntensity, cos(fragTexCoord.x * 10.0) * waveIntensity);
    vec4 color = texture(screenTexture, fragTexCoord + offset);
    FragColor = color;
}
