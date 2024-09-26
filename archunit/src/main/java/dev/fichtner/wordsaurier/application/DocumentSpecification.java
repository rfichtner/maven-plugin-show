package dev.fichtner.wordsaurier.application;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class DocumentSpecification {

	private final int charactersInLine;
	private final int linesInDocument;
	private final String allowedCharacters;

	public DocumentSpecification(final int charactersInLine, final int linesInDocument,
			final String allowedCharacters) {
		super();
		this.charactersInLine = charactersInLine;
		this.linesInDocument = linesInDocument;
		this.allowedCharacters = allowedCharacters;
	}

	public int getCharactersInLine() {
		return this.charactersInLine;
	}

	public int getLinesInDocument() {
		return this.linesInDocument;
	}

	public String getAllowedCharacters() {
		return this.allowedCharacters;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.NO_CLASS_NAME_STYLE)
				.append("charactersInLine", this.charactersInLine).append("linesInDocument", this.linesInDocument)
				.append("allowedCharacters", this.allowedCharacters).build();
	}

}
