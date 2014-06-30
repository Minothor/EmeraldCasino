package emeraldCasino.api.games.card.core;

import java.util.Comparator;

public class standardCard extends ACard{
	private int house, value;
	
	public standardCard(int i, int j){
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
		default: house = "Jokers";
		}
		return(value+" of "+house);
	}

	
}
