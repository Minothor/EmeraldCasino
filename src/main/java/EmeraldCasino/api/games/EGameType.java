package emeraldCasino.api.games;

/**
 *Contains the list of possible game types. <br/>Any game type not defined within this list should be labelled as "CUSTOM".
 *<br/>Examples:
 *<ul><li>Poker: CARD</li><li>Roulette: TABLE</li><li>OneArmedBandit: SLOT</li><li>Craps: DICE</li><li>WheelOfFortune: SLOT or CUSTOM depending on implementation</li></ul>
 */
public enum EGameType {
	CARD, TABLE, SLOT, DICE, CUSTOM;
}
