import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        HashMap<String, WordInfo> dictionary = new HashMap<>();
        String fileName = "document.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;
            int lineNumber = 0;

            while ((line = br.readLine()) != null) {
                lineNumber++;
                line = line.toLowerCase();

                line = line.replaceAll("[^a-zA-Z\\s]", "");

                String[] words = line.split("\\s+");

                for (String word : words) {

                    if (word.isEmpty()) {
                        continue;
                    }

                    if (dictionary.containsKey(word)) {

                        WordInfo info = dictionary.get(word);
                        info.addOccurrence(lineNumber);

                    } else {
                        WordInfo info = new WordInfo();
                        info.addOccurrence(lineNumber);
                        dictionary.put(word, info);
                    }
                }
            }
            System.out.println("===== DOCUMENT DICTIONARY =====\n");
            for (Map.Entry<String, WordInfo> entry : dictionary.entrySet()) {
                System.out.println("Word: " + entry.getKey());
                System.out.println(entry.getValue());
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}