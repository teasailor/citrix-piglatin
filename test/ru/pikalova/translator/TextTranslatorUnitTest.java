package ru.pikalova.translator;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.verify;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import ru.pikalova.translator.function.TranslateWord;

@RunWith(MockitoJUnitRunner.class)
public class TextTranslatorUnitTest {
	@Mock
	private TranslateWord translateWord;

	@InjectMocks
	private TextTranslator tested;

	@Before
	public void setUp() {
		doAnswer(invocation -> invocation.getArgumentAt(0, String.class))
				.when(translateWord).apply(anyString());
	}

	@After
	public void tearDown() {
		verify(translateWord, atLeastOnce()).apply(anyString());
	}

	@Test
	public void splitTextBySpace() {
		String input = "be happy";
		assertEquals(input, tested.translate(input));
	}

	@Test
	public void splitTextByExtraSpaces() {
		String input = "  be   happy";
		assertEquals(input, tested.translate(input));
	}

	@Test
	public void splitTextByHyphen() {
		String input = "stick-in-the-mud";
		assertEquals(input, tested.translate(input));
	}

	@Test
	public void splitTextByExtraHyphen() {
		String input = "stick--in-the---mud";
		assertEquals(input, tested.translate(input));
	}

	@Test
	public void splitTextWithSpacesAndHyphens() {
		String input = "ong-term two-way stick-in-the-mud";
		assertEquals(input, tested.translate(input));
	}
}