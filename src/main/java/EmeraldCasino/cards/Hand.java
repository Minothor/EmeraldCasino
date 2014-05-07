package EmeraldCasino.cards;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;


public class Hand {
	private EntityPlayer player;
	public ArrayList<Card> cards = new ArrayList<Card>();
	
	public Hand() {
	}
	public void takeCard(Deck deck){
		cards.add(deck.takeCard());
		//System.out.println("Recieved: "+cards.get((cards.size()-1)).toString());
	}
	
	public void play(Game game){
		play(game,this.cards);	
	}
	
	public void play(Game game, Card card){
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(card);
		play(game,cards);	
	}
	
	public void play(Game game, ArrayList<Card> cards){
		int priority=game.EvalHand(cards);
		System.out.println("Hand Priority: "+priority);
	}
}
