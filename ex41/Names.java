/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Ryan Rahbari
 */

package ex41;

import java.util.ArrayList;
import java.util.Collections;
public class Names {
    private ArrayList<String> nameList;
    public Names() {
    }
    public void setNameList(ArrayList<String> incomingList) {
        this.nameList = incomingList;
    }
    public ArrayList<String> getNameList() {
        return this.nameList;
    }
    public ArrayList<String> sortNameList() {
        Collections.sort(this.nameList);
        return this.nameList;
    }
    public int size() {
        return this.nameList.size();
    }
}
