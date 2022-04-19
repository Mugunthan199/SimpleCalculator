package com.mugunthco.basicCalcy;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Arrays;
import java.util.List;
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
		checkNegatives(num);
		int sum = Stream.of(num).mapToInt(Integer::parseInt).sum();
		return sum;
		}
		return 0;
	}

	/**
	 * This method check for negative numbers in the array
	 * @param num
	 */
	private static void checkNegatives(String[] num) {
		List<Integer> intNumberList = Arrays.stream(num).map(Integer::parseInt).collect(Collectors.toList());
		StringBuilder builder = new StringBuilder();
		intNumberList.stream().filter(n->n<0).forEach(n->builder.append(n).append(" "));
		if(!builder.toString().isEmpty())
		{
			throw new RuntimeException("negatives not allowed "+builder.toString());
		}
	}
	/**
	 * This method splits the numbers based on the delimiters provided
	 * @param numbers
	 * @return
	 */
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
