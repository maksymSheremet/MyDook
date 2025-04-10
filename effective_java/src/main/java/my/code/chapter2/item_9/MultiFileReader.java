package my.code.chapter2.item_9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MultiFileReader {
    public Map<String, String> readFirstLines(List<String> filePaths) {
        Map<String, String> result = new HashMap<>();

        for (String path : filePaths) {
            try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
                String firstLine = reader.readLine();
                result.put(path, firstLine);
            } catch (IOException e) {
                result.put(path, "ERROR: " + e.getMessage());
            }
        }

        return result;
    }
}
