package EmeraldCasino.events;


import java.awt.Event;

import org.lwjgl.input.Keyboard;

import net.minecraft.entity.player.*;
import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.world.World;
import cpw.mods.fml.common.gameevent.InputEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;
import cpw.mods.fml.common.event.FMLEvent;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent.KeyInputEvent;

public class cardHandHandler {
	
	private boolean sneaky=false;
	private EntityPlayer localPlayer;
	
	@SubscribeEvent(priority=EventPriority.HIGH, receiveCanceled=true)
	public void onEvent(PlayerTickEvent e){
		if(e.player.isSneaking()){
			sneaky=true;
			if(localPlayer==null)
				localPlayer=e.player;
		} else {
			sneaky = false;
		}
	}
	
	@SubscribeEvent(priority=EventPriority.HIGHEST, receiveCanceled=true)
	public void onEvent(InputEvent.KeyInputEvent e)
	{
		if(sneaky){
		int index=-1;
		int invSlot=localPlayer.inventory.currentItem;
		switch(Keyboard.getEventKey()){
		case Keyboard.KEY_1: index = 1; break;
		case Keyboard.KEY_2: index = 2; break;
		}
		if(index>=0){
			System.out.println(""+index+" Pressed");
		}
		localPlayer.inventory.changeCurrentItem(invSlot);
		}
	}
}
