package com.company.knapsack;

import java.util.Comparator;

public class CompareByRating implements Comparator<Item> {

    @Override
    public int compare(Item o1, Item o2) {
        double ratio = o1.getValue()/o1.getWeight() - o2.getValue()/o2.getWeight();
        if(ratio > 0)
            return -1;
        else if(ratio == 0)
            return 0;
        else
            return 1;
    }
}
