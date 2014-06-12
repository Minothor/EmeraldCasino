package EmeraldCasino.blocks;

import EmeraldCasino.blocks.tileEntities.TileEntityCardBlock;
import EmeraldCasino.cards.*;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.tileentity.TileEntity;
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
	public boolean renderAsNormalBlock()
    {
                    return false;
    }
	
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess blockAccess, int x, int y, int z, int side) {
		return false;
	};
	
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
	
	public TileEntity createTileEntity(World world, int metadata)
	{
	   return new TileEntityCardBlock();
	}
	
	
}
