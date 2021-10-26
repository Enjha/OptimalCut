package com.company;

import com.company.glpk.GlpkSolve;
import com.company.knapsack.AlgoClassic;
import com.company.knapsack.Bag;

public class Main {

    public static void main(String[] args) {
        Bag test = new Bag(100);
        AlgoClassic algo = new AlgoClassic(test);

        while(new GlpkSolve().solve(algo.getConstraints())){
            algo.start();
        }
    }
}
