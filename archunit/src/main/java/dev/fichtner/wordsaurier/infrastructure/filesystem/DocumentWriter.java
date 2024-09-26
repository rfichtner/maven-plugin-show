package dev.fichtner.wordsaurier.infrastructure.filesystem;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dev.fichtner.wordsaurier.application.DocumentSpecification;
import dev.fichtner.wordsaurier.domain.model.Document;

public class DocumentWriter {

	private static final Logger LOG = LoggerFactory.getLogger(DocumentWriter.class);

	private final Document document;
	private final DocumentSpecification documentSpecification;

	public DocumentWriter(final Document document, final DocumentSpecification documentSpecification) {
		super();
		this.document = document;
		this.documentSpecification = documentSpecification;
	}

	public void write() throws IOException {

		// create a temporary file
		final String timeLog = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
		final File file = new File("wordsaurier-document-" + timeLog + ".txt");

		try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8)) {

			writer.write("Wordsaurier document\r\n");
			writer.write(this.documentSpecification.toString() + "\r\n");
			writer.write("---------------------\r\n");
			writer.write(this.document.getContent());
			LOG.info("document was written to {}", file.getCanonicalPath());

		} catch (final IOException e) {
			throw e;
		}
	}

}
