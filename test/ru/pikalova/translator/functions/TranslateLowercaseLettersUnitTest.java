package ru.pikalova.translator.functions;

import static org.junit.Assert.*;

import org.junit.Test;

public class TranslateLowercaseLettersUnitTest {

	private TranslateLowercaseLetters tested = new TranslateLowercaseLetters();

	@Test
	public void translateEmptyWord() {
		assertEquals("", tested.apply(""));
	}

	@Test
	public void translateConsonantWord() {
		assertEquals("ellohay", tested.apply("hello"));
	}

	@Test
	public void translateVowelWord() {
		assertEquals("appleway", tested.apply("apple"));
	}

	@Test
	public void translateWordEndsWay() {
		String input = "stairway";
		assertEquals(input, tested.apply(input));
	}
}