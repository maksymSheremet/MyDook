package my.code.chapter2.item_9;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MultiFileReaderTest {

    private final List<Path> tempFiles = new ArrayList<>();

    @BeforeEach
    void setup() throws IOException {
        for (int i = 1; i <= 3; i++) {
            Path tempFile = Files.createTempFile("file" + i, ".txt");
            try (FileWriter writer = new FileWriter(tempFile.toFile())) {
                writer.write("Line " + i + "\nAnother line");
            }
            tempFiles.add(tempFile);
        }
    }

    @Test
    void testReadFirstLines() {
        MultiFileReader reader = new MultiFileReader();
        List<String> filePaths = tempFiles.stream().map(Path::toString).toList();

        Map<String, String> result = reader.readFirstLines(filePaths);

        for (int i = 0; i < filePaths.size(); i++) {
            String expected = "Line " + (i + 1);
            assertEquals(expected, result.get(filePaths.get(i)));
        }
    }

    @AfterEach
    void cleanup() throws IOException {
        for (Path path : tempFiles) {
            Files.deleteIfExists(path);
        }
    }
}