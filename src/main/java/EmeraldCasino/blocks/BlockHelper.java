package emeraldCasino.blocks;

public class BlockHelper {
	private BlockHelper() {
	}
	
	
	public static int[] getPlacementTarget(int x, int y, int z, int side) {
		int[] target = {0,0,0};
		int dir;
		
		switch(side%2)
		{
		case 0: dir=-1; break;
		case 1: dir=1; break;
		default: dir=1;
		}
		
		switch(side/2)
		{
		case 0: target[1]=dir; break;
		case 1: target[2]=dir; break;
		case 2: target[0]=dir; break;
		}
		
		target[0]+=x;
		target[1]+=y;
		target[2]+=z;
		
		return target;
	}
	
}
