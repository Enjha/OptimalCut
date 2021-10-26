package com.company.knapsack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Bag {

    private int weihgtLimit;

    public Bag(int weihgtLimit) {
        this.weihgtLimit = weihgtLimit;
    }

    public double getWeihgtLimit() {
        return weihgtLimit;
    }

    public void setWeihgtLimit(int weihgtLimit) {
        this.weihgtLimit = weihgtLimit;
    }

    public ArrayList<Item> initiateValue() {
        BufferedReader br = null;
        ArrayList<Item> listItems = new ArrayList<>();
        try {
            String sCurrentLine;
            br = new BufferedReader(new FileReader("data/bag.txt"));
            while ((sCurrentLine = br.readLine()) != null) {
                if(!sCurrentLine.equals(""))
                    listItems.add(new Item(Integer.parseInt(sCurrentLine.split(" ")[0]), Integer.parseInt(sCurrentLine.split(" ")[1])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        listItems.sort(new CompareByRating());
        return listItems;
    }
}
