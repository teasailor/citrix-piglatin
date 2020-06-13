package ru.pikalova.translator.functions;

import java.util.function.Function;

class RemainCapitalization implements Function<String, String> {
	private final Function<String, String> translateLiterals;

	RemainCapitalization(Function<String, String> translateLiterals) {
		this.translateLiterals = translateLiterals;
	}

	@Override
	public String apply(String s) {
		return translateLiterals.apply(s);
	}
}
