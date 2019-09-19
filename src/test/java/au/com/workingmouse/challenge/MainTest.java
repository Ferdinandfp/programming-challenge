package au.com.workingmouse.challenge;

import au.com.workingmouse.challenge.config.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class MainTest extends Main {

	@BeforeEach
	void setUp() {
	}

	@AfterEach
	void tearDown() {
		File outputFile = new File(OUTPUT_FILENAME);
		if (outputFile.exists()) {
			outputFile.delete();
		}
	}

	@Test
	void main() {
	}

	@Test
	void writeFileSingleLine() throws IOException {
		final String basicText = "Yolo";
		Main.writeFile(basicText);

		String actualOutput = readFile();
		assertEquals(basicText, actualOutput);
	}

	@Test
	void writeFileMultilineLine() throws IOException {
		final String basicText = "Yolo\n"
				+ "But on two lines";
		Main.writeFile(basicText);

		String actualOutput = readFile();
		assertEquals(basicText, actualOutput);
	}

	@Test
	void loadAndParseFileTest() {
		// TODO: Complete coverage
	}

	private String readFile() throws IOException {
		return new Scanner(new File(OUTPUT_FILENAME)).useDelimiter("\\A").next();
	}
}