/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Ryan Rahbari
 */
package ex25;
import java.util.Scanner;
public class PwStrIndicator{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Please enter a password: ");
            String password = scanner.nextLine();
            if (password.equals("exit")){
            break;
            }
            int strength = passwordValidator(password);
            strengthOutput(password, strength);
        }
    }
    public static void strengthOutput(String password, int strength) {
        String type;
        if (strength == 0){
            type = "a very weak";
        } else if (strength == 1){
            type = "a weak";
        } else if (strength == 2){
            type = "a strong";
        } else if (strength == 3){
            type = "a very strong";
        } else{
            type = "an okay";
        }
        System.out.printf("The password '%s' is %s password.%n", password, type);
    }
    public static int passwordValidator(String password){
        int L = 0;
        int N = 0;
        int S = 0;
        boolean special = false;
        boolean letter = false;
        boolean letters = false;
        boolean number = false;
        boolean numbers = false;
        boolean length = password.length() > 7;
        for (int i = 0; i != password.length(); i++){
            char c = password.charAt(i);
            if (Character.isLetter(c)){
                letter = true;
                L++;
            }
            if (Character.isDigit(c)){
                number = true;
                N++;
            }
            if (!Character.isDigit(c) && !Character.isLetter(c)){
                S++;
            }
        }
        if (L > 1){
            letters = true;
        }
        if (N > 1){
            numbers = true;
        }
        if (S > 1){
            special = true;
        }
        if (special && letters && numbers && length) return 3;
        else if (letters && number && length) return 2;
        else if (letters && !special && !number && !length) return 1;
        else if (numbers && !letter && !special && !length) return 0;
        else return -1;
    }
}
