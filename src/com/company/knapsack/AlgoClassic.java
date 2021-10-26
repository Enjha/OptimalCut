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
        ArrayList<Integer> itemStealed = new ArrayList<>();
        int weightStealerBag = 0;
        int i = listItems.size();
        while (o.getWeihgtLimit() > weightStealerBag) {
            o.setWeihgtLimit((int) (o.getWeihgtLimit() - listItems.get(i % listItems.size()).getWeight()));
            itemStealed.add(listItems.get(i % listItems.size()).getValue());
            weightStealerBag += listItems.get(i % listItems.size()).getValue();
            constraints.add(String.valueOf(listItems.get(i % listItems.size()).getValue()));
            i--;
        }
        System.out.println(itemStealed + " " + constraints);
        constraints.add("#");
    }

    public ArrayList<String> getConstraints(){
        return this.constraints;
    }

}
