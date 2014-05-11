package EmeraldCasino.blocks;

import EmeraldCasino.cards.*;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.IIcon;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class blockCardDeck extends Block{
	private Game game;
	
	
	protected blockCardDeck(Material p_i45394_1_) {
		super(Material.carpet);
		setBlockName("BlockCardDeck");
		setStepSound(Block.soundTypeSnow);
	}

	
	@SideOnly(Side.CLIENT)
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess thisblock, int x, int y, int z){
		int metaD = thisblock.getBlockMetadata(x, y, z);
		switch (metaD)
        {
			case 8:
        	thisblock.getBlock(x, y, z).setBlockBounds(0.0625F, 0.0625F, 0.0F, 0.9375F, 0.9375F, 1.0F);
        	break;
			case 4:
        	thisblock.getBlock(x, y, z).setBlockBounds(0.0F, 0.0625F, 0.0625F, 1.0F, 0.9375F, 0.9375F);
        	break;
			case 0:
			default:
        	thisblock.getBlock(x, y, z).setBlockBounds(0.0625F, 0.0F, 0.0625F, 0.9375F, 1.0F, 0.9375F);
        	break;
        }
		
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public boolean renderAsNormalBlock()
    {
                    return false;
    }
	@SideOnly(Side.CLIENT)
	@Override
	public boolean isOpaqueCube()
    {
                    return false;
    }
	
	@SideOnly(Side.CLIENT)
	protected IIcon[] icons;


	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
		this.icons = new IIcon[2];
		//System.out.println("Icon Array Length: "+ icons.length);
		this.icons[0] = par1IconRegister.registerIcon("minecraft:log_oak_top");
		System.out.println("icons 0 :" + icons[0]);
		this.icons[1] = par1IconRegister.registerIcon("minecraft:log_oak_top");
		//System.out.println("icons 1 :" + icons[1]);
	}

	@SideOnly(Side.CLIENT)
	//@Override
	public IIcon getIcon(int metaD)
	{
		return this.icons[1];
	}
	
	
	public int onBlockPlaced (World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int metaD)
	{
		
		switch (side)
        {
        case 0:
        case 1:
            metaD = 0;
            break;
        case 2:
        case 3:
            metaD = 8;
            break;
        case 4:
        case 5:
            metaD = 4;
            break;
        }
		world.setBlockMetadataWithNotify(x, y, z, metaD,3);
		return metaD;
	}
	
	
	
}
