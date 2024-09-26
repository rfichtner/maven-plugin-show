package dev.fichtner.wordsaurier;

import java.io.IOException;

import dev.fichtner.wordsaurier.interfaces.cli.CliUserInterface;

public class Application {

	public static void main(final String[] args) throws IOException {
		final CliUserInterface cliUserInterface = new CliUserInterface(args);
		cliUserInterface.compute();
	}
}
