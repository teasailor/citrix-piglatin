package ru.pikalova.translator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class TranslatorIntegrationTest {

	private TextTranslator tested = new TextTranslator();

	@Test
	public void translateNull() {
		assertNull(tested.translate(null));
	}

	@Test
	public void translateTextWithSpace() {
		assertEquals("ebay appyhay", tested.translate("be happy"));
	}

	@Test
	public void translateTextWithHyphen() {
		assertEquals(" wentytay-ivefay oneway", tested.translate(" twenty-five one"));
	}

	@Test
	public void translateTextWithExtraSpaces() {
		assertEquals(" ebay  appyhay  ", tested.translate(" be  happy  "));
	}

	@Test
	public void translateComplexText() {
		assertEquals("Iway amway wentytay-ivefay alm(ostway) andway rotherbay-inway-awlay ofway away orgetfay-emay-otnay!",
				tested.translate("I am twenty-five (almost) and brother-in-law of a forget-me-not!"));
	}
}