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
	void basicNumbersWithoutDelimitersTest() {
		Assertions.assertEquals(Add.add("1,4"),5);
	}
	@Test
	void unknownAmountOfNumbersAddTest() {
		Assertions.assertEquals(Add.add("1,4,5,7"),17);
	}
	@Test
	void basicNumbersWithNewLineDelimiterTest() {
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
	void basicNumbersWithDifferentDelimitersTest() {
		Assertions.assertEquals(Add.add("//;\n1;2"),3);
	}
}
