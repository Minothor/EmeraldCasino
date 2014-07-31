package emeraldCasino.items;

import emeraldCasino.EmeraldCasino;
import emeraldCasino.network.packets.GameMessage;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemMapBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class itemCardHand extends Item implements IGameInterfaceItem{

	public itemCardHand()
	{
	}
	
	
	@Override
	public boolean doesSneakBypassUse(World world, int x, int y, int z, EntityPlayer player)
	{
		return false;
	}
	
	@Override
	public boolean isFull3D()
	{
		return true;
	};
	
	@Override
	public Item setNoRepair()
	{
		return super.setNoRepair();
	}
	
	@Override
	public boolean onDroppedByPlayer(ItemStack item, EntityPlayer player)
	{
		item=null;
		return false;
	}
	
	@Override
	public boolean onBlockStartBreak(ItemStack itemstack, int X, int Y, int Z, EntityPlayer player)
	{
		Block hit = player.getEntityWorld().getBlock(X, Y, Z);
		if (hit instanceof emeraldCasino.blocks.blockCardDeck)
		{
			if (player.isSneaking()){
				
			}else{
			EmeraldCasino.ECchannel.sendToServer(new GameMessage("PLAY."+X+"-"+Y+"-"+Z+"."+player.getDisplayName()));
			}
		}
		return false;
	}
	
	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player,
			Entity entity) {
		return super.onLeftClickEntity(stack, player, entity);
	}
	
	@Override
	public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack itemStack)
	{
		if (entityLiving instanceof EntityPlayer)
		{
			if (entityLiving.isSneaking()){
				int[] gameCoords = itemStack.getTagCompound().getIntArray("gameCoords");
				EmeraldCasino.ECchannel.sendToServer(new GameMessage("SELECT."+gameCoords[0]+"-"+gameCoords[1]+"-"+gameCoords[2]+"."+((EntityPlayer) entityLiving).getDisplayName()));
			}
			return true;
		}
		return false;
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
	{
		System.out.println("RightClicked");
		if (player.isSneaking()){
			int[] gameCoords = itemStack.getTagCompound().getIntArray("gameCoords");
			EmeraldCasino.ECchannel.sendToServer(new GameMessage("HOVER_NEXT."+gameCoords[0]+"-"+gameCoords[1]+"-"+gameCoords[2]+"."+player.getDisplayName()));
		}
		return itemStack;
	}
}
