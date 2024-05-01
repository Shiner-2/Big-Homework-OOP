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


        ArrayList<Word> wwww = res.search("price-list");

        for (Word w : wwww) {
            System.out.println(w.getDefinition());
            Helper.showWordDefinition(w);
        }
//        Word w = wwww.get(0);
//
//        Helper.showWordDefinition(w);

//        System.out.println(w.getWord());
//        System.out.println(w.getDefinition());

//        System.out.println(res.contains("a la carte"));
//        System.out.println(res.search("1 to 1 relationship").get(0).getDefinition());
    }
}
