/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Ryan Rahbari
 */
package ex28;
import java.util.Scanner;
import java.lang.reflect.Array;

public class AddNumbers{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int count = 1;
        int sum = 0;
        int element;
        while (count < 6){
            System.out.print("Enter a number: ");
            element = sc.nextInt();
            sum += element;
            count++;
        }
        System.out.println("The total is " + sum + ".");
    }
    public static int SumValues(int[] x){
        int sum = 0;
        for (int i = 0; i < Array.getLength(x); i++) {
            sum += x[i];
        }
        return sum;
    }
}
