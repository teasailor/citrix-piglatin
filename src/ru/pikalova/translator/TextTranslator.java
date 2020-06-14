package ru.pikalova.translator;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.joining;

import java.util.Iterator;
import java.util.List;

import ru.pikalova.translator.functions.TranslateWord;

public class TextTranslator {
	private final static List<String> SEPARATORS = asList(" ", "-", "/");

	private TranslateWord translateWord = new TranslateWord();

	public String translate(String input) {
		if (input == null || input.isEmpty()) {
			System.out.println("Nothing to translate: input=[" + input + "]");
			return input;
		}

		return translateByWords(input, SEPARATORS.iterator());
		//		final String space = " ";
		//		final String hyphen = "-";
		//		return splitBy(input, space).stream()
		//				.map(s -> splitBy(s, hyphen).stream()
		//						.map(w -> splitBy(w, "/").stream()
		//								.map(translateWord)
		//								.collect(joining("/")))
		//						.collect(joining(hyphen)))
		//				.collect(joining(space));
	}

	private String translateByWords(String input, Iterator<String> iterator) {
		if (iterator.hasNext()) {
			String separator = iterator.next();
			return splitBy(input, separator).stream()
					.map(word -> translateByWords(word, iterator))
					.collect(joining(separator));
		}
		return translateWord.apply(input);
	}

	private static List<String> splitBy(String input, String delimiter) {
		return asList(input.split(delimiter));
	}

}
