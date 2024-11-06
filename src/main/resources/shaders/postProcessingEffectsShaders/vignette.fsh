#version 330 core

in vec2 fragTexCoord;
out vec4 FragColor;

uniform sampler2D screenTexture;  // The input texture (screen texture)
uniform float vignetteIntensity;  // Intensity of vignette
uniform float vignetteRadius;     // The radius of the vignette effect

void main() {
    vec4 color = texture(screenTexture, fragTexCoord);

    // Calculate distance from the center of the screen
    vec2 center = vec2(0.5, 0.5);
    float dist = distance(fragTexCoord, center);

    // Apply vignette based on the distance
    float vignette = smoothstep(vignetteRadius, 1.0, dist); // Smooth transition
    color.rgb *= mix(1.0, vignetteIntensity, vignette);

    FragColor = color;
}
