package com.company;

import com.company.glpk.GlpkSolve;
import com.company.knapsack.AlgoClassic;
import com.company.knapsack.Bag;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Bag test = new Bag(100);
        AlgoClassic algo = new AlgoClassic(test);

        while (new GlpkSolve().solve(algo.getConstraints())) {
            algo.start();
        }

        File file = new File("data/bag.txt");
        if (file.exists() && file.delete())
            if (file.createNewFile())
                System.out.println("Fichier bag.txt reset");
    }
}
