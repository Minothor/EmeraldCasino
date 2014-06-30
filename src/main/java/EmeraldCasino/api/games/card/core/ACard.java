package emeraldCasino.api.games.card.core;

import java.util.Comparator;

public abstract class ACard implements ICard{
private int house, value;
	public int getValue(){
		return this.value;
	}
	
	public int getHouse(){
		return this.house;
	}
	public String toString(){
		String value="",house="";
		switch(this.value){
		default: value = ""+this.value;
		}
		switch(this.house){
		default: house = "Cards"; break;
		}
		return(value+" of "+house);
	}
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof ICard)){
			return false;
		}
		ICard c = (ICard) obj;
		return (this.getValue()==c.getValue());
	}
	
	public static Comparator<ICard> compareValue = new Comparator<ICard>(){

		@Override
		public int compare(ICard c1, ICard c2) {
			Integer v1 = c1.getValue();
			Integer v2 = c2.getValue();
			return v1.compareTo(v2);
		}
		
	};
	
	public static Comparator<ICard> compareHouse = new Comparator<ICard>(){

		@Override
		public int compare(ICard c1, ICard c2) {
			Integer h1 = c1.getHouse();
			Integer h2 = c2.getHouse();
			return h1.compareTo(h2);
		}
		
	};
}
