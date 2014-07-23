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
		
		public void DealCards(IDeck deck, List<CardPlayer> players);
		
		void EvalGame(List<CardPlayer> players);
		
		EntityPlayer getPlayer(String username);

		void setOwner(EntityPlayer owner);
		
		public String toString(ArrayList<ICard> cards);
		
		public String getDeckTex();
}
