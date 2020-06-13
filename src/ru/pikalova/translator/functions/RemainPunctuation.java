package ru.pikalova.translator.functions;

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
		Matcher matcher = PUNCTUATION_PATTERN.matcher(word);
		String reversedWord = new StringBuilder(translateLetters.apply(matcher.replaceAll(""))).reverse().toString();
		matcher.reset();
		while (matcher.find()) {
			reversedWord = new StringBuilder(reversedWord).insert(word.length() - matcher.end(), matcher.group()).toString();
		}
		return new StringBuilder(reversedWord).reverse().toString();
	}
}
