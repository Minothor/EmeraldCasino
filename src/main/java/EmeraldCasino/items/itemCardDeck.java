package EmeraldCasino.items;

import EmeraldCasino.EmeraldCasino;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class itemCardDeck extends Item{
	
	public itemCardDeck() {
		super();
	}
	
	@Override
	public boolean isDamageable() {
		return true;
	};
	
	@Override
	public int getMaxDamage() {
		return 15;
	}
	
	@Override
	public void onCreated(ItemStack stack, World world, EntityPlayer player) {
	    stack.stackTagCompound = new NBTTagCompound();
	    stack.setItemDamage(0);
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ){
		/*if(player.isSneaking()){
		incrementDamage(stack);
		System.out.println("Dmg Val: "+stack.getItemDamage());
		return true;
		}*/
		if((world.getBlock(x, y, z)!=Blocks.air)&&(world.getBlock(x, y+1, z)==Blocks.air)){	
		world.setBlock(x, y+1, z, GameRegistry.findBlock(EmeraldCasino.MODID, "cardDeck"));
		//world.setBlockMetadataWithNotify(x, y+1, z, stack.getItemDamage(), 2);
		return true;
		}
		return false;
	}

	private void incrementDamage(ItemStack stack) {
		stack.setItemDamage(1+stack.getItemDamage());
		if(stack.getItemDamage()>stack.getMaxDamage()){
			stack.setItemDamage(stack.getItemDamage()-stack.getMaxDamage());
		}
		
	}
	
}
