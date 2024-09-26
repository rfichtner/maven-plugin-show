package dev.fichtner.wordsaurier.domain.model;

import java.util.Objects;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Word {

	private final String content;

	public Word(final String content) {
		super();
		Objects.requireNonNull(content);
		this.content = content;
	}

	public String getContent() {
		return this.content;
	}

	public int lenght() {
		return this.content.length();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append(this.content).build();
	}

}
