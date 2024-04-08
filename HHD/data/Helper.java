import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Helper {
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();
        String filePath = "Big-Homework-OOP/data/RecentList.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                words.addAll(Arrays.asList(line.split("\\s+")));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String word : words) {
            System.out.println(word);
        }
    }
}