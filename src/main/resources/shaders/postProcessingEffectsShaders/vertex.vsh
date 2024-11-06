#version 330 core

layout(location = 0) in vec3 position;  // Vertex positions
layout(location = 1) in vec2 texCoord; // Texture coordinates

out vec2 fragTexCoord;  // Pass texture coordinates to fragment shader

void main() {
    fragTexCoord = texCoord;
    gl_Position = vec4(position, 1.0);
}
