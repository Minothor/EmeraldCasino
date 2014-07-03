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
	public boolean isMap() {
		return true;
	}
	
	@Override
	public boolean doesSneakBypassUse(World world, int x, int y, int z, EntityPlayer player)
	{
		return false;
	}
	
	@Override
	public Item setNoRepair() {
		// TODO Auto-generated method stub
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
			EmeraldCasino.ECchannel.sendToServer(new GameMessage("Testing!"));
		}
		return false;
	}
	
	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player,
			Entity entity) {
		return super.onLeftClickEntity(stack, player, entity);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
	{
		System.out.println("RightClicked");
		if (player.isSneaking()){
			System.out.println("While Sneaking");
			EmeraldCasino.ECchannel.sendToServer(new GameMessage("Testing!"));
		}
		return itemStack;
	}
}
