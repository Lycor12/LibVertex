#version 330 core

in vec2 fragTexCoord;
out vec4 FragColor;

uniform sampler2D screenTexture;  // The input texture (screen texture)
uniform float blurAmount;         // Amount of blur to apply

void main() {
    vec4 color = texture(screenTexture, fragTexCoord);

    // Simple motion blur effect by averaging neighboring pixels
    vec2 offset = vec2(blurAmount / 1024.0, 0.0);  // Horizontal blur
    vec4 blurredColor = color;
    blurredColor += texture(screenTexture, fragTexCoord + offset);
    blurredColor += texture(screenTexture, fragTexCoord - offset);
    FragColor = blurredColor / 3.0;  // Average the colors
}
