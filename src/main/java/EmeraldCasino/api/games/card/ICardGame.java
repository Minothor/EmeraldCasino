package emeraldCasino.api.games.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import emeraldCasino.api.games.IGame;
import emeraldCasino.api.games.card.core.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;

public interface ICardGame extends IGame {
		public IDeck createDeck();
		
		public void DealCards(IDeck deck, List<CardPlayer> players);
		
		public CardPlayer EvalGame(List<CardPlayer> players);
		
		public EntityPlayer getPlayer(String username);
		
		public String toString(ArrayList<ICard> cards);
}
