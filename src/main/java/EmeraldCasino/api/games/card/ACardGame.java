
package emeraldCasino.api.games.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import emeraldCasino.api.games.*;
import emeraldCasino.api.games.card.*;
import emeraldCasino.api.games.card.core.*;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;

public abstract class ACardGame extends AGame implements ICardGame{

protected static MinecraftServer server = MinecraftServer.getServer();
 protected List<Card> tableCards = new LinkedList<Card>();
 protected Hand dealerHand = new Hand();
 protected List<Player> players = new LinkedList<Player>();
 protected IDeck deck;
 private int[] buyIn={0,0};
 
	/**
	 * Default Constructor
	 * 
	 */
	public ACardGame() {
		super();
	}
	
	public void DealCards(){
		
	}
	
	public int[] EvalHand(List<Card> cards){
		int[] priority={};
		List toEval=this.sortCards(cards);
		
		return priority;
	}
	
	protected List<Card> sortCards(List<Card> toSort){
		Collections.sort(toSort,Card.compareValue);
		return toSort;
	}
	
	public void addPlayer(String username){
		EntityPlayer player = server.getConfigurationManager().getPlayerForUsername(username);
		this.players.add(new Player(player));
	}
	
	public void removePlayer(String username){
		EntityPlayer player = server.getConfigurationManager().getPlayerForUsername(username);
		//this.players.remove((new Player(player));
	}
	
	public String toString(ArrayList<Card> cards){
		String result="";
		for(int j = 0;j<cards.size();j++){
			result+=cards.get(j).toString()+"|";
		}
		return result;
	}
	
	@Override
		public String getDeckTex() {
			return deck.getTexture();
		}
	
}
