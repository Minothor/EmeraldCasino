package cards;

import cards.Card;

import java.util.ArrayList;
import java.util.List;


public class Deck {
	private List<Card> cards = new ArrayList<Card>();
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
		int length = cards.size(),target;
		Card temp;
		for(int i=0;i<=(length); i++){
			for(int j = 0;j<length;j++){
				target =(int) Math.rint((length-1)*Math.random());
				temp=cards.get(0);
				cards.set(0, cards.get(target));
				cards.set(target,temp);
			}
		}
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
