package net.spatial.audio;

import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvents;

public class BlockSoundProperties {
    public static final BlockSoundProperties AIR;
    public static final BlockSoundProperties WOOD;
    public static final BlockSoundProperties GRAVEL;
    public static final BlockSoundProperties GRASS;
    public static final BlockSoundProperties LILY_PAD;
    public static final BlockSoundProperties STONE;
    public static final BlockSoundProperties METAL;
    public static final BlockSoundProperties GLASS;
    public static final BlockSoundProperties WOOL;
    public static final BlockSoundProperties SAND;
    public static final BlockSoundProperties SNOW;
    public static final BlockSoundProperties LADDER;
    public static final BlockSoundProperties ANVIL;
    public static final BlockSoundProperties SLIME;
    public static final BlockSoundProperties HONEY;
    public static final BlockSoundProperties WET_GRASS;
    public static final BlockSoundProperties CORAL;
    public static final BlockSoundProperties BAMBOO;
    public static final BlockSoundProperties BAMBOO_SAPLING;
    public static final BlockSoundProperties SCAFFOLDING;
    public static final BlockSoundProperties SWEET_BERRY_BUSH;
    public static final BlockSoundProperties CROP;
    public static final BlockSoundProperties STEM;
    public static final BlockSoundProperties VINE;
    public static final BlockSoundProperties NETHER_WART;
    public static final BlockSoundProperties LANTERN;
    public static final BlockSoundProperties NETHER_STEM;
    public static final BlockSoundProperties NYLIUM;
    public static final BlockSoundProperties FUNGUS;
    public static final BlockSoundProperties ROOTS;
    public static final BlockSoundProperties SHROOMLIGHT;
    public static final BlockSoundProperties WEEPING_VINES;
    public static final BlockSoundProperties WEEPING_VINES_LOW_PITCH;
    public static final BlockSoundProperties SOUL_SAND;
    public static final BlockSoundProperties SOUL_SOIL;
    public static final BlockSoundProperties BASALT;
    public static final BlockSoundProperties WART_BLOCK;
    public static final BlockSoundProperties NETHERRACK;
    public static final BlockSoundProperties NETHER_BRICKS;
    public static final BlockSoundProperties NETHER_SPROUTS;
    public static final BlockSoundProperties NETHER_ORE;
    public static final BlockSoundProperties BONE;
    public static final BlockSoundProperties NETHERITE;
    public static final BlockSoundProperties ANCIENT_DEBRIS;
    public static final BlockSoundProperties LODESTONE;
    public static final BlockSoundProperties CHAIN;
    public static final BlockSoundProperties NETHER_GOLD_ORE;
    public static final BlockSoundProperties GILDED_BLACKSTONE;
    public final String name;
    public final float absorption;
    public final float reflection;

    public BlockSoundProperties(String name, float absorption, float reflection){
        this.name = name;
        this.absorption = absorption;
        this.reflection = reflection;
    }

    public float getAbsorption() {
        return this.absorption;
    }

    public float getReflection() {
        return this.reflection;
    }

    public String getName() {
        return this.name;
    }

