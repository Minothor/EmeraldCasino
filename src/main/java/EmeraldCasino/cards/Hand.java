package EmeraldCasino.cards;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;


public class Hand {
	private ArrayList<Card> cards = new ArrayList<Card>();
	
	public Hand() {
	}
	public void addCard(Card card){
		cards.add(card);
	}
	
	public Card removeCard(){
		return removeCard(0);
	}
	
	public Card removeCard(int index){
		Card  temp = cards.get(index);
		cards.remove(index);
		return temp;
	}
	
	public void play(Game game){
		play(game,this.cards);	
	}
	
	public void play(Game game, Card card){
		List<Card> cards = new LinkedList<>();
		cards.add(card);
		play(game,cards);	
	}
	
	public void play(Game game, List<Card> cards){
		int[] priority=game.EvalHand(cards);
		System.out.println("Hand Priority: ");
		for (int i : priority) {
			System.out.println(i);
		}
	}
	public int size() {
		return this.cards.size();
	}
}
