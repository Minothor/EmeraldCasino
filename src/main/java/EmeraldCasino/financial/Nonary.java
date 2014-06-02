package EmeraldCasino.financial;

/**
 * Base-9 calculations library for working with values based off gold and emerald items.
 * @author Minothor
 * @version 1.0
 */
public class Nonary {

	private Nonary() {}


	private static int baseToBase(int value,int base2)
	{
//Ahmed's Solution
		String string = "";
		int x = value;
		while(x>=base2)
		{
			string = (x%base2) + string;
			System.out.println(string);
			System.out.println(x);
			x /=base2;	
		}
		string = (x) + string;
		return Integer.valueOf(string);
	}


	private static int changeBase (int value, int base1, int base2){
		int x =0, offset=10, result=0;
		System.out.println("changing value "+value+" from base"+base1+" into base"+base2);
//System.out.println(x);
		x=value%base1;
		while(value>=(base1-1)){
			value/=base1;
			x+=(offset*(value%base1));
			offset*=10;
			System.out.println("after division by "+base1+" : "+x);

		}
		offset=10;
		System.out.println(x);
		result=x%base2;
		while(x>=(base2-1)){
			x/=base2;
			System.out.println("offset : "+offset);
			result+=(offset*(x%base2));
			offset*=10;

		}
		return result;
	}







	public static int toNonary(int decimal){
		return changeBase(decimal, 10, 9);
	}

	public static int toDecimal(int nonary){
		return changeBase(nonary, 9, 10);
	}

	public static int add(int value1, int value2){
		int result = 0;
		int offset = 1;
		int temp = 0;
		while(value1>=1||value2>=1){
			temp = 10*((value1%10)+(value2%10));
			result+= (offset*(temp/9));
			value1/=10;
			value2/=10;
			offset*=10;
		}
		return result;
	}

	public static int multiply(int value1, int value2){
		int result = toDecimal(value1)*toDecimal(value2);
		return toNonary(result);
	}

	public static void main(String[] args) {
		int val1 = 34888;
		int val2 = 121;

//System.out.println(changeBase(1+81*2,10, 9));
//System.out.println(""+val1+" in Nonary: "+nonaryCalc.toNonary(val1));
//System.out.println(""+val2+" in Decimal: "+nonaryCalc.toDecimal(val2));
		System.out.println(""+val1+" + "+val2+" = "+Nonary.add(val1, val2));
	}

}
