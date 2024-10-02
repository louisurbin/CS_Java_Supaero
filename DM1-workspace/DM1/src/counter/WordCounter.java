package counter;

import java.util.ArrayList;
import java.util.TreeMap;

public class WordCounter {
    private TreeMap<String,Integer> wordCounts;
    
    //constructor
    public WordCounter(){
        this.wordCounts = new TreeMap<>();
    }

    //methods
    public void parse(ArrayList<String> words){
        for (String word : words){
           if (wordCounts.get(word) != null){
                wordCounts.put(word, wordCounts.get(word) + 1);
           }
           else{
                wordCounts.put(word, 1);
           }
        }
    }

    public int getCount(String word){
        if (wordCounts.get(word) == null){
            return 0;
        }
        else{
            return wordCounts.get(word);
        }
    }

    public String toString(){
        return this.wordCounts.toString();
    }

}
