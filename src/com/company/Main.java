package com.company;

import org.gnu.glpk.GLPK;

public class Main {

    public static void main(String[] args) {
	// write your code here
        GLPK gl = new GLPK();
        System.out.println(GLPK.glp_version());
    }
}
