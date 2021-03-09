package net.spatial.audio.mixin;

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


@Mixin(SoundManager.class)
public class SpatialMixin {
	@Inject(at = @At("RETURN"), method = "<init>(Lnet/minecraft/resource/ResourceManager;Lnet/minecraft/client/options/GameOptions;)V")
	private void init(ResourceManager resourceManager, GameOptions gameOptions, CallbackInfo info) {
		System.out.println("Calling SpatialAudio init from SoundManager init.");
		SpatialAudio.init();
	}

	@Inject(at = @At("HEAD"), method = "play(Lnet/minecraft/client/sound/SoundInstance;)V", cancellable = true)
	private void playOnce(SoundInstance sound, CallbackInfo info) {
		System.out.println("Sound Playing: " +sound.getId());
		if (sound.getCategory() == SoundCategory.BLOCKS){
			System.out.println("Currently Playing " + sound.getId() + " " + sound.getCategory() + " at " + sound.getX() + " " + sound.getY() + " " + sound.getZ());
			SpatialAudio.occlusion(sound);
			//info.soundSystem.play(sound);
		}
		//info.cancel();
	}

	@Inject(at = @At("HEAD"), method = "play(Lnet/minecraft/client/sound/SoundInstance;I)V")
	private void playDelay(SoundInstance sound, int delay, CallbackInfo info) {
		//System.out.println("This line is printed each time a sound plays");
		System.out.println("Delayed sound was triggered: Queuing "+sound.getId()+" with "+delay+" ms delay");

	}

	@Inject(at = @At("HEAD"), method = "playNextTick")
	private void playTickable(TickableSoundInstance sound, CallbackInfo info) {
		//System.out.println("This line is printed each time a sound plays");
		System.out.println("Tickable sound currently playing: " + sound.getId());

	}
}


