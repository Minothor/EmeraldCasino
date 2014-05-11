package EmeraldCasino.cards;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import net.minecraft.init.Items;


// TODO: Auto-generated Javadoc
/**
 * The Poker Class.
 * Allows for games of basic 5 card draw.
 */
public class Poker extends Game {
	
	/** Booleans for flush and straight. Initialised to false. */
	protected boolean flush = false, straight = false;
	
	/** ArrayList of Integers for 4 of a Kind card values. */
	protected ArrayList<Integer> oK4 =new ArrayList<Integer>();
	
	/** ArrayList of Integers for 3 of a Kind card values. */
	protected ArrayList<Integer> oK3 =new ArrayList<Integer>();
	
	/** ArrayList of Integers for 4 of a Kind card values. */
	protected ArrayList<Integer> oK2 =new ArrayList<Integer>();
	
	/**
	 * Instantiates a new poker game.
	 */
	public Poker() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/* (non-Javadoc)
	 * @see EmeraldCasino.cards.Game#DealCards()
	 */
	@Override
	public void DealCards(){
		for (int i = 0; i>players.size();i++){
			this.players.get(i).getHand().addCard(this.deck.takeCard());			
		}
	}
	
	/**
	 * Check multis.
	 *
	 * @param cards the cards
	 */
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
		for(Map.Entry<Integer,Integer> entry: cardVals.entrySet()){
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
	
	/**
	 * Checks if the cards form a consecutive sequence.
	 *
	 * @param cards, the list of cards
	 * @return true, if successful
	 */
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
	
	/**
	 * Checks if the cards are all from the same house.
	 *
	 * @param cards, the list of cards.
	 * @return true, if successful
	 */
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
	
	/**
	 * Checks if the card hand is a royal flush.
	 *
	 * @param cards, the list of cards
	 * @return true, if successful
	 */
	protected boolean checkRoyal(ArrayList<Card> cards){
		int size=cards.size();
		boolean result = false;
		if((cards.get(0).getValue()==13)&&(cards.get(size-1).getValue()==1)){
				result=true;
		}
		return result;
	}
	
	
	/**
	 * EvalHand(ArrayList<Card>)
	 * Evaluates the Hand passed.
	 * 
	 * @param cards
	 * An array of cards to be evaluated according to the basic rules of Poker.
	 * 
	 * @return priority[]
	 * Returns an array of integers.
	 * First value is the Hand value, ranging from HighCard:1 to RoyalFlush:10
	 * Second value is the card value of 4 of a Kind, ranging from 2 to 14 (high ace)
	 * Third value is the card value of 3 of a Kind, ranging from 2 to 14 (high ace)
	 * Fourth value is the Highest pair value, ranging from 2 to 14 (high ace)
	 * Fifth value is the highest card value in the deck, ranging from 2 to 14 (high ace)
	 * 
	 */
	@Override
	protected int[] EvalHand(ArrayList<Card> cards){
		int[] priority={1,0,0,0,0};
		ArrayList<Card> toSort= new ArrayList<Card>(), toEval;
		toSort.addAll(tableCards);
		toSort.addAll(cards);
		toEval = sortCards(toSort);
		
		checkMultis(toEval);
		if(!oK2.isEmpty()){
			priority[0]+=oK2.size();
			int[] tempArr= new int[oK2.size()];
			int index = 0;
			for (int val : oK2) {
				tempArr[index++]=val;
			}
			priority[3]=getMax(tempArr);
			}
		
		if(!oK3.isEmpty()){
			priority[0]+=(3*oK3.size());
			priority[2] = oK3.get(0);
		}
		
		if(!oK4.isEmpty()){
			priority[0]+=7;
			priority[1] = oK4.get(0);
		}
		
		if(oK2.isEmpty()&&oK3.isEmpty()&&oK4.isEmpty()){
		straight=checkStraight(toEval);
			if(straight){
				priority[0]+=4;
			}
		}
		
		if(priority[0]==5&&(!straight)){
			priority[0]+=2;
		}
		
		flush=checkFlush(toEval);
		if(flush){
			priority[0]+=5;
		}
		
		if(flush&&straight){
			priority[0]-=checkRoyal(toEval)?0:1;
		}
		
		priority[4]=getMax(toEval);
		
		
		for (int i=1;i<=4;i++){
			if(priority[i]==1){
				priority[i]+=13;
			}
		}
		return priority;
	}
	
	/**
	 * Parses a list of Card values and returns the maximum value.
	 * Treats 1 (ace) as highest value
	 *
	 * @param toEval the list of cards
	 * @return the maximum value of the cards parsed.
	 */
	protected int getMax(ArrayList<Card> toEval) {
		int[] intList= {0,0,0,0,0};
		int index = 0;
		for (Card card : toEval) {
		intList[index++]=card.getValue();
		}
		
		
		return getMax(intList);
	}
	
	/**
	 * Gets the max value of the integers passed to it.
	 * Treats 1 (ace) as highest value
	 *
	 * @param toEval the array of integers.
	 * @return the maximum value of parsed integers.
	 */
	protected int getMax(int[] toEval) {
		int max=toEval[0];
		for (int val : toEval) {
			if(val>max||val==1&&max!=1){
				max=val;
			}
		}
		
		
		return max;
	} 
}
