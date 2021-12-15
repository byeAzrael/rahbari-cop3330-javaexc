/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Ryan Rahbari
 */
package ex26;
public class PaymentCalculator{
      public int Calculator(double i, double b, double p){
          double equation = ((-1.0 / 30) * Math.log(1 + ((b / p) * (1 - Math.pow(1 + i, 30))))) / Math.log(1 + i);
          return (int) Math.ceil(equation);
      }
}
