package EmeraldCasino.cards;

import net.minecraft.entity.player.EntityPlayer;

public class testing {
	public static void main(String[] args) {
		Deck a = new Deck();
		//System.out.println(a.toString());
		Poker g = new Poker();
		Hand b = new Hand();
		//b.takeCard(a);
		/*b.cards.add(new Card(2,13));
		b.cards.add(new Card(1,10));
		b.cards.add(new Card(2,10));
		b.cards.add(new Card(3,10));
		b.cards.add(new Card(4,13));*/
		g.addPlayer("Minothor");
		b.play(g);
		System.out.println("******************************************");
	}
}
