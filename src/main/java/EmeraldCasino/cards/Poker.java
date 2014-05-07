package cards;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import cards.Game;
public class Poker extends Game {
	private boolean royal = false,flush = false,straight = false;
	private ArrayList<Integer> oK4 =new ArrayList<Integer>();
	private ArrayList<Integer> oK3 =new ArrayList<Integer>();
	private ArrayList<Integer> oK2 =new ArrayList<Integer>();
	public Poker() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public void DealCards(){
		for (int i = 0; i>playerHands.size();i++){
			this.playerHands.get(i).takeCard(this.deck);			
		}
	}
	
	protected void checkMultis(ArrayList<Card> cards){
		oK2.clear();
		int cardValue;
		Map<Integer,Integer> cardVals= new HashMap<Integer,Integer>();
		for (Card card : cards) {
			cardValue=card.getValue();
			Integer val = cardVals.get(cardValue);
			val = (val==null?0:val);
			cardVals.put(cardValue,1+val);
		}
		System.out.println(cardVals.toString());
		for(Map.Entry entry: cardVals.entrySet()){
			if((int) entry.getValue()==2){
				this.oK2.add((Integer) entry.getKey());
			}
			
			if((int) entry.getValue()==3){
				this.oK3.add((Integer) entry.getKey());
			}
			
			if((int) entry.getValue()==4){
				this.oK4.add((Integer) entry.getKey());
			}
            
        }
	}
	
	protected boolean checkStraight(ArrayList<Card> cards){
		int diff=1;
		int size=cards.size();
		boolean result = false;
		for(int i=1; i<size&&diff==1;i++){
			diff=cards.get(i-1).getValue()-cards.get(i).getValue();
			if(i==size-1 && (diff==1||diff==9)){
				result=true;
			}
		}
		return result;
	}
	
	protected boolean checkFlush(ArrayList<Card> cards){
		int size=cards.size();
		int diff=0;
		boolean result = false;
		for(int i=1; i<size&&diff==0;i++){
			diff=cards.get(i-1).getHouse()-cards.get(i).getHouse();
			if(i==size-1&&diff==0){
				result=true;
			}
		}
		return result;
	}
	
	protected boolean checkRoyal(ArrayList<Card> cards){
		int size=cards.size();
		boolean result = false;
		if((cards.get(0).getValue()==13)&&(cards.get(size-1).getValue()==1)){
				result=true;
		}
		return result;
	}
	
	@Override
	protected int EvalHand(ArrayList<Card> cards){
		int priority1=1;
		
		//int[] priority={0,0,0,0};
		ArrayList<Card> toSort= new ArrayList<Card>(), toEval;
		toSort.addAll(tableCards);
		toSort.addAll(cards);
		toEval = sortCards(toSort);
		
		checkMultis(toEval);
		if(!oK2.isEmpty()){
			priority1+=oK2.size();
		}
		
		if(!oK3.isEmpty()){
			priority1+=(3*oK3.size());
		}
		
		if(!oK4.isEmpty()){
			priority1+=7;
		}
		
		if(oK2.isEmpty()&&oK3.isEmpty()&&oK4.isEmpty()){
		straight=checkStraight(toEval);
			if(straight){
				priority1+=4;
			}
		}
		
		if(priority1==5&&(!straight)){
			priority1+=2;
		}
		
		flush=checkFlush(toEval);
		if(flush){
			priority1+=5;
		}
		
		if(flush&&straight){
			priority1-=checkRoyal(toEval)?0:1;
		}
		return priority1;
	} 
}
