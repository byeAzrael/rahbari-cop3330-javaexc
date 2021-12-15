/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Ryan Rahbari
 */
package ex30;

public class MultiplicationTable {
    public static final int tableSize = 12;

    public static void main(String[] args) {
        String table = GenTable();
        display(table);
    }

    public static void display(String table){
        System.out.println(table);
    }

    public static String GenTable() {
        int[][] arr = new int[tableSize][tableSize];
        String table = "";
        StringBuilder BuildTable = new StringBuilder(table);
        for (int i = 0; i < tableSize; i++) {
            for (int j = 0; j < tableSize; j++) {
                arr[i][j] = (i + 1) * (j + 1);
            }
            BuildTable.append(Rows(arr[i])).append("\n");
        }
        table = BuildTable.toString();
        return table;
    }

    public static String Rows(int[] arr){
        StringBuilder row = new StringBuilder();
        for (int i = 0; i < tableSize; i++) {
            if (arr[i] < 10) row.append("  ");
            else if (arr[i] < 100) row.append(" ");
            row.append(" ").append(arr[i]);
        }
       return row.toString();
    }
}
