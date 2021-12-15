/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Ryan Rahbari
 */
package ex36;
import java.util.ArrayList;
import java.util.Scanner;

public class CompStats{
    public static void main(String[] args){
        ArrayList<Double> input = new ArrayList<>();
        userInput(input);
        System.out.println(DataCheck.createPrint(input));
    }

    public static void userInput(ArrayList<Double> input){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.print("Enter a number: ");
            if (scanner.hasNextDouble()){
                input.add(scanner.nextDouble());
            } else {
                String done = scanner.nextLine();
                if (done.equalsIgnoreCase("done")){
                    break;
                } else
                    continue;
            }
            scanner.nextLine();
        }
    }

    public class DataCheck{
        public static String createPrint(ArrayList<Double> userInput) {
            StringBuilder output = new StringBuilder("Numbers: ");
            double avg = average(userInput);
            double min = minimum(userInput);
            double max = maximum(userInput);
            double std = standardDeviation(userInput, avg);
            for (Double datum : userInput) {
                output.append(String.format("%.0f", datum)).append(", ");
            }
            output.setLength(output.length() - 2);
            output.append("\nThe average is ").append(String.format("%.1f", avg));
            output.append("\nThe minimum is ").append(String.format("%.0f", min));
            output.append("\nThe maximum is ").append(String.format("%.0f", max));
            output.append("\nThe standard deviation is ").append(String.format("%.2f", std));
            return output.toString();
        }

        public static double average(ArrayList<Double> data) {
            double average = 0;
            for (Double datum : data) {
                average += datum;
            }
            return average / data.size();
        }

        public static double minimum(ArrayList<Double> data) {
            double min = data.get(0);
            for (Double datum : data) {
                if (min > datum) {
                    min = datum;
                }
            }
            return min;
        }

        public static double maximum(ArrayList<Double> data) {
            double max = data.get(0);
            for (Double datum : data) {
                if (max < datum) {
                    max = datum;
                }
            }
            return max;
        }

        public static double standardDeviation(ArrayList<Double> data, double avg) {
            double numerator = 0;
            for (Double x : data) {
                numerator += Math.pow((x - avg), 2);
            }
            return Math.round(Math.sqrt(numerator / data.size()) * 100) / 100.0;
        }
    }
}
