/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Ryan Rahbari
 */

package ex44;
public class Product {
    private String name;
    private float price;
    private int quantity;
    public Product(String name, float price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public float getPrice() {
        return this.price;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public int getQuantity() {
        return this.quantity;
    }
    public void display() {
        System.out.println(String.format("Name: %s\nPrice: %.2f\nQuantity: %d", this.name, this.price, this.quantity));
    }

}
