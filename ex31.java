/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Ryan Rahbari
 */
package ex31;

import java.util.Scanner;

public class HeartRate{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int restingHR;
        int age;
        while(true) {
            System.out.print("Resting Pulse: ");
            String input = sc.next();
            if(isNumeric(input)){
                restingHR = Integer.parseInt(input);
                break;
            }else{
                System.out.println("Invalid Pulse");
            }
        }
        while(true) {
            System.out.print("Age: ");
            String input = sc.next();
            if(isNumeric(input)) {
                age = Integer.parseInt(input);
                break;
            }else{
                System.out.println("Invalid Age");
            }

        }
        System.out.println("\nIntensity    | Rate    \n-------------|--------");
        for(double intensity = 55 ; intensity <= 95 ; intensity += 5) {
            double rate = Math.round((((220 - age) - restingHR) * intensity/100) + restingHR);
            System.out.println(intensity+"%\t\t |  "+(int)Math.ceil(rate)+" bpm");
        }
        sc.close();
    }

    public static boolean isNumeric(String input) {
        try {
            Integer.parseInt(input);
        }catch(Exception e) {
            return false;
        }
        return true;
    }
}
