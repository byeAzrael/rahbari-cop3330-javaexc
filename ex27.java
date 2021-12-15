/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Ryan Rahbari
 */
package ex27;
import org.apache.commons.lang3.math.NumberUtils;
import java.util.Scanner;
public class ValidatingInputs {
        public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Enter the first name: ");
            String first = sc.nextLine();
            System.out.print("Enter the last name: ");
            String last = sc.nextLine();
            System.out.print("Enter the ZIP code: ");
            String zip = sc.nextLine();
            System.out.print("Enter the employee ID: ");
            String id = sc.nextLine();
            if (validateInput(first, last, zip, id) == 1) {
                break;
            }
        }
    }
    public static int validateInput(String first, String last, String zip, String id){
        String output = "";
        boolean flag = true;
        if (validateName(first) != 0) flag = false;
        if (validateName(first) == 1)
            output += "The first name must be at least 2 characters long.\nThe first name must be filled in.\n";
        else if (validateName(first) == 2) output += "The first name must be at least 2 characters long.\n";
        if (validateName(last) != 0) flag = false;
        if (validateName(last) == 1)
            output += "The last name must be at least 2 characters long.\nThe last name must be filled in.\n";
        else if (validateName(last) == 2) output += "The last name must be at least 2 characters long.\n";
        if (!validateID(id)){
            flag = false;
            output += "The employee ID must be in the format of AA-1234.\n";
        }
        if (!validateZIP(zip)){
            flag = false;
            output += "The zipcode must be a 5 digit number.\n";
        }
        if (flag) output = "There were no errors found.";
        System.out.println("\n" + output);
        return 0;
    }

    public static int validateName(String name){
        if (name.length() < 1) {//
            return 1;
        } else if (!name.matches("[a-zA-Z]+") || name.length() < 2) {//
            return 2;
        }
        return 0;
    }

    public static boolean validateZIP(String zip){
        return ((zip.length() == 5) && (NumberUtils.isNumber(zip)));
    }

    public static boolean validateID(String id){
        if (id.length() != 7) return false;
        for (int i = 0; i < 7; i++){
            char c = id.charAt(i);
            if (!Character.isLetter(c) && (i == 0 || i == 1)){
                return false;
            }
            if (!(c == '-') && (i == 2)){
                return false;
            }
            if (!Character.isDigit(c) && (i > 2)){
                return false;
            }
        }
        return true;
    }
}
