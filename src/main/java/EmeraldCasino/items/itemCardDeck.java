package EmeraldCasino.items;

import EmeraldCasino.EmeraldCasino;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
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
		if(player.isSneaking())
		{
		incrementDamage(stack);
		System.out.println("Dmg Val: "+stack.getItemDamage());
		return true;
		}
		else if((world.getBlock(x, y, z)!=Blocks.air)&&(world.getBlock(x, y+1, z)==Blocks.air))
			{
			Block temp =  GameRegistry.findBlock(EmeraldCasino.MODID, "cardDeck");
			if (temp!= null){
				world.setBlock(x, y+1, z,temp);
				//world.setBlockMetadataWithNotify(x, y+1, z, stack.getItemDamage(), 2);
				return true;
			}else{
			System.out.println("Null Returned!");
		
		}
			
		}
		return false;
	}

	private void incrementDamage(ItemStack stack) {
		int temp = stack.getItemDamage();
		stack.setItemDamage(1+temp);
		if(stack.getItemDamage()>stack.getMaxDamage()){
			stack.setItemDamage(stack.getItemDamage()-stack.getMaxDamage());
		}
		
	}
	
}
