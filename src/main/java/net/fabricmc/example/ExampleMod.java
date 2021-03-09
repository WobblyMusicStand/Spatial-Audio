package net.fabricmc.example;

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

public class ExampleMod implements ModInitializer {
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
		System.out.println("Initializing Sound Plugin...");
	}

	/*Test of simple audio "shading" modification. Calculates the # blocks between source and listener and decreases volume accordingly.*/
	public static void occlusion(SoundInstance sound){
	   /* PlayerEntity player = mcInstance.player;
	    World world = mcInstance.world;
        Vec3d playerPos;

	    try {
            playerPos = player.getPos();
            Vec3d soundPos = new Vec3d(sound.getX(), sound.getY(), sound.getZ());
            BlockHitResult bk = world.raycast(new RaycastContext(soundPos, playerPos, RaycastContext.ShapeType.COLLIDER, RaycastContext.FluidHandling.ANY, player));
            HitResult.Type type = bk.getType();
            //while ()
            if (type != HitResult.Type.BLOCK) {
                System.out.println("No blocks between " + sound.getId() + "and listener");
            } else {
                BlockState hit = world.getBlockState(bk.getBlockPos());
                System.out.println("Hit block between sound source and player " +  hit.getSoundGroup() + " at " + bk.getBlockPos());
            }
            //BlockView.raycast();

        } catch (NullPointerException e) {
	        //yeet
        }
*/


	}
}
