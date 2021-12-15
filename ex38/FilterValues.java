/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Ryan Rahbari
 */
package ex38;
import java.util.ArrayList;
import java.util.Scanner;

public class FilterValues{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a list of numbers, separated by spaces: ");
        String data = sc.nextLine();
        Integer evenList[] = FilterValues.DataSplit(data);
        System.out.print("The even numbers are ");
        for(int i=0; i<evenList.length; i++){
            if(i < evenList.length-1){
                System.out.print(evenList[i] + " ");
            }
            else
            {
                System.out.print(evenList[i] + ".");
            }
        }
    }

    public static Integer[] DataSplit(String data){
        String list[] = data.split(" ");
        return filterEvenNumbers(list);
    }

    public static Integer[] filterEvenNumbers(String[] list){
        ArrayList<Integer> newList = new ArrayList<>();
        for(int i=0; i<list.length; i++){
            int num = Integer.parseInt(list[i]);
            if(num % 2 == 0){
                newList.add(num);
            }
        }
        Integer[] arr = new Integer[newList.size()];
        arr = newList.toArray(arr);
        return arr;
    }
}
