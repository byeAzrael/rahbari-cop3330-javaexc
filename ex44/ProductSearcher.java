/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Ryan Rahbari
 */

package ex44;

import java.util.Scanner;

public class ProductSearcher {
    static String inputPath = "src/main/resources/input_files/exercise44_input.json";
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Product foundProduct = new Product("", 0, 0);
        Products products = new Products(inputPath);
        String curSearchTerm;
        while (foundProduct.getName() == "") {
            System.out.print("What is the product name? ");
            curSearchTerm = input.nextLine();
            foundProduct = products.searchForProduct(curSearchTerm);
        }
        foundProduct.display();
    }

}
