package EmeraldCasino.financial;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public final class ItemHandler {
	private ItemHandler() {
	}
	
	public static int depositItems(List<ItemStack> inputItems)
	{	
		int result = 0;
		int emBlocks = 0;
		int emItems =  0;
		int goBlocks =  0;
		int goItems  =  0;
		int goNuggets  =  0;
		// TODO Verify Item types from the list.
		for (ItemStack itemStack : inputItems) {
			Item itemType = itemStack.getItem();
			int itemNum = itemStack.stackSize;
			
			
			if(itemType == Item.getItemFromBlock(Blocks.emerald_block)){
				emBlocks+=itemNum;
				System.out.println("Added "+itemNum+" Items.emerald Blocks");
			} else	if(itemType == Items.emerald){
				emItems+=itemNum;
				System.out.println("Added "+itemNum+" Items.emeralds");
			} else if(itemType == Item.getItemFromBlock(Blocks.gold_block)){
				goBlocks+=itemNum;
				System.out.println("Added "+itemNum+" Gold Blocks");
			} else if(itemType == Items.gold_ingot){
				goItems+=itemNum;
				System.out.println("Added "+itemNum+" Gold Ingots");
			} else if(itemType == Items.gold_nugget){
				goNuggets+=itemNum;
				System.out.println("Added "+itemNum+" Gold Nuggets");
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
	 * 
	 * @param inputNonary The Nonary value of items being withdrawn.
	 * @return List of ItemStacks
	 */
	public static List<ItemStack> withdrawItems(int inputNonary)
	{	
		System.out.println("Integer "+inputNonary+" Translates into:");
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
		//Checking if Items.emeralds can be compressed into one stack
				if (((emBlocks*9)+emItems)<=64){
					emItems+=(emBlocks*9);
					emBlocks=0;
				}
		//Checking if Gold can be compressed into one stack
				if (((goBlocks*9)+goItems)<=64){
					goItems+=(goBlocks*9);
					goBlocks=0;
				}
		
		
		System.out.println("Items.emeralds:\nBlocks: "+emBlocks+"\nItems: "+emItems);
		System.out.println("Gold:\nBlocks: "+goBlocks+"\nIngots: "+goItems+"\nNuggets: "+goNuggets);
		
		
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
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		System.out.println("Returned Nonary: "+depositItems(withdrawItems(62001)));
		long end = System.currentTimeMillis();
		System.out.println((end - start) + " ms");
	}
}
