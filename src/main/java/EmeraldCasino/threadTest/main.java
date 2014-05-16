package EmeraldCasino.threadTest;

public class main 
{

	public static void main(String[] args) 
	{
		Runnable t = new ThreadClass();
		new Thread(t).start();
		new Thread(t).start();
	}
}
