/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Ryan Rahbari
 */
 
package ex24;
import java.util.Scanner;
public class AnagramChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter two strings and I'll tell you if they are anagrams:");
        System.out.print("Enter the first string: ");
        String word1 = sc.next();
        System.out.print("Enter the second string: ");
        String word2 = sc.next();
        if(isAnagram(word1,word2)){
            System.out.println('"'+word1+'"'+" and "+'"'+word2+'"'+" are anagrams.");
        }
        else{
            System.out.println('"'+word1+'"'+" and "+'"'+word2+'"'+" are not anagrams.");
        }
    }
    public static boolean isAnagram(String word1,String word2){
       if(word1.length()==word2.length()){
            int arr1[] = new int[26];
            for(int i=0;i<word1.length();i++){
                arr1[(int)(word1.charAt(i)-97)]++;
            }
            int arr2[] = new int[26];
            for(int i=0;i<word2.length();i++){
                arr2[(int)(word2.charAt(i)-97)]++;
            }
            for(int i=0;i<26;i++){
                if(arr1[i]!=arr2[i]) return false;
            }
            return true;
        }
        else{
            return false;
        }
    }
}
