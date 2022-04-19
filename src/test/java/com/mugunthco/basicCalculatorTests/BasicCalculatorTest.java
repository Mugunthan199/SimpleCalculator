package com.mugunthco.basicCalculatorTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.mugunthco.basicCalcy.Add;

class BasicCalculatorTest {
	
	@Test
	void emptyInputTest() {
		Assertions.assertEquals(Add.add(""),0);
	}
	@Test
	void basicNumbersWithoutDelimitersTest() {
		Assertions.assertEquals(Add.add("1,4"),5);
	}
	@Test
	void unknownAmountOfNumbersAddTest() {
		Assertions.assertEquals(Add.add("1,4,5,7"),17);
	}
}
