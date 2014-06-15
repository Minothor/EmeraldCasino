package EmeraldCasino.games.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;

public interface ICardGame {
		
		public void DealCards();
		
		public void EvalGame();
		
		public void addPlayer(String username);
		
		public void removePlayer(String username);
		
		public String toString(ArrayList<Card> cards);
}
