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
		int offset = 10;
		int pow = 1;
		int temp = 0;
		int result = value - (10*(value/10));
		temp = value-result;
		int current = 0;
		while(temp>=1){
			current = temp -(offset*(temp/offset));
			temp -= current;
			System.out.println(temp);
			result+=(current*(Math.pow(base1, pow)));
			offset*=10;
			pow++;
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
		int val1 = 18;
		int val2 = 121;

//System.out.println(changeBase(1+81*2,10, 9));
System.out.println(""+val1+" in Nonary: "+Nonary.toNonary(val1));
//System.out.println(""+val2+" in Decimal: "+nonaryCalc.toDecimal(val2));
		//System.out.println(""+val1+" + "+val2+" = "+Nonary.add(val1, val2));
	}

}
