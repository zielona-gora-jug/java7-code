package pl.dmaksylewicz.java7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.List;

public class NewIOApi {

	private final Path path;

	public NewIOApi(Path path) {
		super();
		this.path = path;
	}

	public boolean isExist() {
		return Files.exists(this.path);
	}

	public List<String> appendNames() throws IOException {
		List<String> names = Arrays.asList("Tytus", "Romek", "Atomek");
		return Files.readAllLines(Files.write(path, names, StandardOpenOption.APPEND));
	}

	public BasicFileAttributes getAttributes() throws IOException {
		// returned attributes can be:
		// BasicFileAttributes.class
		// DosFileAttributes.class
		// PosixFileAttributes.class
		return Files.readAttributes(this.path, BasicFileAttributes.class);
	}
}
