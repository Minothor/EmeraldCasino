package EmeraldCasino.cards;

import java.util.ArrayList;

import net.minecraft.entity.player.EntityPlayer;

public class Player {
	ArrayList <Hand> hands = new ArrayList <Hand>();
	EntityPlayer player;
	
	public Player(EntityPlayer player) {
		this(new Hand(), player);
	}
	
	public Player (Hand h, EntityPlayer player){
		this.hands.add(h);
		this.player = player;
	}	
	
	public void splitHand(int handIndex, int cardIndex){
		Hand a = new Hand();
		for(int i=this.hands.get(handIndex).size();i>=cardIndex;i--){
			a.addCard(this.hands.get(handIndex).removeCard());
		}
		this.hands.add(a);	
	}
	
	public void splitHand(int cardIndex){
		splitHand(0,cardIndex);
	}
	
	public Hand getHand(){
		return getHand(0);
	}
	
	public Hand getHand(int index){
		return this.hands.get(index);
	}

}