    static{
        AIR = new BlockSoundProperties("AIR", 0, 0);
        WOOD = new BlockSoundProperties( "WOOD",1.0F, 1.0F);
        GRAVEL = new BlockSoundProperties( "GRAVEL", 1.0F, 1.0F);
        GRASS = new BlockSoundProperties( "GRASS", 1.0F, 1.0F);
        LILY_PAD = new BlockSoundProperties( "LILY_PAD", 1.0F, 1.0F);
        STONE = new BlockSoundProperties( "STONE", 1.0F, 1.0F);
        METAL = new BlockSoundProperties( "METAL",1.0F, 1.0F);
        GLASS = new BlockSoundProperties( "GLASS",1.0F, 1.0F);
        WOOL = new BlockSoundProperties( "WOOL",1.0F, 1.0F);
        SAND = new BlockSoundProperties( "SAND",1.0F, 1.0F);
        SNOW = new BlockSoundProperties( "SNOW",1.0F, 1.0F);
        LADDER = new BlockSoundProperties( "LADDER",1.0F, 1.0F);
        ANVIL = new BlockSoundProperties( "ANVIL",1.0F, 1.0F);
        SLIME = new BlockSoundProperties( "SLIME",1.0F, 1.0F);
        HONEY = new BlockSoundProperties( "HONEY",1.0F, 1.0F);
        WET_GRASS = new BlockSoundProperties( "WET_GRASS",1.0F, 1.0F);
        CORAL = new BlockSoundProperties( "CORAL",1.0F, 1.0F);
        BAMBOO = new BlockSoundProperties( "BAMBOO",1.0F, 1.0F);
        BAMBOO_SAPLING = new BlockSoundProperties( "BAMBOO_SAPLING",1.0F, 1.0F);
        SCAFFOLDING = new BlockSoundProperties( "SCAFFOLDING",1.0F, 1.0F);
        SWEET_BERRY_BUSH = new BlockSoundProperties( "SWEET_BERRY_BUSH",1.0F, 1.0F);
        CROP = new BlockSoundProperties( "CROP",1.0F, 1.0F);
        STEM = new BlockSoundProperties( "STEM",1.0F, 1.0F);
        VINE = new BlockSoundProperties( "VINE",1.0F, 1.0F);
        NETHER_WART = new BlockSoundProperties( "NETHER_WART",1.0F, 1.0F);
        LANTERN = new BlockSoundProperties( "LANTERN",1.0F, 1.0F);
        NETHER_STEM = new BlockSoundProperties( "NETHER_STEM",1.0F, 1.0F);
        NYLIUM = new BlockSoundProperties( "NYLIUM",1.0F, 1.0F);
        FUNGUS = new BlockSoundProperties( "FUNGUS",1.0F, 1.0F);
        ROOTS = new BlockSoundProperties( "ROOTS",1.0F, 1.0F);
        SHROOMLIGHT = new BlockSoundProperties( "SHROOMLIGHT",1.0F, 1.0F);
        WEEPING_VINES = new BlockSoundProperties( "WEEPING_VINES",1.0F, 1.0F);
        WEEPING_VINES_LOW_PITCH = new BlockSoundProperties( "WEEPING_VINES_LOW_PITCH",1.0F, 1.0F);
        SOUL_SAND = new BlockSoundProperties( "SOUL_SAND",1.0F, 1.0F);
        SOUL_SOIL = new BlockSoundProperties( "SOUL_SOIL",1.0F, 1.0F);
        BASALT = new BlockSoundProperties( "BASALT",1.0F, 1.0F);
        WART_BLOCK = new BlockSoundProperties( "WART_BLOCK",1.0F, 1.0F);
        NETHERRACK = new BlockSoundProperties( "NETHERRACK",1.0F, 1.0F);
        NETHER_BRICKS = new BlockSoundProperties( "NETHER_BRICKS",1.0F, 1.0F);
        NETHER_SPROUTS = new BlockSoundProperties( "NETHER_SPROUTS",1.0F, 1.0F);
        NETHER_ORE = new BlockSoundProperties( "NETHER_ORE",1.0F, 1.0F);
        BONE = new BlockSoundProperties( "BONE",1.0F, 1.0F);
        NETHERITE = new BlockSoundProperties( "NETHERITE",1.0F, 1.0F);
        ANCIENT_DEBRIS = new BlockSoundProperties( "ANCIENT_DEBRIS",1.0F, 1.0F);
        LODESTONE = new BlockSoundProperties( "LODESTONE",1.0F, 1.0F);
        CHAIN = new BlockSoundProperties( "CHAIN",1.0F, 1.0F);
        NETHER_GOLD_ORE = new BlockSoundProperties( "NETHER_GOLD_ORE",1.0F, 1.0F);
        GILDED_BLACKSTONE = new BlockSoundProperties( "GILDED_BLACKSTONE",1.0F, 1.0F);
    }
}
