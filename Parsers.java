import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.*;
import java.net.URL;
import java.util.*;


public class Parsers {

    private static Document getPage() throws IOException {
        String url = "https://www.simbirsoft.com/";
        return Jsoup.parse(new URL(url), 30000);
    }

    public static void main(String[] args) throws IOException {
        ArrayList<String> list = new ArrayList<>();
        list.add(" ");
        list.add(",");
        list.add(".");
        list.add("!");
        list.add("?");
        list.add("(");
        list.add(")");
        list.add("[");
        list.add("]");
        list.add("-");
        list.add(";");
        list.add(":");
        list.add("\n");
        list.add("\r");
        list.add("\t");

        String textFromPage = getPage().text();
        Map<String, Word> countMap = new HashMap<>();

        String[] words = textFromPage.split(String.valueOf(list));
        for (String word : words) {
            Word wordMap = countMap.get(word);
            if (wordMap == null) {
                wordMap = new Word();
                wordMap.word = word;
                wordMap.count = 0;
                countMap.put(word, wordMap);
            }

            wordMap.count++;
        }

        for (Word word : countMap.values()) {
            System.out.println(word.word.toUpperCase(Locale.ROOT) + " - " + word.count);
        }
    }

}