package EmeraldCasino.games;

public interface IGame {
	public void addPlayer(String username);
	public void getPlayer(String username);	
	public void removePlayer(String username);
	public void EvalGame();
	public String getName();
}
