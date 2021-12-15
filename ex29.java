/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Ryan Rahbari
 */
package ex29;
import java.util.Scanner;

public class HandBadInput {
    public static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        String input;

        do {
            System.out.print("What is the rate of return? ");
            input = sc.nextLine();
        } while (!driver(input));
    }


    public static boolean driver(String input) {

        if (isInt(input)) {
            int value = Integer.parseInt(input);
            if (value >= 1 && value <= 72) {
                System.out.println("It will take " + (72 / value) + " years to double your initial investment.");
                return true;
            }
        }

        System.out.println("Sorry. That's not a valid input.");

        return false;
    }


    public static boolean isInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (Exception ignore) {
            return false;
        }
    }
}
