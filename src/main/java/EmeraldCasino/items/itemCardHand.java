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
import net.minecraft.world.World;

public class itemCardHand extends Item{

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
		return super.onDroppedByPlayer(item, player);
	}
	
	@Override
	public boolean onBlockStartBreak(ItemStack itemstack, int X, int Y, int Z, EntityPlayer player)
	{
		Block hit = player.getEntityWorld().getBlock(X, Y, Z);
		if (hit instanceof emeraldCasino.blocks.blockCardDeck)
		{
			if (player.isSneaking()){
				
			}else{
			EmeraldCasino.ECchannel.sendToServer(new GameMessage("PLAY"));
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
	public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack)
	{
		if (entityLiving instanceof EntityPlayer)
		{
			if (entityLiving.isSneaking()){
				EmeraldCasino.ECchannel.sendToServer(new GameMessage("SELECT"));
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
			EmeraldCasino.ECchannel.sendToServer(new GameMessage("HOVER_NEXT"));
		}
		return itemStack;
	}
}
