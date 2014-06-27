package emeraldCasino.api.games.card.core;

import java.util.Comparator;

public class Card{
	private int house, value;
	
	public Card(int i, int j){
		if (j>13||j<1){
			throw new IllegalArgumentException("Card Value between 1 and 13 expected. Recieved: "+j);
		}
		if (i>4||i<1){
			throw new IllegalArgumentException("Card house between 1 and 4 expected. Recieved: "+j);
		}
		this.house=i;
		this.value=j;
	}

	public int getValue(){
		return this.value;
	}
	
	public int getHouse(){
		return this.house;
	}
	public String toString(){
		String value="",house="";
		switch(this.value){
		case 1: value = "Ace"; break;
		case 11: value = "Jack"; break;
		case 12: value = "Queen"; break;
		case 13: value = "King"; break;
		default: value = ""+this.value;
		}
		switch(this.house){
		case 1: house = "Spades"; break;
		case 2: house = "Hearts"; break;
		case 3: house = "Clubs"; break;
		case 4: house = "Diamonds"; break;
		}
		return(value+" of "+house);
	}
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Card)){
			return false;
		}
		Card c = (Card) obj;
		return (this.getValue()==c.getValue());
	}
	
	public static Comparator<Card> compareValue = new Comparator<Card>(){

		@Override
		public int compare(Card c1, Card c2) {
			Integer v1 = c1.getValue();
			Integer v2 = c2.getValue();
			return v1.compareTo(v2);
		}
		
	};
	
	public static Comparator<Card> compareHouse = new Comparator<Card>(){

		@Override
		public int compare(Card c1, Card c2) {
			Integer h1 = c1.getHouse();
			Integer h2 = c2.getHouse();
			return h1.compareTo(h2);
		}
		
	};
	
}
