package EmeraldCasino.cards;

import net.minecraft.entity.player.EntityPlayer;

public class Player {
	Hand hand;
	EntityPlayer player;
	
	public Player() {
		this(new Hand());
	}
	
	public Player (Hand h){
		this.hand=h;
	}

}
