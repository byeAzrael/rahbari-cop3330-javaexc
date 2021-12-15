/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Ryan Rahbari
 */

package ex44;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import com.google.gson.*;
public class Products {
    private ArrayList<Product> productList = new ArrayList<>();
    public Products(String path) {
        File input = new File(path);
        try {
            JsonElement jsonParsed = JsonParser.parseReader(new FileReader(input));
            JsonObject jsonObject = jsonParsed.getAsJsonObject();
            JsonArray jsonProductList = jsonObject.get("products").getAsJsonArray();
            for (JsonElement productJson : jsonProductList) {
                JsonObject jsonProduct = productJson.getAsJsonObject();
                String name = jsonProduct.get("name").getAsString();
                float price = jsonProduct.get("price").getAsFloat();
                int quantity = jsonProduct.get("quantity").getAsInt();
                this.productList.add(new Product(name, price, quantity));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }
    public void setProductList(ArrayList<Product> incomingList) {
        this.productList = incomingList;
    }
    public ArrayList<Product> getProductList() {
        return this.productList;
    }
    public Product searchForProduct(String searchTerm) {
        for (Product product : this.productList)
            if (product.getName().equalsIgnoreCase(searchTerm))
                return product;
        System.out.println("Sorry, that product was not found in our inventory.");
        return new Product("", 0, 0);
    }

}
