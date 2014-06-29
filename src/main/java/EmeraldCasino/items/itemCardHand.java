package emeraldCasino.items;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
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
	public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack)
	{
		// TODO Auto-generated method stub
		return super.onEntitySwing(entityLiving, stack);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
	{
		System.out.println("RightClicked");
		if (player.isSneaking()){
			System.out.println("While Sneaking");
		}
		return itemStack;
	}
}
