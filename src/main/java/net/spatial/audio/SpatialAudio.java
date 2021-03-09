package net.spatial.audio;

import net.fabricmc.api.ModInitializer;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.sound.SoundInstance;
import net.minecraft.entity.Entity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.BlockView;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import org.apache.commons.lang3.ObjectUtils;
/*
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.sound.SoundManager;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.util.math.BlockPos;
import net.fabricmc.ex
import net.minecraft.world.RaycastContext;
 */


/**
 * This is the main class for Spatial Audio. It contains the callbacks that are mixed into the minecraft source code.
 * These trigger all the raycasting calculation for occlusion.
 */


public class SpatialAudio implements ModInitializer {
	private static MinecraftClient mcInstance;

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		/*Vec3d ray = new Vec3d;
		mc.world.raycastBlock();
		ProjectileUtil.raycast();
		mc.world.playSound();
		SoundMana*/
		System.out.println("Hello Fabric world!");
	}

	public static void init(){
		mcInstance = MinecraftClient.getInstance();
		System.out.println("Initializing Spatial Audio...");
		System.out.println("Spatial Audio Initialized");
	}

	/*Test of simple audio "shading" modification. Calculates the # blocks between source and listener and decreases volume accordingly.*/
	//TODO Initialize accumulator which increases in attenuation based on the "absorption" of the block that is encountered.
	//TODO Pass back accumulated attenuation to the SoundManager to decrease the play volume associated with each sound.
	public static void occlusion(SoundInstance sound){
	    PlayerEntity player = mcInstance.player;
	    World world = mcInstance.world;
        Vec3d playerPos; //TODO place playerPos at player head height, not feet
		//player.getStandingEyeHeight();

        //todo get distance from sound source
	    try {
	    	//playerPos = player.getPos();
            playerPos = new Vec3d(player.getX(), player.getY()+player.getStandingEyeHeight(), player.getZ());
            Vec3d soundPos = new Vec3d(sound.getX(), sound.getY(), sound.getZ());
            BlockHitResult bk = world.raycast(new RaycastContext(soundPos, playerPos, RaycastContext.ShapeType.COLLIDER, RaycastContext.FluidHandling.ANY, player));
            HitResult.Type type = bk.getType();
            //while ()
            if (type != HitResult.Type.BLOCK) {
                System.out.println("No blocks between " + sound.getId() + " and listener");
            } else {
                BlockState hit = world.getBlockState(bk.getBlockPos());
                BlockEntity ht = world.getBlockEntity(bk.getBlockPos());
                //hit.getBlock().getName()
						// hit.getSoundGroup()
                System.out.println("Block between " + sound.getId() + " and listener " + playerPos + ": " +  /*it.getBlock() +*/ " at " + bk.getBlockPos());
            }
            //BlockView.raycast();

        } catch (NullPointerException e) {
	        //yeet
        }
	}
}
