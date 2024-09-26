package dev.fichtner.wordsaurier.domain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Line {

	final List<Word> words = new ArrayList<>();

	public static Line of(final int characterCount, final List<Word> words) {

		// TODO do some exception if we run out of words
		int tryCounter = 0;
		Optional<Line> lineResult = Optional.empty();
		while (!lineResult.isPresent() && tryCounter < 20) {
			lineResult = tryToBuild(characterCount, words);
			tryCounter++;
		}
		return lineResult.get();

	}

	private static Optional<Line> tryToBuild(final int characterCount, final List<Word> words) {
		int currentCharacterCount = 0;
		int remainingCharactersForWord = characterCount;
		final Line line = new Line();

		while (characterCount != currentCharacterCount) {
			final int remainingCharactersForWord1 = remainingCharactersForWord;
			final Optional<Word> wordResult = words.stream().filter(w -> w.lenght() <= remainingCharactersForWord1)
					.findFirst();

			if (wordResult.isPresent()) {
				final Word word = wordResult.get();
				line.addWord(word);

				// move word to end of list
				words.remove(word);
				words.add(word);
				currentCharacterCount = line.length();
				remainingCharactersForWord = characterCount - currentCharacterCount - 1;
			} else {
				// no more words
				return Optional.empty();
			}

		}

		return Optional.of(line);
	}

	public void addWord(final Word word) {
		this.words.add(word);
	}

	public int length() {
		int length = 0;

		for (final Word word : this.words) {
			length = length + word.lenght();
		}
		// add spaces
		length = length + this.words.size() - 1;

		return length;
	}

	public String getContent() {
		return this.words.stream().map(word -> word.getContent()).collect(Collectors.joining(" "));
	}

}
