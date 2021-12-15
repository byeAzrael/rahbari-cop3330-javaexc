/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Ryan Rahbari
 */
package ex39;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingRecords{
    public static void main(String[] args){

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("John","Johnson         ","Manager              ","2016-12-31"));
        employeeList.add(new Employee("Tou","Xiong            ","Software Engineer    ","2016-10-05"));
        employeeList.add(new Employee("Michaela","Michaelson  ", "District Manager     ", "2015-12-19"));
        employeeList.add(new Employee("Jake","Jacobson        ","Programmer           ",""));
        employeeList.add(new Employee("Jacquelyn","Jackson    ","DBA                  ",""));
        employeeList.add(new Employee("Sally","Webber         ","Web Developer        ","2015-12-18"));

        Collections.sort(employeeList, new LastNameSort());

        System.out.println("Name" + "                 |  " + "Position            |  " + "Separation Date            ");
        System.out.println("---------------------|----------------------|----------------------");

        for (Employee emp : employeeList) {
            System.out.format("%s "+"%s"+""+"| %s"+"| "+"%s",emp.getFirstName(),emp.getLastName(),emp.getPosition(), emp.getSeparationDate());
            System.out.println();
        }

    }
}
