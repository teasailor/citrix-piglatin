package ru.pikalova.translator.functions;

import static java.lang.Character.toUpperCase;
import static java.lang.String.valueOf;
import static java.util.regex.Pattern.compile;

import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class RemainCapitalization implements Function<String, String> {
	private final static Pattern CAPITAL_LETTER_PATTERN = compile("\\p{Upper}");

	private final Function<String, String> translateLetters;

	RemainCapitalization(Function<String, String> translateLetters) {
		this.translateLetters = translateLetters;
	}

	@Override
	public String apply(String word) {
		String translatedLetters = translateLetters.apply(word.toLowerCase());
		return remainCapitalization(translatedLetters, CAPITAL_LETTER_PATTERN.matcher(word));
	}

	private String remainCapitalization(String word, Matcher matcher) {
		StringBuilder builder = new StringBuilder(word);
		while (matcher.find()) {
			String bigLetter = valueOf(word.charAt(matcher.start())).toUpperCase();
			builder.replace(matcher.start(), matcher.end(), bigLetter);
		}
		return builder.toString();
	}
}
