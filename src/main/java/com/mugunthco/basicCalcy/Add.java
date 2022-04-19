package com.mugunthco.basicCalcy;

import java.util.stream.Stream;
import java.util.regex.*;;

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
		String num[] = splitFunction(numbers);
		int sum = Stream.of(num).mapToInt(Integer::parseInt).sum();
		return sum;
		}
		return 0;
	}

	private static String[] splitFunction(String numbers) {
		if(numbers.startsWith("//"))
		{
			Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(numbers);
			if(matcher.matches())
			{
				String delimiter = matcher.group(1);
				String split = matcher.group(2);
				return split.split(delimiter);
			}
			throw new RuntimeException("Wrong delimiter passed");
		}
		return numbers.split(",|\n");
	}
}
