package com.company.knapsack;

import java.util.ArrayList;

public class AlgoClassic {

    private final Bag o;
    private final ArrayList<String> constraints;

    public AlgoClassic(Bag o) {
        this.o = o;
        this.constraints = new ArrayList<>();
    }

    public void start() {
        ArrayList<Item> listItems = o.initiateValue();
        listItems.sort(new CompareByRating());
        int weightLimit = o.getWeihgtLimit();
        int weightStealerBag = 0;
        int i = listItems.size();
        while (weightLimit > weightStealerBag) {
            System.err.println(listItems.get(i% listItems.size()).getWeight());
            weightLimit -= listItems.get(i % listItems.size()).getWeight();
            weightStealerBag += listItems.get(i % listItems.size()).getWeight();
            constraints.add(String.valueOf(listItems.get(i % listItems.size()).getWeight()));
            i--;
        }
        System.err.println(constraints+" || " + weightLimit);
        constraints.add("#");
    }

    public ArrayList<String> getConstraints(){
        return this.constraints;
    }

}
