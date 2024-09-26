package dev.fichtner.wordsaurier.domain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import dev.fichtner.wordsaurier.domain.support.ValueObject;

public class Document implements ValueObject<Document> {

	private static final long serialVersionUID = -4240507790324894045L;

	public static Document of(final List<Line> lines) {
		Objects.requireNonNull(lines);
		return new Document(lines);
	}

	private final List<Line> lines;

	private Document(final List<Line> lines) {
		super();
		Objects.requireNonNull(lines);
		this.lines = new ArrayList<>(lines);
	}

	public String getContent() {
		return this.lines.stream().map(line -> line.getContent()).collect(Collectors.joining("\r\n"));
	}

	@Override
	public boolean sameValueAs(final Document other) {
		// TODO Auto-generated method stub
		return false;
	}

}
