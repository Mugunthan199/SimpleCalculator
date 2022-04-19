package com.mugunthco.basicCalculatorTests;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.mugunthco.basicCalcy.Add;

class BasicCalculatorTest {
	
	@Test
	void emptyInputTest() {
		Assertions.assertEquals(Add.add(""),0);
	}
	@Test
	void OneNumberInputTest() {
		Assertions.assertEquals(Add.add("7"),7);
	}
	@Test
	void basicCalculatorWithCommaDelimiterTest() {
		Assertions.assertEquals(Add.add("1,4"),5);
	}
	@Test
	void unknownAmountOfNumbersAddTest() {
		Assertions.assertEquals(Add.add("1,4,5,7"),17);
	}
	@Test
	void basicCalculatorWithNewLineDelimiterTest() {
		Assertions.assertEquals(Add.add("1,4,5\n7"),17);
	}
	@Test
	void basicTwoNumbersWithNewLineDelimiterAfterCommaTest() {
		boolean thrown = false;
		try
		{
		Assertions.assertEquals(Add.add("1,4,5,\n7"),17);
		}
		catch(NumberFormatException e)
		{
			thrown = true;
		}
		assertTrue(thrown);
	}
	@Test
	void basicCalculatorWithDifferentDelimitersTest() {
		Assertions.assertEquals(Add.add("//;\n1;2"),3);
	}
	@Test
	void basicCalculatorWithNegativeNumbersTest() {
		boolean isNegativePresent = false;
		try
		{
		Assertions.assertEquals(Add.add("1,-2,4,-6"),17);
		}
		catch(RuntimeException e)
		{
			if(e.getMessage().contains("negatives not allowed") && e.getMessage().contains("-2 -6"))
			{
				isNegativePresent = true;
			}
			else
			{
				isNegativePresent = false;
			}
		}
		assertTrue(isNegativePresent);
	}
}
