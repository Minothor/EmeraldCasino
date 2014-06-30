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
		
		public void DealCards();
		
		public String toString(ArrayList<Card> cards);
		
		public String getDeckTex();
}
