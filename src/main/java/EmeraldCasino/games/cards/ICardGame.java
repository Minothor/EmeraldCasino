package EmeraldCasino.games.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import EmeraldCasino.games.IGame;
import EmeraldCasino.games.cards.core.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;

public interface ICardGame extends IGame {
		
		public void DealCards();
		
		public String toString(ArrayList<Card> cards);
}
