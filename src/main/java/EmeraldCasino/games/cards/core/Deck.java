package EmeraldCasino.games.cards.core;



import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class Deck {
	private List<Card> cards = new LinkedList<Card>();
	private int deckSize = 52;
	public Deck(){
		byte house=1, value=1;
		for(byte i=0;i<deckSize;i++){
			cards.add(new Card(house,value));
			if(value==13){
				house++;
				value=1;
			}else{
			value++;
			}
		}
	}
	
	
	public void shuffle(){
		Collections.shuffle(cards);
	}
	
	public Card takeCard(){
		Card result=cards.get(0);
		cards.remove(0);
		return result;
	}
	
	public String toString(){
		String result="";
		for(int j = 0;j<cards.size();j++){
			result+=cards.get(j).toString()+"|";
		}
		return result;
	}
}
