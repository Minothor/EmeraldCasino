package emeraldCasino.threadTest;

import java.io.IOException;
import java.nio.CharBuffer;

public class ThreadClass implements Runnable {

	@Override
	public void run() {

		try {
			int x = 10;
			
			while(x>0)
			{
			Thread.sleep(1000);
			System.out.println(x);
			x--;
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}



}
