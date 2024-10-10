package counter;

import java.util.ArrayList;
import java.util.TreeMap;

public class WordCounter {
    private TreeMap<String,Integer> wordCounts;

    public WordCounter(){
        this.wordCounts = new TreeMap<>();
    }

    public void parse(ArrayList<String> words){
        for (String str : words){
            if (wordCounts.get(str) != null){
                wordCounts.put(str,wordCounts.get(str)+1);
            }
            else{
                wordCounts.put(str,1);
            }
        }
    }

    public int getCount(String word){
        if(wordCounts.get(word) == null){
            return 0;
        }
        else{
            return wordCounts.get(word);
        }
    }

    public String toString(){
        return wordCounts.toString();
    }
}
