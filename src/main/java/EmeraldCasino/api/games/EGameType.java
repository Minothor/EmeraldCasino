package emeraldCasino.api.games;

/**
 * 
 * @author Minothor
 *
 *Contains the list of possible game types, any game type not defined distinctly, should be labelled as "CUSTOM".
 *Examples:
 *<ul><li>Poker: CARD</li><li>Roulette: TABLE</li><li>OneArmedBandit: SLOT</li><li>Craps: DICE</li><li>WheelOfFortune: SLOT or CUSTOM depending on implementation</li></ul>
 */
public enum EGameType {
	CARD, TABLE, SLOT, DICE, CUSTOM;
}
