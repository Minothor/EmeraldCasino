package EmeraldCasino.financial;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public final class ItemHandler {
	private static final Block BLOCKEMERALD = Blocks.emerald_block;
	private static final Item EMERALD = Items.emerald;
	private static final Block BLOCKGOLD = Blocks.gold_block;
	private static final Item GOLD = Items.gold_ingot;
	private static final Item NUGGETGOLD = Items.gold_nugget;
	
	
	private ItemHandler() {
	}
	
	public static int depositItems(List<ItemStack> inputItems)
	{	
		int result = 0;
		//List<ItemStack> inputItems = new ArrayList(5);
		
		// TODO Verify Item types from the list.
		
		int emBlocks = (inputItems.get(0).stackSize);
		int emItems =  (inputItems.get(1).stackSize);
		int goBlocks =  (inputItems.get(2).stackSize);
		int goItems  =  (inputItems.get(3).stackSize);
		int goNuggets  =  (inputItems.get(4).stackSize);
		
		//CleanUp time:		
		//Checking if Emeralds can be compressed into one stack
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
		
		
		System.out.println("Emeralds:\nBlocks: "+emBlocks+"\nItems: "+emItems);
		System.out.println("Gold:\nBlocks: "+goBlocks+"\nIngots: "+goItems+"\nNuggets: "+goNuggets);
		
		
		while(emBlocks>64){
			ReturnItems.add(0, new ItemStack(BLOCKEMERALD, 64));
			emBlocks-=64;
		}
		if(emBlocks>0)
		ReturnItems.add(0, new ItemStack(BLOCKEMERALD, emBlocks));
		
		if(emItems>0)
		ReturnItems.add(1, new ItemStack(EMERALD, emItems));
		
		if(goBlocks>0)
		ReturnItems.add(2, new ItemStack(BLOCKGOLD, goBlocks));
		
		if(goItems>0)
		ReturnItems.add(3, new ItemStack(GOLD, goItems));
		
		if(goNuggets>0)
		ReturnItems.add(4, new ItemStack(NUGGETGOLD, goNuggets));
		
		return ReturnItems;
	}
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		System.out.println("Returned Nonary: "+depositItems(withdrawItems(62001)));
		long end = System.currentTimeMillis();
		System.out.println((end - start) + " ms");
	}
}
