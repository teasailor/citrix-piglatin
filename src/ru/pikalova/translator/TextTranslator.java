package ru.pikalova.translator;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.joining;

import ru.pikalova.translator.functions.TranslateWord;

import java.util.List;

public class TextTranslator {
	private final static List<String> SEPARATORS = asList(" ", "-", "/");

	private TranslateWord translateWord = new TranslateWord();

	public String translate(String input) {
		if (input == null || input.isEmpty()) {
			System.out.println("Nothing to translate: input=[" + input + "]");
			return input;
		}
		return translateByWords(input, 0);
	}

	private String translateByWords(String input, int separatorCount) {
		if (separatorCount < SEPARATORS.size()) {
			String separator = SEPARATORS.get(separatorCount);
			return splitBy(input, separator).stream()
					.map(word -> translateByWords(word, separatorCount + 1))
					.collect(joining(separator));
		}
		return translateWord.apply(input);
	}

	private static List<String> splitBy(String input, String delimiter) {
		return asList(input.split(delimiter));
	}

}
