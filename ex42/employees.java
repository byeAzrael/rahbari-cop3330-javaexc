/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Ryan Rahbari
 */

package ex42;

import java.util.ArrayList;
import java.util.Collections;

public class Employees {
    private ArrayList<Employee> employeeList;
    public Employees() {
    }
    public void setEmployeeList(ArrayList<Employee> incomingList) {
        this.employeeList = incomingList;
    }
    public ArrayList<Employee> getEmployeeList() {
        return this.employeeList;
    }
    public String formatEmployeeList() {
        String formattedEmployeesOutput = "Last      First     Salary\n" + "--------------------------";
        for (Employee employee : employeeList)
            formattedEmployeesOutput += "\n" + employee.getLastName() + "    \t" + employee.getFirstName() + "  \t" + employee.getSalary();
        return formattedEmployeesOutput;
    }

}
