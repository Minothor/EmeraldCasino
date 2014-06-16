package EmeraldCasino.blocks;

import java.util.Random;

import EmeraldCasino.blocks.tileEntities.TileEntityCardBlock;
import EmeraldCasino.games.cards.*;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class blockCardDeck extends BlockContainer{
	private Game game;
	
	
	public blockCardDeck() {
		super(Material.carpet);
		setBlockName("cardDeck");
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
	
	@Override
    public int getRenderType() {
            return -1;
    }
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister icon) {
        this.blockIcon = icon.registerIcon("emeraldcasino:CardDeckIcon");
}
	
	@SideOnly(Side.CLIENT)
	protected IIcon[] icons;

	@Override
	public int onBlockPlaced (World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int metaD)
	{
		
		/*switch (side)
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
        }*/
		world.setBlockMetadataWithNotify(x, y, z, metaD,3);
		return metaD;
	}
	
	

	@Override
	public TileEntity createNewTileEntity(World world, int metadata) {
		return new TileEntityCardBlock();
	}
	
	
}
