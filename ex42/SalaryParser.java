/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Ryan Rahbari
 */

package ex42;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SalaryParser {
    static String inputPath = "src/main/resources/input_files/exercise42_input.txt";
    public static void main(String[] args) {
        Employees employees = new Employees();
        employees.setEmployeeList(readEmployees(inputPath));
        System.out.println(employees.formatEmployeeList());
    }
    public static ArrayList<Employee> readEmployees(String path) {
        ArrayList<Employee> employeeList = new ArrayList<>();
        try (Scanner file = new Scanner(new File(path)).useDelimiter(System.lineSeparator())) {
            while (file.hasNext()) {
                ArrayList<String> parsedCSV = parseCSV(file.next());
                employeeList.add(new Employee(parsedCSV.get(1), parsedCSV.get(0), Integer.parseInt(parsedCSV.get(2))));
            }
        } catch(IOException e) {
            System.out.println(e);
        }
        return employeeList;
    }
    public static ArrayList<String> parseCSV(String rawCSV) {
        return new ArrayList<>(Arrays.asList(rawCSV.split(",")));
    }
}
