package ru.pikalova.translator.function;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.verify;

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
public class RemainCapitalizationUnitTest {

	@Mock
	private Function<String, String> translateWord;

	@InjectMocks
	private RemainCapitalization tested;

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
	public void remainInTheBeginning() {
		String input = "Beach";
		assertEquals(input, tested.apply(input));
		assertEquals("beach", wordCapture.getValue());
	}

	@Test
	public void remainInTheEnd() {
		String input = "beacH";
		assertEquals(input, tested.apply(input));
		assertEquals("beach", wordCapture.getValue());
	}

}