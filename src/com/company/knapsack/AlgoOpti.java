package com.company.knapsack;

import java.util.ArrayList;

public class AlgoOpti {

    private final ArrayList<Item> listItems;
    private int bestValue;


    public AlgoOpti(Bag o) {
        this.listItems = o.initiateValue();
        this.bestValue = 0;
    }

    public double greedy(double capacity, double value){
        int i = 0;
        while(capacity>=listItems.get(i).getWeight()){
            capacity -= listItems.get(i).getWeight();
            value += listItems.get(i).getValue();
            i++;
        }
        return value + ( (listItems.get(i).getValue() * capacity) / listItems.get(i).getWeight() );
    }

    public int findOpti(double capacity, double currentValue, int index){
        if(capacity < 0 || index == listItems.size() - 1) return 0;
        if(bestValue < currentValue){
            bestValue = (int) currentValue;
            return 0;
        }
        if(bestValue >= greedy(capacity,currentValue)) return 0;
        findOpti(capacity,currentValue,index+1);
        findOpti(capacity-(listItems.get(index).getWeight()),currentValue+(listItems.get(index).getValue()),index+1);
        return bestValue;
    }

}
