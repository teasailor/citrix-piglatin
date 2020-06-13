package ru.pikalova.translator.functions;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.function.Function;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RemainPunctuationUnitTest {
	@Mock
	private Function<String, String> translateWord;

	@InjectMocks
	private RemainPunctuation tested;

	@Captor
	private ArgumentCaptor<String> wordCapture;

	@Before
	public void setUp() {
		doAnswer(invocation -> invocation.getArgumentAt(0, String.class))
				.when(translateWord).apply(wordCapture.capture());
	}

	@After
	public void tearDown() {
		verify(translateWord).apply(anyString());
	}

	@Test
	public void remainApostrophe() {
		String input = "can't";
		assertEquals(input, tested.apply(input));
		assertEquals("cant", wordCapture.getValue());
	}

	@Test
	public void remainPunctuation() {
		String input = "(\"fifty/fifty\")?";
		assertEquals(input, tested.apply(input));
		assertEquals("fiftyfifty", wordCapture.getValue());
	}

	@Test
	public void remainPunctuationFromTheEnd() {
		String input = "de'o'clock,";
		reset(translateWord);
		when(translateWord.apply("deoclock")).thenReturn("deoclocksuffix");

		assertEquals("deoclock's'uffix,", tested.apply(input));
	}

}