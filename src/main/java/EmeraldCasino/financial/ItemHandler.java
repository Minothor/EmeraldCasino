package EmeraldCasino.financial;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * ItemStack - Base-9 value Conversion Library for Emerald Casino.
 * @author Minothor
 * @version 1.0
 * 
 */
public final class ItemHandler {
	private ItemHandler() {
	}
	
	/**
	 * Takes a List of ItemStacks and returns a Base-9 integer value for that list of Stacks.
	 * Items are automatically compressed into Blocks as a result of the Base-9 counting system.
	 * @param inputItems List of ItemStacks, order is irrelevant and only Valid items will be parsed.
	 * @return Base-9 integer value of input stacks @see Nonary.java
	 */
	public static int depositItems(List<ItemStack> inputItems)
	{	
		int result = 0;
		int emBlocks = 0;
		int emItems =  0;
		int goBlocks =  0;
		int goItems  =  0;
		int goNuggets  =  0;
		
		for (ItemStack itemStack : inputItems) {
			Item itemType = itemStack.getItem();
			int itemNum = itemStack.stackSize;
			
			
			if(itemType == Item.getItemFromBlock(Blocks.emerald_block)){
				emBlocks+=itemNum;
			} else	if(itemType == Items.emerald){
				emItems+=itemNum;
			} else if(itemType == Item.getItemFromBlock(Blocks.gold_block)){
				goBlocks+=itemNum;
			} else if(itemType == Items.gold_ingot){
				goItems+=itemNum;
			} else if(itemType == Items.gold_nugget){
				goNuggets+=itemNum;
			}
			
		}
		
		
		//CleanUp time:		
		//Checking if Items.emeralds can be compressed into one stack
				if (emItems>8){
					emBlocks+=(emItems/9);
					emItems%=9;
				}
				//Checking if Gold Nuggets can be compressed into Blocks
				if (goNuggets>8){
					goItems+=(goNuggets/9);
					goNuggets%=9;
				}
		//Checking if Gold can be compressed into one stack
				if (goItems>8){
					goBlocks+=(goItems/9);
					goItems%=9;
				}
				
				
				result=Nonary.toNonary(emBlocks*6561);
				result=Nonary.add(result, Nonary.toNonary(emItems*729));
				result=Nonary.add(result, Nonary.toNonary(goBlocks*81));
				result=Nonary.add(result, Nonary.toNonary(goItems*9));
				result=Nonary.add(result, Nonary.toNonary(goNuggets));
				
		return result;
	}
	
	/**
	 * Takes a Base-9 integer and returns a list of ItemStacks matching that value.
	 * Small numbers of blocks will be compressed into stacks of Items if possible to save inventory space. 
	 * @param inputNonary The Base-9 value of items being withdrawn. @see Nonary.java
	 * @return List of ItemStacks
	 */
	public static List<ItemStack> withdrawItems(int inputNonary)
	{	
		List<ItemStack> ReturnItems = new ArrayList<>(5);
		
		//safety checks
		int emBlocks = (inputNonary/10000);
		if(emBlocks<0) emBlocks=0;
		
		int emItems =  (inputNonary-=(emBlocks*10000))/1000;
		if(emItems<0) emItems=0;
		
		int goBlocks =  (inputNonary-=(emItems*1000))/100;
		if(goBlocks<0) goBlocks=0;
		
		int goItems  =  (inputNonary-=(goBlocks*100))/10;
		if(goItems<0) goItems=0;
		
		int goNuggets  =  (inputNonary-=(goItems*10));
		if(goNuggets<0) goNuggets=0;
		
		//CleanUp time:
		//Checking if Emeralds can be compressed into one stack
				if (((emBlocks*9)+emItems)<=64){
					emItems+=(emBlocks*9);
					emBlocks=0;
				}
		//Checking if Gold can be compressed into one stack
				if (((goBlocks*9)+goItems)<=64){
					goItems+=(goBlocks*9);
					goBlocks=0;
				}
		
		while(emBlocks>64){
			ReturnItems.add(new ItemStack(Blocks.emerald_block, 64));
			emBlocks-=64;
		}
		if(emBlocks>0)
		ReturnItems.add(new ItemStack(Blocks.emerald_block, emBlocks));
		
		if(emItems>0)
		ReturnItems.add(new ItemStack(Items.emerald, emItems));
		
		if(goBlocks>0)
		ReturnItems.add(new ItemStack(Blocks.gold_block, goBlocks));
		
		if(goItems>0)
		ReturnItems.add(new ItemStack(Items.gold_ingot, goItems));
		
		if(goNuggets>0)
		ReturnItems.add(new ItemStack(Items.gold_nugget, goNuggets));
		
		return ReturnItems;
	}
}
