package emeraldCasino.api.games.card.core;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import emeraldCasino.api.games.card.ACardGame;
import net.minecraft.entity.player.EntityPlayer;


public class Hand {
	private ArrayList<ICard> cards = new ArrayList<ICard>();
	
	public Hand() {
	}
	
	public List<ICard> getCards()
	{
		return this.cards;
	}
	
	public void addCard(ICard card){
		cards.add(card);
	}
	
	public ICard removeCard(){
		return removeCard(0);
	}
	
	public ICard removeCard(int index){
		ICard  temp = cards.get(index);
		cards.remove(index);
		return temp;
	}
	
	public void play(ACardGame game){
		play(game,this.cards);	
	}
	
	public void play(ACardGame game,ICard card){
		List<ICard> cards = new LinkedList<ICard>();
		cards.add(card);
		play(game,cards);	
	}
	
	public void play(ACardGame game, List<ICard> cards){
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
