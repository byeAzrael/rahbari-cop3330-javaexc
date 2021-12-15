/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Ryan Rahbari
 */

package ex46;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class WordFrequencyFinder {
    static String inputPath = "src/main/resources/input_files/exercise46_input.txt";
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> phraseList = readPhrases(inputPath);
        displayWordOccurrencesHistogram(countOccurrences(phraseList));
    }
    public static ArrayList<String> readPhrases(String path) {
        ArrayList<String> phraseList = new ArrayList<>();
        try (Scanner file = new Scanner(new File(path)).useDelimiter(System.lineSeparator())) {
            while (file.hasNext()) phraseList.add(file.next());
        } catch(IOException e) {
            System.out.println(e);
        }
        return phraseList;
    }
    public static HashMap<String, Integer> countOccurrences(ArrayList<String> phraseList) {
        HashMap<String, Integer> wordHashMap = new HashMap<String, Integer>();
        for (String phrase : phraseList)
            for (String word : phrase.split(" "))
                if (wordHashMap.get(word) == null)
                    wordHashMap.put(word, 1);
                else
                    wordHashMap.put(word, wordHashMap.get(word) + 1);
        return sortHashMap(wordHashMap);
    }
    public static HashMap<String, Integer> sortHashMap(HashMap<String, Integer> hashMap) {
        List<Map.Entry<String, Integer>> list = new LinkedList<>(hashMap.entrySet());
        Collections.sort(list, Comparator.comparing(Map.Entry::getValue));
        Collections.reverse(list);
        HashMap<String, Integer> newHashMap = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry : list)
            newHashMap.put(entry.getKey(), entry.getValue());
        return newHashMap;
    }
    public static void displayWordOccurrencesHistogram(HashMap<String, Integer> hashMap) {
        for (String key : hashMap.keySet())
            System.out.println(String.format("%s: %s", key, convertIntToAsterisks(hashMap.get(key))));
    }
    public static String convertIntToAsterisks(int numAsterisks) {
        String asterisksString = "";
        for (int i = 0; i < numAsterisks; i++)
            asterisksString += "*";
        return asterisksString;
    }
}
