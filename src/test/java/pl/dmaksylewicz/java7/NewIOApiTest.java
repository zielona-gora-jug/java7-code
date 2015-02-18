package pl.dmaksylewicz.java7;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class NewIOApiTest {

	private static final String TEST_FILE_PATH = "./src/main/resources/test2.txt";

	private static NewIOApi NEW_API;

	@BeforeClass
	public static void setUp() throws IOException {
		Files.deleteIfExists(FileSystems.getDefault().getPath(TEST_FILE_PATH));
		Path path = Files.createFile(FileSystems.getDefault().getPath(TEST_FILE_PATH));
		NEW_API = new NewIOApi(path);
	}

	@Test
	public void test_existenceOfFileInPath() throws Exception {
		assertTrue(NEW_API.isExist());
	}

	@Test
	public void test_ifNamesAppendedToFileProperly() throws Exception {
		List<String> expectedNames = Arrays.asList("Tytus", "Romek", "Atomek");
		List<String> result = NEW_API.appendNames();
		assertEquals(expectedNames, result);
	}

	@Test
	public void test_checkIfRegularFileInPath() throws Exception {
		BasicFileAttributes attr = NEW_API.getAttributes();
		assertTrue(attr.isRegularFile());
		// notice new class FileTime ! what to do here with the file time, any
		// ideas ?
	}

	@AfterClass
	public static void tearDown() throws IOException {
		Files.deleteIfExists(FileSystems.getDefault().getPath(TEST_FILE_PATH));
	}
}
