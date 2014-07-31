package emeraldCasino.games.cards;
import java.util.Collections;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.google.common.collect.HashBiMap;

import emeraldCasino.EmeraldCasino;
import emeraldCasino.api.games.EGameType;
import emeraldCasino.api.games.card.*;
import emeraldCasino.api.games.card.core.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;


/**
 * Basic Poker Implementation, allowing for games of basic 5 card draw.
 * @author Minothor
 * @version 1.0
 */
public class Poker extends ACardGame {

	/**
	 * Instantiates a new poker game class.
	 */
	public Poker() {
		super();
		gameName="5 Card Draw";
	}

	/**
	 * Overridden getID() Function
	 * Prefaces the game ID with the ModID for extra clarity
	 */
	@Override
	public String getID()
	{
		return EmeraldCasino.MODID+"."+"poker.5CardDraw";
	}

	/**
	 * Deals 1 Card to each Player from the game's Deck.
	 */
	@Override
	public void DealCards(IDeck deck, List<CardPlayer> players){
		for (CardPlayer player : players) {
			player.addToHand(deck.takeCard());
		}
	}

	/**
	 * Returns a List of card Values with multiple occurrences numbering 2, 3 or 4 with the values derived from the cards list.
	 * 
	 * Constructs a HashMap with ICard Values as Keys and increments the associated Value to count.
	 *
	 * @param toEval The List of cards to parse.
	 * @return multiVals A list of values occuring multiple times.
	 * */
	protected List[] checkMultis(List<ICard> toEval){
		List[] multiVals = new List[3];
		int cardValue;
		Map<Integer,Integer> cardVals= new HashMap<Integer,Integer>();
		for (ICard card : toEval) {
			cardValue=card.getValue();
			Integer val = cardVals.get(cardValue);
			val = (val==null?0:val);
			cardVals.put(cardValue,1+val);
		}
		System.out.println(cardVals.toString());
		for(Map.Entry<Integer,Integer> entry: cardVals.entrySet()){
			if((int) entry.getValue()==2){
				multiVals[2].add((Integer) entry.getKey());
			}

			if((int) entry.getValue()==3){
				multiVals[1].add((Integer) entry.getKey());
			}

			if((int) entry.getValue()==4){
				multiVals[0].add((Integer) entry.getKey());
			}

		}
		return multiVals;
	}

	/**
	 * Checks if the cards form a consecutive sequence.
	 * Iterates along the List comparing the card values.
	 *
	 * @param cards The list of cards to be evaluated
	 * @return true If it reaches the end of the list and the difference is 1 for a standard Straight or 9 for a Royal Flush
	 */
	protected synchronized boolean checkStraight(List<ICard> cards){
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
	 * Parses the list of cards comparing the house value.
	 *
	 * @param cards The List of cards to Evaluate.
	 * @return true, If successful the difference between tested cards remains 0
	 */
	protected synchronized boolean checkFlush(List<ICard> cards){
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
	 *	Only called if both Straight() and Flush() are true. 
	 *
	 * @param toEval A List of cards to be evaluated.
	 * @return true if the Max card value is 13 and the Min card value is 1
	 */
	protected synchronized boolean checkRoyal(List<ICard> toEval){
		ICard max = Collections.max(toEval, ACard.compareValue);
		ICard min = Collections.min(toEval, ACard.compareValue);
		return (max.getValue()==13)&&(min.getValue()==1);
	}


	/**
	 * EvalHand(List<ICard>)
	 * Evaluates the Hand passed.
	 * 
	 * @param cards
	 * An array of cards to be evaluated according to the basic rules of Poker.
	 * 
	 * @return priority[]
	 * Returns an array of integers.
	 * <ul>
	 * <li>First value is the Hand value, ranging from HighICard:1 to RoyalFlush:10</li>
	 * <li>Second value is the card value of 4 of a Kind, ranging from 2 to 14 (high ace)</li>
	 * <li>Third value is the card value of 3 of a Kind, ranging from 2 to 14 (high ace)</li>
	 * <li>Fourth value is the Highest pair value, ranging from 2 to 14 (high ace)</li>
	 * <li>Fifth value is the highest card value in the deck, ranging from 2 to 14 (high ace)</li>
	 * </ul>
	 * 
	 */
	@Override
	public int[] EvalHand(List<ICard> cards){
		int[] priority={1,0,0,0,0};
		LinkedList<ICard> toSort= new LinkedList<ICard>();
		List<ICard> toEval;
		toSort.addAll(tableCards);
		toSort.addAll(cards);
		toEval = sortCards(toSort);

		List<Integer>[] multiVals = checkMultis(toEval);
		if(!multiVals[0].isEmpty()){
			priority[0]+=multiVals[0].size();
			int[] tempArr= new int[multiVals[0].size()];
			int index = 0;
			for (int val : multiVals[0]) {
				tempArr[index++]=val;
			}
			priority[3]=getMax(tempArr);
		}

		if(!multiVals[1].isEmpty()){
			priority[0]+=(3*multiVals[1].size());
			priority[2] = multiVals[1].get(0);
		}

		if(!multiVals[2].isEmpty()){
			priority[0]+=7;
			priority[1] = multiVals[2].get(0);
		}

		if(multiVals[0].isEmpty()&&multiVals[1].isEmpty()&&multiVals[2].isEmpty()){
			if(checkStraight(toEval))
				priority[0]+=4;
		}

		if(priority[0]==5&&(!checkStraight(toEval)))
			priority[0]+=2;

		if(checkFlush(toEval))
			priority[0]+=5;

		if(checkFlush(toEval)&&checkStraight(toEval))
			priority[0]-=checkRoyal(toEval)?0:1;

		priority[4]=getMax(toEval);


		for (int i=1;i<=4;i++){
			if(priority[i]==1){
				priority[i]+=13;
			}
		}
		return priority;
	}

	/**
	 * Parses a list of ICard values and returns the maximum value.
	 * Treats 1 (ace) as highest value
	 *
	 * @param toEval the list of cards
	 * @return the maximum value of the cards parsed.
	 */
	protected synchronized int getMax(List<ICard> toEval) {
		int[] intList= new int[toEval.size()];
		int index = 0;
		for (ICard card : toEval) {
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
	protected synchronized int getMax(int[] toEval) {
		int max=toEval[0];
		for (int val : toEval) {
			if(val>max||val==1&&max!=1){
				max=val;
			}
		}


		return max;
	}

	@Override
	public synchronized CardPlayer EvalGame(List<CardPlayer> players) {
		HashBiMap <CardPlayer, int[]> roundResults = HashBiMap.create(new HashMap<CardPlayer, int[]>());
		for (CardPlayer cardPlayer : players) {
			roundResults.put(cardPlayer, EvalHand(cardPlayer.getHand()));
		}
		//		Collections.sort(roundResults.);


		CardPlayer winner;
		winner= players.get(0);
		for (int i=1; i<players.size(); i++) {


		}
		return winner;
	}
}
