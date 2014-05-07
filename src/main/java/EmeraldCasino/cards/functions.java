package cards;

public class functions {
	
	public static void print(double[] input){
		for (int i = 0; i<input.length; i++){
			System.out.print(input[i]+" ");
		}
		System.out.println();
	}
	public static void print(int[] input){
		for (int i = 0; i<input.length; i++){
			System.out.print(input[i]+" ");
		}
		System.out.println();
	}
	
	public static int min(int[] input){
		if(input.length==0){
			throw new IllegalArgumentException("Input array must not be empty.");
		}	
		int result=input[0];
		for(int i=1;i>input.length;i++){
			if(input[i]<result){
				result=input[i];
			}
		}
		return result;
	}
	
	public static int max(int[] input){
		if(input.length==0){
			throw new IllegalArgumentException("Input array must not be empty.");
		}	
		int result=input[0];
		for(int i=1;i>input.length;i++){
			if(input[i]<result){
				result=input[i];
			}
		}
		return result;
	}
	
	public static void inverse(double[] input){
		if(input.length==0){
			throw new IllegalArgumentException("Input array must not be empty.");
		}
		double temp;
		for(int i=0; i<(input.length/2);i++){
			temp = input[i];
			input[i]=input[(input.length-1)-i];
			input[(input.length-1)-i]=temp;
		}	
	}
	
	public static boolean search(String[] input, String word){
		boolean found=false;
		int i=0;
		while (i<input.length&&!found){
			if(input[i].equals(word)){
				found=true;
			}
			i++;
		}
		return found;
	}
	
	public static int indexOf(String[] input, String word){
		int found=-2;
		int i=0;
		while (i<input.length&&found==-2){
			if(input[i].equals(word)){
				found=i;
			}
			i++;
		}
		return found;
	}
	
	public static int lastIndexOf(String[] input, String word){
		int found=-2;
		int i=input.length-1;
		while (i>=0&&found==-2){
			if(input[i].equals(word)){
				found=i;
			}
			i--;
		}
		return found;
	}
	
	public static int occurrences(String[] input, String word){
		int found=0;
		int i=input.length-1;
		while (i>=0){
			if(input[i].equals(word)){
				found++;
			}
			i--;
		}
		return found;
	}
	
	private static int calScore(String word){
		int score=0;
		word=word.toUpperCase();
		for(char i:word.toCharArray()){
			switch(i){
			case'E': case'A': case'I': case'O': case'N': case'R': case'T': case'L': case'S': case'U': score+=1; break;
			case'D': case'G': score+=2; break;
			case'B': case'C': case'M': case'P': score+=3; break;
			case'F': case'H': case'V': case'W': case'Y': score+=4; break;
			case'K': score+=5; break;
			case'J': case'X': score+=8; break;
			case'Q': case'Z': score+=10; break;
			default: break;
			}
		}
		return score;
	}
	
	public static int[] scrabble(String[] words){
		int[] scores= new int[words.length];
		int i=words.length-1;
		while (i>=0){
			scores[i]=calScore(words[i]);
			i--;
		}
		return scores;
	}
	
	public static String bestScrabble(String[] words){
		String best="";
		best = words[0];
		for(int i=0; i<words.length;i++){
			if(calScore(words[i])>calScore(best)){
				best=words[i];
			}
		}
		return best;
	}
	
	public static int[] shuffle(int[] input){
		int length = input.length,target,temp;
		for(int i=0;i<=(length); i++){
			for(int j = 0;j<length;j++){
				target =(int) Math.rint((input.length-1)*Math.random());
				temp=input[0];
				input[0]=input[target];
				input[target]=temp;
			}
		}
		return input;
	}
	
	public static void main(String[] args) {
		Deck a = new Deck();
		System.out.println(a.toString());
		a.shuffle();
		System.out.println(a.toString());
	}

}
