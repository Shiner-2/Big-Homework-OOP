import com.example.hhd.Dictionary;
import com.example.hhd.Helper;
import com.example.hhd.TrieDictionary;
import com.example.hhd.Word;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class TrieTest {

    public static void main(String[] args) throws IOException {
        File file = new File("src/main/resources/data/anhviet109K.txt");
        Dictionary res = new TrieDictionary(file);
//
//        System.out.println(file.exists());


        ArrayList<Word> words = res.search("price-list");

        for (Word w : words) {
            System.out.println(w.getDefinition());
        }
        Word w = words.get(0);
        System.out.println(w.getWord());
        System.out.println(w.getDefinition());

//        System.out.println(res.contains("a la carte"));
//        System.out.println(res.seamrch("1 to 1 relationship").get(0).getDefinition());

    }
}
