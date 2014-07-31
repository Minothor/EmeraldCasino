
package emeraldCasino.api.games.card;

//java imports
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;








import cpw.mods.fml.common.registry.GameRegistry;
import emeraldCasino.EmeraldCasino;
//mod imports
import emeraldCasino.api.games.*;
import emeraldCasino.api.games.card.*;
import emeraldCasino.api.games.card.core.*;
import emeraldCasino.api.games.core.IPlayer;
import emeraldCasino.items.IGameInterfaceItem;
import net.minecraft.client.Minecraft;

//Minecraft imports
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;

public abstract class ACardGame extends AGame implements ICardGame{

protected MinecraftServer server = MinecraftServer.getServer();
protected String gameOwner;
protected List<ICard> tableCards = new LinkedList<ICard>();
protected Hand dealerHand = new Hand();
protected List<CardPlayer> players = new LinkedList<CardPlayer>();

private int[] buyIn={0,0};
 
	/**
	 * Default Constructor
	 * 
	 */
	public ACardGame() {
		super();
		this.type=EGameType.CARD;
		this.interfaceItem=(IGameInterfaceItem) GameRegistry.findItem(EmeraldCasino.MODID, "cardHand");
	}
	
	public void DealCards(IDeck deck, List<CardPlayer> players){
		
	}
	
	public int[] EvalHand(List<ICard> cards){
		int[] priority={};
		List toEval=this.sortCards(cards);
		
		return priority;
	}
	
	protected List<ICard> sortCards(List<ICard> toSort){
		Collections.sort(toSort,ACard.compareValue);
		return toSort;
	}
	
	public IPlayer addPlayer(String username){
		EntityPlayer player = server.getConfigurationManager().getPlayerForUsername(username);
		return(new CardPlayer(player));
		
	}
	
	public void removePlayer(String username){
		EntityPlayer player = server.getConfigurationManager().getPlayerForUsername(username);
		//this.players.remove((new Player(player));
	}
	
	@Override
	public void EvalGame() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EntityPlayer getPlayer(String username) {
		return null;
		
	}

	@Override
	public void setOwner(EntityPlayer owner) {
		this.gameOwner = owner.getDisplayName();	
	}
	
	public String toString(ArrayList<ICard> cards){
		String result="";
		for(int j = 0;j<cards.size();j++){
			result+=cards.get(j).toString()+"|";
		}
		return result;
	}
	
	
	@Override
		public IDeck createDeck() {
			return new DeckStandard();
		}
		
	
}
