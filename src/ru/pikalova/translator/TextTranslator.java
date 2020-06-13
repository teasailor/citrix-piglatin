package ru.pikalova.translator;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.joining;

import java.util.List;

import ru.pikalova.translator.functions.TranslateWord;

public class TextTranslator {

	private TranslateWord translateWord = new TranslateWord();

	public String translate(String input) {
		if (input == null || input.isEmpty()) {
			System.out.println("Nothing to translate: input=[" + input + "]");
			return input;
		}
		final String space = " ";
		final String hyphen = "-";
		//TODO: reflection? and use separator '/'
		return splitBy(input, space).stream()
				.map(s -> splitBy(s, hyphen).stream()
						.map(translateWord)
						.collect(joining(hyphen)))
				.collect(joining(space));
	}

	private static List<String> splitBy(String input, String delimiter) {
		return asList(input.split(delimiter));
	}

}
