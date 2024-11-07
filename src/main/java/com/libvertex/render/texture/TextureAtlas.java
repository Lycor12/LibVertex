package com.libvertex.render.texture;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;

public class TextureAtlas extends Texture {
    private final int atlasWidth;
    private final int atlasHeight;

    public TextureAtlas(String atlasFile, int atlasWidth, int atlasHeight) {
        super(atlasFile);
        this.atlasWidth = atlasWidth;
        this.atlasHeight = atlasHeight;
    }

    /**
     * Binds a specific region of the texture atlas for rendering.
     *
     * @param regionX The x-coordinate of the region in the atlas.
     * @param regionY The y-coordinate of the region in the atlas.
     * @param width   The width of the region.
     * @param height  The height of the region.
     */
    public void bindRegion(int regionX, int regionY, int width, int height) {
        // Calculate texture coordinates for the region
        float uMin = (float) regionX / atlasWidth;
        float vMin = (float) regionY / atlasHeight;
        float uMax = (float) (regionX + width) / atlasWidth;
        float vMax = (float) (regionY + height) / atlasHeight;

        GL13.glActiveTexture(GL13.GL_TEXTURE0); // Activate texture unit
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, getTextureId());

        // Adjust texture coordinates to only show the specified region
        GL11.glTexCoord2f(uMin, vMin);
        GL11.glTexCoord2f(uMax, vMax);
    }

    public int getAtlasWidth() {
        return atlasWidth;
    }

    public int getAtlasHeight() {
        return atlasHeight;
    }
}
