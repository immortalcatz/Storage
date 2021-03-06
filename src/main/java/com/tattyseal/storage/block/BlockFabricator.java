package com.tattyseal.storage.block;

import com.tattyseal.storage.Storage;
import com.tattyseal.storage.tileentity.TileEntityFabricator;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class BlockFabricator extends BlockContainer
{
	public BlockFabricator()
	{
		super(Material.iron);
		setCreativeTab(CreativeTabs.tabDecorations);
		setUnlocalizedName("storageChest");
	}
	
	@Override
	public boolean isOpaqueCube() 
	{
		return false;
	}
	
	@Override
	public boolean isFullBlock()
	{
		return isOpaqueCube();
	}
	
	@Override
	public boolean isFullCube()
	{
		return isFullBlock();
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ) 
	{
		if(playerIn.isSneaking())
		{
			return false;
		}
		
		playerIn.openGui(Storage.instance, 1, worldIn, pos.getX(), pos.getY(), pos.getZ());
		return true;
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) 
	{
		return new TileEntityFabricator();
	}
}
