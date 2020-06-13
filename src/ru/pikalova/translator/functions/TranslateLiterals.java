package ru.pikalova.translator.functions;

import static java.util.Arrays.asList;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

class TranslateLiterals implements Function<String, String> {
	private static final String DEFAULT_SUFFIX = "way";
	private static final String CONSONANT_SUFFIX = "ay";
	private static final Set<Character> VOWELS = new HashSet<>(asList('a', 'e', 'i', 'o', 'u'));

	@Override
	public String apply(String word) {
		if (word.endsWith(DEFAULT_SUFFIX)) {
			return word;
		}
		char firstChar = word.charAt(0);
		if (VOWELS.contains(firstChar)) {
			return word + DEFAULT_SUFFIX;
		} else {
			return new StringBuilder(word)
					.deleteCharAt(0)
					.append(firstChar)
					.append(CONSONANT_SUFFIX)
					.toString();
		}
	}
}
