package ru.pikalova.translator.function;

import static java.util.regex.Pattern.compile;

import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class RemainPunctuation implements Function<String, String> {
	private final static Pattern PUNCTUATION_PATTERN = compile("\\W");

	private final Function<String, String> translateLetters;

	RemainPunctuation(Function<String, String> translateLetters) {
		this.translateLetters = translateLetters;
	}

	@Override
	public String apply(String word) {
		String translatedLetters = translateLetters.apply(PUNCTUATION_PATTERN.matcher(word).replaceAll(""));
		return remainPunctuationToIndexFromEnd(word, translatedLetters);
	}

	private String remainPunctuationToIndexFromEnd(String word, String translatedLetters) {
		Matcher matcher = PUNCTUATION_PATTERN.matcher(new StringBuilder(word).reverse().toString());
		StringBuilder builder = new StringBuilder(translatedLetters).reverse();
		while (matcher.find()) {
			builder.insert(matcher.start(), matcher.group());
		}
		return builder.reverse().toString();
	}
}
