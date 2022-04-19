package com.mugunthco.basicCalcy;

import java.util.stream.Stream;

/**
 * This class is used for String addition basic calculator
 * @author Uma Ganesan
 *
 */
public class Add {
	
	/**
	 * This method returns addition of n number of values passed as String
	 * @param numbers
	 * @return
	 */
	public static int add(String numbers)
	{
		if(!numbers.isEmpty())
		{
		String num[] = numbers.split(",|\n");
		int sum = Stream.of(num).mapToInt(Integer::parseInt).sum();
		return sum;
		}
		return 0;
	}
}
