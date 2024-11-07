package com.libvertex.render;

import com.libvertex.render.effects.*;
import com.libvertex.render.material.Material;
import com.libvertex.render.material.MaterialManager;
import com.libvertex.render.material.PBRMaterial;

public class RenderPipeline {
    private Framebuffer framebuffer;
    private BloomEffect bloomEffect;
    private MotionBlurEffect motionBlurEffect;
    private DepthOfFieldEffect depthOfFieldEffect;
    private GrayscaleEffect grayscaleEffect;
    private VignetteEffect vignetteEffect;
    private LensDistortionEffect lensDistortionEffect;
    private UnderwaterEffect underwaterEffect;
    private ColorGradingEffect colorGradingEffect;
    private ChromaticAberrationEffect chromaticAberrationEffect;
    private FilmGrainEffect filmGrainEffect;
    private SharpenEffect sharpenEffect;

    private boolean bloomEnabled = true;
    private boolean motionBlurEnabled = false;
    private boolean depthOfFieldEnabled = false;
    private boolean grayscaleEnabled = false;
    private boolean vignetteEnabled = false;
    private boolean lensDistortionEnabled = false;
    private boolean underwaterEnabled = false;
    private boolean colorGradingEnabled = false;
    private boolean chromaticAberrationEnabled = false;
    private boolean filmGrainEnabled = false;
    private boolean sharpenEnabled = false;

    public RenderPipeline(int width, int height, Shader bloomShader, Shader motionBlurShader, int blurAmount, Shader dofShader, float focusDistance, float aperture, Shader grayscaleShader, Shader vignetteShader, float vignetteRadius, float vignetteSoftness, Shader lensDistortionShader, Shader underwaterShader, Shader colorGradingShader, Shader chromaticAberrationShader, Shader filmGrainShader, Shader sharpenShader) {
        framebuffer = new Framebuffer(width, height);
        if(bloomShader != null) bloomEffect = new BloomEffect(bloomShader);
        if(motionBlurShader != null) motionBlurEffect = new MotionBlurEffect(motionBlurShader, blurAmount);
        if(dofShader != null && focusDistance != 0 && aperture != 0) depthOfFieldEffect = new DepthOfFieldEffect(dofShader, focusDistance, aperture);
        if (grayscaleShader != null) grayscaleEffect = new GrayscaleEffect(grayscaleShader);
        if (vignetteShader != null && vignetteSoftness != 0 && vignetteRadius != 0) vignetteEffect = new VignetteEffect(vignetteShader, vignetteRadius, vignetteSoftness);
        if (lensDistortionShader != null) lensDistortionEffect = new LensDistortionEffect(lensDistortionShader);
        if (underwaterShader != null) underwaterEffect = new UnderwaterEffect(underwaterShader);
        if (colorGradingShader != null) colorGradingEffect = new ColorGradingEffect(colorGradingShader);
        if (chromaticAberrationShader != null) chromaticAberrationEffect = new ChromaticAberrationEffect(chromaticAberrationShader);
        if (filmGrainShader != null) filmGrainEffect = new FilmGrainEffect(filmGrainShader);
        if (sharpenShader != null) sharpenEffect = new SharpenEffect(sharpenShader);
    }

    public void startRendering() {
        framebuffer.bind();
        //setup for rendering
    }

    public void endRendering() {
        framebuffer.unbind();
    }

    public void applyPostProcessing() {
        int textureId = framebuffer.getTextureId();

        if (bloomEnabled && bloomEffect != null) bloomEffect.apply(textureId);
        if (motionBlurEnabled && motionBlurEffect != null) motionBlurEffect.apply(textureId);
        if (depthOfFieldEnabled && depthOfFieldEffect != null) depthOfFieldEffect.apply(textureId);
        if (grayscaleEnabled && grayscaleEffect != null) grayscaleEffect.apply(textureId);
        if (vignetteEnabled && vignetteEffect != null) vignetteEffect.apply(textureId);
        if (lensDistortionEnabled && lensDistortionEffect != null) lensDistortionEffect.apply(textureId);
        if (underwaterEnabled && underwaterEffect != null) underwaterEffect.apply(textureId);
        if (colorGradingEnabled && colorGradingEffect != null) colorGradingEffect.apply(textureId);
        if (chromaticAberrationEnabled && chromaticAberrationEffect != null) chromaticAberrationEffect.apply(textureId);
        if (filmGrainEnabled && filmGrainEffect != null) filmGrainEffect.apply(textureId);
        if (sharpenEnabled && sharpenEffect != null) sharpenEffect.apply(textureId);

    }

    public void toggleBloom(boolean enabled) {
        bloomEnabled = enabled;
    }

    public void toggleMotionBlur(boolean enabled) {
        motionBlurEnabled = enabled;
    }

    public void toggleDepthOfField(boolean enabled) {
        depthOfFieldEnabled = enabled;
    }

    public void toggleGrayscale(boolean enabled) {
        grayscaleEnabled = enabled;
    }

    public void toggleVignette(boolean enabled) {
        vignetteEnabled = enabled;
    }
    public void toggleLensDistortion(boolean enabled) {
        lensDistortionEnabled = enabled;
    }

    public void toggleUnderwaterEffect(boolean enabled) {
        underwaterEnabled = enabled;
    }

    public void toggleColorGrading(boolean enabled) {
        colorGradingEnabled = enabled;
    }

    public void toggleChromaticAberration(boolean enabled) {
        chromaticAberrationEnabled = enabled;
    }

    public void toggleFilmGrain(boolean enabled) {
        filmGrainEnabled = enabled;
    }

    public void toggleSharpenEffect(boolean enabled) {
        sharpenEnabled = enabled;
    }
    public void applyMaterial(Material material) {
        material.apply();
    }

    public void applyPBRMaterial(PBRMaterial pbrMaterial) {
        pbrMaterial.apply();
    }

    public void cleanupMaterial() {
        MaterialManager.cleanup();
    }

    public void cleanup() {
        framebuffer.cleanup();
    }
}

