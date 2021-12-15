/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Ryan Rahbari
 */
package ex33;
import java.util.Scanner;

public class Magic8Ball {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] responses = GenRR();
        int random = randomGen();
        System.out.println("What's your question?");
        sc.nextLine();
        System.out.println("\n"+responses[random]);
    }

    public static int randomGen(){
        return (int) Math.floor(Math.random() * 5);
    }

    public static String[] GenRR(){
          return new String[] {
                "Yes!",
                "No!",
                "Maybe.",
                "Ask again later.",
                "Reply try it again."
        };
    }
}
