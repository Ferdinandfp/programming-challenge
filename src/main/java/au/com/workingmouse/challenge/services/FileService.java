package au.com.workingmouse.challenge.services;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileService {

    private static final Logger LOGGER = Logger.getLogger(FileService.class);

    public static List<String> readLines(File file) throws IOException {
        LOGGER.trace("Reading lines for file " +  file.getName());

        List<String> lines = new ArrayList<>();

       try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
           String line;
           while((line = bufferedReader.readLine()) != null) {
               lines.add(line);

               LOGGER.trace("Line: " + line);
           }

       }

        return lines;
    }
}
