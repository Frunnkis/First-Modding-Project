package com.frunnkis.firstmod.blocks;

import net.minecraft.inventory.container.ContainerType;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.registries.ObjectHolder;

public class ModBlocks {

    @ObjectHolder("firstmod:firstblock")
    public static FirstBlock FIRSTBLOCK;

    @ObjectHolder("firstmod:powerblock")
    public static PowerBlock POWERBLOCK;

    @ObjectHolder("firstmod:powerblock")
    public static TileEntityType<PowerBlockTile> POWERBLOCK_TILE;

    @ObjectHolder("firstmod:powerblock")
    public static ContainerType<PowerBlockContainer> POWERBLOCK_CONTAINER;
}
