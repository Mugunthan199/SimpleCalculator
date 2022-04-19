package com.mugunthco.basicCalcy;

import java.util.stream.Stream;

public class Add {
	
	public static int add(String numbers)
	{
		if(numbers.equals("")||numbers == null)
		{
			return 0;
		}
		else
		{
		String num[] = numbers.split(",");
		int sum = Stream.of(num).mapToInt(Integer::parseInt).sum();
		return sum;
		}
	}

}
