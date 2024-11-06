#version 330 core

in vec2 fragTexCoord;
out vec4 FragColor;

uniform sampler2D screenTexture;  // The input texture (screen texture)
uniform float focusDistance;      // The distance from the camera that should be in focus
uniform float aperture;           // Aperture size to control blur

void main() {
    vec4 color = texture(screenTexture, fragTexCoord);

    // Simulate depth of field by applying blur based on distance from focus plane
    float depth = fragTexCoord.y;  // Assume depth is encoded in the Y coordinate (just an example)
    float blurAmount = abs(depth - focusDistance) * aperture;
    vec4 blurredColor = color * (1.0 - blurAmount);  // Simulate the blur effect

    FragColor = blurredColor;
}

