package au.com.workingmouse.challenge.services;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileServiceTest {
	public static final String TEST_FILE_NAME_ONE = "testFile.csv";

	public static final String TEST_FILE_NAME_TWO = "testFileTwo.csv";

	public static final String TEST_FILE_NAME_EMPTY = "testEmpty.csv";


	@BeforeEach
	void setUp() throws IOException {
		// Create some test files to read
		writeToFile(TEST_FILE_NAME_ONE, Arrays.asList(
				"This,is,an,example,csv",
				"This,is,an,example,csv",
				"This,is,an,example,csv",
				"This,is,an,example,csv"));

		writeToFile(TEST_FILE_NAME_TWO, Arrays.asList("single,line,file"));

		writeToFile(TEST_FILE_NAME_EMPTY, Arrays.asList(""));
	}

	@AfterAll
	static void tearDown() {
		var outputFiles = Arrays.asList(
				new File(TEST_FILE_NAME_ONE),
				new File(TEST_FILE_NAME_TWO),
				new File(TEST_FILE_NAME_EMPTY)
		);

		for (File outputFile : outputFiles) {
			outputFile.delete();
		}
	}

	private void writeToFile(String fileName, List<String> contents) throws IOException {
		Path file = Paths.get(fileName);
		Files.write(file, contents, Charset.forName("UTF-8"));
	}

	@Test
	void readLinesEmpty() throws IOException {
		File file = new File(TEST_FILE_NAME_EMPTY);
		List<String> lines = FileService.readLines(file);

		assertEquals(1, lines.size());
		assertEquals("", lines.get(0));
	}

	@Test
	void readLinesMultiLine() throws IOException {
		File file = new File(TEST_FILE_NAME_ONE);
		List<String> lines = FileService.readLines(file);

		assertEquals(4, lines.size());
		assertEquals("This,is,an,example,csv", lines.get(0));
	}

	@Test
	void readLinesSingle() throws IOException {
		File file = new File(TEST_FILE_NAME_TWO);
		List<String> lines = FileService.readLines(file);

		assertEquals(1, lines.size());
		assertEquals("single,line,file", lines.get(0));
	}

	@Test
	void readLinesNonExistantFile() {
		File file = new File("not_a_real_file.csv");
		Executable executable = () -> FileService.readLines(file);

		assertThrows(FileNotFoundException.class, executable,"Read in a missing file");
	}
}