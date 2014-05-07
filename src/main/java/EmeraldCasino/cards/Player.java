package EmeraldCasino.cards;

import net.minecraft.entity.player.EntityPlayer;

public class Player {
	Hand hand;
	EntityPlayer player;
	
	public Player(EntityPlayer player) {
		this(new Hand(), player);
	}
	
	public Player (Hand h, EntityPlayer player){
		this.hand=h;
		this.player = player;
	}

}
