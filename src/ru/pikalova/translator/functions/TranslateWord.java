package ru.pikalova.translator.functions;

import java.util.function.Function;

public class TranslateWord implements Function<String, String> {

	@Override
	public String apply(String world) {
		if (world == null || world.isEmpty()) {
			return world;
		}
		Function<String, String> convertToLowerCase = ((String letters) -> letters.toLowerCase());
		return new RemainPunctuation(new RemainCapitalization(convertToLowerCase.andThen(new TranslateLetters()))).apply(world);
	}
}
