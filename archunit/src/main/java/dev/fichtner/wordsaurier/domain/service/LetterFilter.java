package dev.fichtner.wordsaurier.domain.service;

import java.util.function.Predicate;

import org.apache.commons.lang3.StringUtils;

import dev.fichtner.wordsaurier.domain.model.Word;

public class LetterFilter implements Predicate<Word> {

	private final String letters;

	public LetterFilter(final String letters) {
		super();
		this.letters = letters;
	}

	@Override
	public boolean test(final Word t) {
		return StringUtils.containsOnly(t.getContent(), this.letters);
	}
}
