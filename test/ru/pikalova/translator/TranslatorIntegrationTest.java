package ru.pikalova.translator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Ignore;
import org.junit.Test;

public class TranslatorIntegrationTest {

	private TextTranslator tested = new TextTranslator();

	@Test
	public void translateNull() {
		assertNull(tested.translate(null));
	}

	@Test
	public void translateEmpty() {
		assertEquals(tested.translate(""), "");
	}

	@Test
	public void translateTextWithSpace() {
		assertEquals("ebay appyhay", tested.translate("be happy"));
	}

	@Test
	public void translateTextWithExtraSpaces() {
		assertEquals(" ebay   appyhay", tested.translate(" be   happy"));
	}

	@Ignore
	@Test
	public void translateTextEndsWithSeparator() {
		assertEquals("appyhay  ", tested.translate("happy  "));
	}

	@Test
	public void translateTextWithApostrophe() {
		assertEquals("Iwa'y antca'y aitway'", tested.translate("'I can't wait'"));
	}

	@Test
	public void translateTextWithHyphen() {
		assertEquals(" wentytay-ivefay oneway", tested.translate(" twenty-five one"));
	}

	@Test
	public void translateComplexLine() {
		assertEquals("Iway amway wentytay-ivefay alm(ostway) andway rotherbay-inway-awlay ofway away orgetfay-emay-otnay!",
				tested.translate("I am twenty-five (almost) and brother-in-law of a forget-me-not!"));
	}

	@Test
	public void translateComplexText() {
		assertEquals("Iamw'ay\r wentytay-ivefay\n!",
				tested.translate("I'am\r twenty-five\n!"));
	}
}