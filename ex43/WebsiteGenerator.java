/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Ryan Rahbari
 */

package ex43;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WebsiteGenerator {
    static String websitesDirectory = "src/main/java/ex43/website/";
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Site name: ");
        String siteName = input.nextLine();
        System.out.print("Author: ");
        String author = input.nextLine();
        System.out.print("Do you want a folder for JavaScript?: ");
        boolean shouldCreateJSFolder = input.nextLine().equalsIgnoreCase("y");
        System.out.print("Do you want a folder for CSS?: ");
        boolean shouldCreateCSSFolder = input.nextLine().equalsIgnoreCase("y");
        generateWebsite(siteName, author, shouldCreateJSFolder, shouldCreateCSSFolder);
    }
    public static void generateWebsite(String siteName, String author, boolean shouldCreateJSFolder, boolean shouldCreateCSSFolder) {
        String curDirectory = websitesDirectory + siteName;
        createFileIfDoesntExist(curDirectory, true);
        System.out.println("Created ./website/" + siteName);
        genIndexHTML(curDirectory + "/index.html", siteName, author);
        System.out.println("Created ./website/" + siteName + "/index.html");
        if (shouldCreateJSFolder) {
            createFileIfDoesntExist(curDirectory + "/js", true);
            System.out.println("Created ./website/" + siteName + "/js/");
        }
        if (shouldCreateCSSFolder) {
            createFileIfDoesntExist(curDirectory + "/css", true);
            System.out.println("Created ./website/" + siteName + "/css/");
        }
    }
    public static boolean genIndexHTML(String path, String siteName, String author) {
        createFileIfDoesntExist(path, false);
        try (FileWriter w = new FileWriter(path)) {
            String header = String.format("<head>\n\t<title>%s</title>\n\t<meta name=\"author\" content=\"%s\">\n</head>", siteName, author);
            w.write(header);
        } catch (IOException e) {
            return false;
        }
        return true;
    }
    public static void createFileIfDoesntExist(String path, boolean isDirectory) {
        File file = new File(path);
        try {
            if (isDirectory)
                file.mkdir();
            else
                file.createNewFile();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
