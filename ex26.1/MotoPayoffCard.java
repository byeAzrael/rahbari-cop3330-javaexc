/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Ryan Rahbari
 */
package ex26;
import java.util.Scanner;
public class MotoPayoffCard{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        PaymentCalculator calc = new PaymentCalculator();
        System.out.print("What is your balance? ");
        double b = sc.nextDouble();
        System.out.print("What is the APR on the card (as a percent)? ");
        double i = sc.nextDouble();
        System.out.print("What is the monthly payment you can make? ");
        double p = sc.nextDouble();
        i = i / 100 / 365;
        b = (Math.ceil(b * 100)) / 100.0;
        p = (Math.ceil(p * 100)) / 100.0;
        int months = calc.Calculator(i, b, p);
        System.out.printf("It will take you %d months to pay off this card.", months);
       }
}
