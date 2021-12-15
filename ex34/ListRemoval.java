/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Ryan Rahbari
 */
package ex34;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ListRemoval {
    public static void main(String[] args) {
        ArrayList<String> employees = EmployeeList();
    }

    public static ArrayList<String> EmployeeList(){
        ArrayList<String> employees = new ArrayList(Arrays.asList("John Smith", "Jackie Jackson", "Chris Jones", "Amanda Cullen", "Jeremy Goodwin"));
        printEmployees(employees);
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.print("Enter an employee name to remove: ");
        String nameToRemove = sc.nextLine();
        employees.remove(nameToRemove);
        System.out.println();
        printEmployees(employees);
        return employees;
    }

    public static void printEmployees(ArrayList<String> employees){
        System.out.println("There are "+employees.size()+" employees: ");
        for(String emp:employees){
            System.out.println(emp);
        }
    }
}
