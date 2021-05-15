package net.spatial.audio;

import net.fabricmc.api.ModInitializer;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.sound.SoundInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
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

	/**
	 * TODO Initialize data structures and additional OpenAL buffers/AFX modules here. (Needed for reverb effects)
	 *
	 */
	public static void init(){
		mcInstance = MinecraftClient.getInstance();
		System.out.println("Initializing Spatial Audio...");
		System.out.println("Spatial Audio Initialized");
	}

	/**Test of simple audio "shading" modification. Calculates the # blocks between source and listener and decreases volume accordingly.
	 * TODO Initialize accumulator which increases in attenuation based on the "absorption" of the block that is encountered.
	 * TODO Pass back accumulated attenuation to the SoundManager to decrease the play volume associated with each sound.
	 * TODO Refactor into separate physics class.
	 */
	public static int occlusion(SoundInstance sound){
		int occlusionScore = 0;
	    PlayerEntity player = mcInstance.player;
	    World world = mcInstance.world;
        Vec3d playerPos; //DONE place playerPos at player head height, not feet


		if(world != null){
			try {
				//DONE place playerPos at player head height, not feet, uses getStandingEyeHeight which accounts for the current player pose (crouch, crawl, fly..etc)
				playerPos = new Vec3d(player.getX(), player.getY() + player.getStandingEyeHeight(), player.getZ());
				Vec3d soundPos = new Vec3d(sound.getX()-0.5, sound.getY(), sound.getZ()-0.5); //move sound start to center of block


				/**
				 * Vector from soundsource to player (P-S)
				 * DONE update soundsouce position to be on the edge (or outside of) the block it "starts in" in the direction of the player.
				 * 0.866025403784 is half the length of the 3D unit vector, this accounts for the worst (corner) case, and in all other will move "into the block" adjacent
				 * Shouldn't cause issues. The more precise alternative would be to move the starting point to the "edge" of the block along the raycasting vector.
				 */
				Vec3d soundToPlayer = playerPos.subtract(soundPos).normalize();
				Vec3d raySource = soundPos.add(soundToPlayer.multiply(0.866025403784));

				/**
				 * TODO loop over all blocks between sound source and player and accumulate their total attenuation
				 */
				Integer numCollisions = 0;
				Boolean collision = true;

				do{
					BlockHitResult bk = world.raycast(new RaycastContext(raySource, playerPos, RaycastContext.ShapeType.COLLIDER, RaycastContext.FluidHandling.ANY, player));
					HitResult.Type type = bk.getType();

					if (type != HitResult.Type.BLOCK) {
						System.out.println("No blocks between " + sound.getId() + " and listener");
						collision = false;
					} else {
						BlockState hit = world.getBlockState(bk.getBlockPos());
						System.out.println("Block between " + sound.getId() + " and listener: " + getSoundType(hit) + " at " + bk.getPos());
						//DONE change this adjustment so it will move to the edge of the struck block towards the player, currently it will move one block at a time
						// IE:  skip ray traces over large gaps and will strike the each block once.
						raySource = bk.getPos().add(soundToPlayer); //move the starting position towards the "player side" of the rayCast Hit block. Vector aligned.
						//raySource = raySource.add;
						numCollisions++;
						collision = true;
					}

				}while(collision == true);
				//TODO pass back accumulated total of blocks hits and adjust sound volume accordingly.
				//IE blocks behind a thick wall of wool/stone should be much quieter than ones with nothing in between
				System.out.println("Number of blocks between " + sound.getId() + " and listener: " + numCollisions);
				occlusionScore = numCollisions;

			} catch (NullPointerException e) {
				//yeet
			}
		}

		return occlusionScore;
	}

	//TODO use Block.getSoundGroup() to manage the acousticProperties of certain blocks.
	public static String getSoundType(BlockState blockState){
		BlockSoundGroup soundGroup = blockState.getBlock().getSoundGroup(blockState);

		if (soundGroup == BlockSoundGroup.WOOD){
			return "WOOD";
		}else if(soundGroup == BlockSoundGroup.GRAVEL){
			return  "GRAVEL";
		}else if(soundGroup == BlockSoundGroup.GRASS){
			return  "GRASS";
		}else if(soundGroup == BlockSoundGroup.LILY_PAD){
			return  "LILY_PAD";
		}else if(soundGroup == BlockSoundGroup.STONE){
			return  "STONE";
		}else if(soundGroup == BlockSoundGroup.METAL){
			return  "METAL";
		}else if(soundGroup == BlockSoundGroup.GLASS){
			return  "GLASS";
		}else if(soundGroup == BlockSoundGroup.WOOL){
			return  "WOOL";
		}else if(soundGroup == BlockSoundGroup.SAND){
			return  "SAND";
		}else if(soundGroup == BlockSoundGroup.SNOW){
			return  "SNOW";
		}else if(soundGroup == BlockSoundGroup.LADDER){
			return  "LADDER";
		}else if(soundGroup == BlockSoundGroup.ANVIL){
			return  "ANVIL";
		}
		return "error";
	}
}
