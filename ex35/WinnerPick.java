/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Ryan Rahbari
 */
package ex35;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class WinnerPick{
    public static void main(String[] args){
        String str;
        ArrayList<String> names = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        do{
         System.out.print("Enter a name: ");
          str = sc.nextLine();
          names.add(str);
        }
        while(!str.isEmpty());
        names.remove(names.size() - 1);
        int winner = rng(names);
        System.out.println("The winner is... "+names.get(winner)+".");
    }

    public static int rng(ArrayList<String> names){
        Random r = new Random();
        return r.nextInt(names.size());
    }
}
