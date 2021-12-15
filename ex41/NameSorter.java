/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Ryan Rahbari
 */

package ex41;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class NameSorter {
    static String inputPath = "src/main/resources/input_files/exercise41_input.txt";
    static String outputPath = "src/main/resources/output_files/exercise41_output.txt";
    public static void main(String[] args) {
        Names names = new Names();
        names.setNameList(readNames(inputPath));
        writeNames(names.sortNameList(), outputPath);
    }
    public static ArrayList<String> readNames(String path) {
        ArrayList<String> namesList = new ArrayList<>();
        try (Scanner file = new Scanner(new File(path)).useDelimiter(System.lineSeparator())) {
            while (file.hasNext()) namesList.add(file.next());
        } catch(IOException e) {
            System.out.println(e);
        }
        return namesList;
    }
    public static boolean writeNames(ArrayList<String> names, String path) {
        createFileIfDoesntExist(path);
        try (FileWriter w = new FileWriter(path)) {
            String header = String.format("Total of %d names\n-----------------\n", names.size());
            w.write(header);
            for (String name : names)
                w.append(name).append("\n");
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
}
