package ru.pikalova.translator.functions;

import java.util.function.Function;

public class TranslateWord implements Function<String, String> {

	@Override
	public String apply(String word) {
		if (word == null || word.isEmpty()) {
			return word;
		}
		Function<String, String> convertToLowercase = ((String letters) -> letters.toLowerCase());
		return new RemainPunctuation(new RemainCapitalization(convertToLowercase.andThen(new TranslateLowercaseLetters()))).apply(word);
	}
}
