#version 330 core

in vec2 fragTexCoord;
out vec4 FragColor;

uniform sampler2D screenTexture;  // The input texture (screen texture)
uniform float bloomIntensity;     // The intensity of the bloom effect

void main() {
    vec4 color = texture(screenTexture, fragTexCoord);

    // Apply a simple bloom effect by brightening colors above a threshold
    float brightness = dot(color.rgb, vec3(0.2126, 0.7152, 0.0722)); // Luminance calculation
    if (brightness > 0.5) {
        color.rgb *= bloomIntensity;  // Apply bloom intensity
    }

    FragColor = color;
}

