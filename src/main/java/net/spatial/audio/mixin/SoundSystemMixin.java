package net.spatial.audio.mixin;

import net.minecraft.client.sound.SoundSystem;
import net.spatial.audio.SpatialAudio;
import net.minecraft.client.options.GameOptions;
import net.minecraft.client.sound.SoundInstance;
import net.minecraft.client.sound.SoundManager;
import net.minecraft.client.sound.TickableSoundInstance;
import net.minecraft.resource.ResourceManager;
import net.minecraft.sound.SoundCategory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * This class encapsulates all the mixin's that are required in the minecraft SoundManager
 */


@Mixin(SoundSystem.class)
public class SoundSystemMixin {
    @Inject(at = @At("HEAD"), method = "play(Lnet/minecraft/client/sound/SoundInstance;)V")
    private void playOnce(SoundInstance sound, CallbackInfo info) {

    }
}



