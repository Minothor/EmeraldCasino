package EmeraldCasino.games.cards;

import net.minecraft.entity.player.EntityPlayer;

public class testing {
	public static void main(String[] args) {
		Deck a = new Deck();
		//System.out.println(a.toString());
		Poker g = new Poker();
		Hand b = new Hand();
		a.shuffle();
		b.addCard(a.takeCard());
		b.addCard(a.takeCard());
		b.addCard(a.takeCard());
		b.addCard(a.takeCard());
		b.addCard(a.takeCard());
		b.play(g);
		//g.addPlayer("Minothor");
		//b.play(g);
		System.out.println("******************************************");
	}
}
