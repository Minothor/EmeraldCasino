package emeraldCasino.financial;
/**
 * Base-9 calculations library for working with values based off gold and emerald items.
 * @author Minothor
 * @version 1.0
 */
public final class Nonary {

	private Nonary() {}

	private static int changeBase (int value, int base1, int base2){
		/*
		 * Credit for this simple function goes to http://professorjava.weebly.com/
		 * for their easy to follow base conversion calculator.
		 */
		int intermediary = Integer.parseInt(""+value, base1);
		int result = Integer.valueOf(Integer.toString(intermediary, base2));
		return result;
	}
	
	/**
	 * converts a Decimal integer into it's equivalent Nonary form.
	 * @param decimal Integer to convert.
	 * @return returns the Nonary equivalent.
	 */
	public static int toNonary(int decimal){
		return changeBase(decimal, 10, 9);
	}
	
	/**
	 * converts a Nonary integer into it's equivalent Decimal form.
	 * @param nonary Integer to convert.
	 * @return the Decimal equivalent.
	 */
	public static int toDecimal(int nonary){
		return changeBase(nonary, 9, 10);
	}
	
	/**
	 * Adds the second value to the first.
	 * (done since operand overloading isn't possible in Java)
	 * @param value1 Nonary integer.
	 * @param value2 Nonary integer.
	 * @return Integer sum of inputs.
	 */
	public static int add(int value1, int value2){
		int result =  toDecimal(value1)+toDecimal(value2);
		return toNonary(result);
	}
	
	/**
	 * Substracts the second value from the first.
	 * (done since operand overloading isn't possible in Java)
	 * @param value1 Nonary integer.
	 * @param value2 Nonary integer.
	 * @return Integer result of subtraction.
	 */
	public static int subtract(int value1, int value2){
		int result =  toDecimal(value1)-toDecimal(value2);
		return toNonary(result);
	}
	
	/**
	 * Multiplies first value by the second.
	 * (done since operand overloading isn't possible in Java)
	 * @param value1 Nonary integer.
	 * @param value2 Nonary integer.
	 * @return Integer product of multiplication.
	 */
	public static int multiply(int value1, int value2){
		int result = toDecimal(value1)*toDecimal(value2);
		return toNonary(result);
	}
	
	/**
	 * Divides first value by the second.
	 * (done since operand overloading isn't possible in Java)
	 * @param value1 Nonary integer.
	 * @param value2 Nonary integer.
	 * @return Integer result of division.
	 */
	public static int divide(int value1, int value2){
		int result = toDecimal(value1)/toDecimal(value2);
		return toNonary(result);
	}
	
	/**
	 * Remainder of dividing the first value by the second.
	 * (done since operand overloading isn't possible in Java)
	 * @param value1 Nonary integer.
	 * @param value2 Nonary integer.
	 * @return Integer result of modulo.
	 */
	public static int modulo(int value1, int value2){
		int result = toDecimal(value1)%toDecimal(value2);
		return toNonary(result);
	}
}
