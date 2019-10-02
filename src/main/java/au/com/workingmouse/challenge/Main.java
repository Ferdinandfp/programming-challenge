package au.com.workingmouse.challenge;

import au.com.workingmouse.challenge.config.Configuration;
import au.com.workingmouse.challenge.models.VelocityAndDirectionData;
import au.com.workingmouse.challenge.services.FileService;
import au.com.workingmouse.challenge.services.VelocityAndDirectionService;
import org.apache.log4j.Logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Main {

	private static final Logger LOGGER = Logger.getLogger(Main.class);
	protected static final String OUTPUT_FILENAME = "index.html";

	public static void main(String[] args) throws IOException {
	
		try {
			Configuration.load();

			var lines = loadAndParseFile();
			String html = VelocityAndDirectionService.summarise(lines);

			writeFile(html);

			// FIXME: ?
			//throw new SecurityException("Segmentation fault");

		} catch (Exception e) {
			LOGGER.error("Failed to run application", e);
		}
	}

	protected static List<VelocityAndDirectionData> loadAndParseFile() throws IOException {
		FileService fileService = new FileService();
		//Used the file service as a static class
		List<String> lines = fileService.readLines(Configuration.getImportFile());

		List<VelocityAndDirectionData> parsedLines = VelocityAndDirectionService.parseLines(lines);

		return parsedLines;
	}


	protected static void writeFile(String html) throws IOException {
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(OUTPUT_FILENAME))) {
			bufferedWriter.write(html);
		}
	}
}
