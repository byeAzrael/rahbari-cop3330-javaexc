/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Ryan Rahbari
 */

package ex45;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class WordFinder {
    static String inputPath = "src/main/resources/input_files/exercise45_input.txt";
    static String outputPath = "src/main/resources/output_files/";
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> phraseList = readPhrases(inputPath);
        System.out.print("Output file name (discluding file extention): ");
        String outputFileName = input.nextLine();
        writePhrases(replaceOccurrences(phraseList, "utilize", "use"), outputPath + outputFileName + ".txt");
        System.out.println("All occurances of \"utilize\" successfully replaced with \"use\".");
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
    public static boolean writePhrases(ArrayList<String> phrases, String path) {
        createFileIfDoesntExist(path);
        try (FileWriter w = new FileWriter(path)) {
            for (String phrase : phrases)
                w.append(phrase).append("\n");
        } catch (IOException e) {
            return false;
        }
        return true;
    }
    public static void createFileIfDoesntExist(String path) {
        File file = new File(path);
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    public static ArrayList<String> replaceOccurrences(ArrayList<String> phraseList, String oldWord, String newWord) {
        for (int i = 0; i < phraseList.size(); i++)
            phraseList.set(i, phraseList.get(i).replace(oldWord, newWord));
        return phraseList;
    }
}
