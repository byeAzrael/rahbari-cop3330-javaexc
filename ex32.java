/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Ryan Rahbari
 */
package ex32;
import java.util.Scanner;
import java.util.Random;

public class GuessNumberGame{
    public static void main (String[] args){
            System.out.println("Let's play Guess the Number!\n");
            boolean flag = true;
            while (flag) {
                int number = HardSel();
                flag = play(number);
            }
        }

        public static int HardSel(){
            Scanner scanner = new Scanner(System.in);
            int input;
            int number;
            while (true) {
                System.out.print("Enter the difficulty level (1, 2, or 3): ");
                if (scanner.hasNextInt()) {
                    input = scanner.nextInt();
                    if (input > 0 && input < 4){
                        number = GenNum(input);
                        return number;
                    } else {
                        System.out.println("Number was not between One and Three. Please re-input...\n");
                        continue;
                    }
                }
                System.out.println("Non-integer data entry. Please re-input...\n");
                scanner.nextLine();
            }
       }

        public static int GenNum(int input){
            Random rand = new Random();
            if (input > 2) {
                return rand.nextInt(1000) + 1;
            } else if (input > 1) {
                return rand.nextInt(100) + 1;
            } else {
                return rand.nextInt(10) + 1;
            }
        }

        public static boolean play(int number){
            Scanner scanner = new Scanner(System.in);
            int count = 0;
            int guess;
            int HighLow;
            System.out.print("I have my number. What's your guess? ");
            while (true){
                count++;
                if (scanner.hasNextInt()) {
                    guess = scanner.nextInt();
                    HighLow = highLOW(guess, number);//                                              <----------CHECKING HIGH/LOW
                    if (HighLow == 0) {
                        System.out.printf("You got it in %d guesses!\n\n", count);
                        break;
                    }
                    if (HighLow > 0) System.out.print("Too high. Guess again: ");
                    if (HighLow < 0) System.out.print("Too low. Guess again: ");
                } else scanner.nextLine();
            }
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
            System.out.println("Do you wish to play again (Y/N)? ");
            String replay = scanner.nextLine();
            return replay.equalsIgnoreCase("Y");
        }

        public static int highLOW (int input, int number){
            return Integer.compare(input, number);
        }
}
