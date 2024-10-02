package counter;

import java.util.ArrayList;
import java.util.Collections;

public class WordCounterMain {
    public static void main(String[] args) {
        ArrayList<String> wordList1 = new ArrayList<>();
        Collections.addAll(wordList1, "Foo", "Bar", "Baz", "Foo", "Bar");
        ArrayList<String> wordList2 = new ArrayList<>();
        Collections.addAll(wordList2, "Foo", "Foo", "Baz", "Qux");

        WordCounter wc = new WordCounter();
        System.out.println(wc);

        wc.parse(wordList1);
        System.out.println(wc);

        wc.parse(wordList2);
        System.out.println(wc);
        System.out.println(wc.getCount("Foo"));
        System.out.println(wc.getCount("Toto"));
    }
}
