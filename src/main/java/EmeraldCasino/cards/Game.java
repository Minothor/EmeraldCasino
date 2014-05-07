package cards;

import java.util.ArrayList;
import java.util.List;

import cards.Card;
import cards.Deck;
import cards.Hand;
public class Game {

 protected List<Card> tableCards = new ArrayList<Card>();
 protected Hand dealerHand = new Hand(new playerEntity());
 protected List<Hand> playerHands = new ArrayList<Hand>();
 protected Deck deck = new Deck();
	public Game() {
	// TODO Auto-generated constructor stub
}
	protected void DealCards(){
		
	}
	
	protected int EvalHand(ArrayList<Card> cards){
		int priority1=1;
		List toEval=this.sortCards(cards);
		
		return priority1;
	} 
	
	protected ArrayList<Card> sortCards(ArrayList<Card> cards){
		System.out.println(this.toString(cards));
		Card temp;
		int sorted,i,length=cards.size();
		for(sorted=1;sorted<length;sorted++){
			temp=cards.get(sorted);
			for(i=(sorted-1);(i >= 0) && (cards.get(i).getValue()<temp.getValue());i--){
				cards.set(i+1,cards.get(i));
			}
			cards.set(i+1, temp);
		}
		
		System.out.println(this.toString(cards));
		return cards;
	}
	
	public void addPlayer(playerEntity player){
		this.playerHands.add(new Hand(player));
	}
	
	public String toString(ArrayList<Card> cards){
		String result="";
		for(int j = 0;j<cards.size();j++){
			result+=cards.get(j).toString()+"|";
		}
		return result;
	}
	
}
