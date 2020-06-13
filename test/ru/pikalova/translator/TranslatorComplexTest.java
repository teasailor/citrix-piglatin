package ru.pikalova.translator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class TranslatorComplexTest {

	private TextTranslator tested = new TextTranslator();

	@Test
	public void translateNull() {
		assertNull(tested.translate(null));
	}

	@Test
	public void translateSimplestText() {
		assertEquals("ebay appyhay", tested.translate("be happy"));
	}

	@Test
	public void translateTextWithExtraSpaces() {
		assertEquals(" ebay  appyhay  ", tested.translate(" be  happy  "));
	}

	@Test
	public void translateTextWithHyphen() {
		assertEquals("Iway amway wentytay-ivefay (almostway) andway rotherbay-inway-awlay ofway away orgetfay-emay-otnay!",
				tested.translate("I am twenty-five (almost) and brother-in-law of a forget-me-not!"));
	}
}