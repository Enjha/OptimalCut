package com.company.glpk;

import org.gnu.glpk.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GlpkSolve {

    public GlpkSolve() {
    }

    public void solve() {
        glp_prob lp;
        glp_smcp parm;
        SWIGTYPE_p_int ind;
        SWIGTYPE_p_double val;
        int ret;

        try {
            lp = GLPK.glp_create_prob();
            GLPK.glp_set_prob_name(lp, "OptimalCutProblem");
            GLPK.glp_add_cols(lp, 4);
            //y1
            GLPK.glp_set_col_name(lp, 1, "y1");
            GLPK.glp_set_col_kind(lp, 1, GLPKConstants.GLP_CV);
            GLPK.glp_set_col_bnds(lp, 1, GLPKConstants.GLP_LO, 0.0, 0.0);
            //y2
            GLPK.glp_set_col_name(lp, 2, "y2");
            GLPK.glp_set_col_kind(lp, 2, GLPKConstants.GLP_CV);
            GLPK.glp_set_col_bnds(lp, 2, GLPKConstants.GLP_LO, 0.0, 0.0);
            //y3
            GLPK.glp_set_col_name(lp, 3, "y3");
            GLPK.glp_set_col_kind(lp, 3, GLPKConstants.GLP_CV);
            GLPK.glp_set_col_bnds(lp, 3, GLPKConstants.GLP_LO, 0.0, 0.0);
            //y4
            GLPK.glp_set_col_name(lp, 4, "y4");
            GLPK.glp_set_col_kind(lp, 4, GLPKConstants.GLP_CV);
            GLPK.glp_set_col_bnds(lp, 4, GLPKConstants.GLP_LO, 0.0, 0.0);

            // Allocate memory
            ind = GLPK.new_intArray(4);
            val = GLPK.new_doubleArray(2);

            GLPK.glp_add_rows(lp, 4);

            GLPK.glp_set_row_name(lp, 1, "c1");
            GLPK.glp_set_row_bnds(lp, 1, GLPKConstants.GLP_UP, 0, 1);
            GLPK.intArray_setitem(ind, 1, 1);
            GLPK.doubleArray_setitem(val, 1, 2.);
            GLPK.glp_set_mat_row(lp, 1, 1, ind, val);

            GLPK.glp_set_row_name(lp, 2, "c2");
            GLPK.glp_set_row_bnds(lp, 2, GLPKConstants.GLP_UP, 0, 1);
            GLPK.intArray_setitem(ind, 1, 1);
            GLPK.intArray_setitem(ind, 2, 2);
            GLPK.intArray_setitem(ind, 3, 4);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.doubleArray_setitem(val, 2, 1.);
            GLPK.doubleArray_setitem(val, 3, 1.);
            GLPK.glp_set_mat_row(lp, 2, 3, ind, val);

            GLPK.glp_set_row_name(lp, 3, "c3");
            GLPK.glp_set_row_bnds(lp, 3, GLPKConstants.GLP_UP, 0, 1);
            GLPK.intArray_setitem(ind, 1, 1);
            GLPK.intArray_setitem(ind, 2, 2);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.doubleArray_setitem(val, 2, 1.);
            GLPK.glp_set_mat_row(lp, 3, 2, ind, val);

            GLPK.glp_set_row_name(lp, 4, "c4");
            GLPK.glp_set_row_bnds(lp, 4, GLPKConstants.GLP_UP, 0, 1);
            GLPK.intArray_setitem(ind, 1, 1);
            GLPK.intArray_setitem(ind, 2, 3);
            GLPK.intArray_setitem(ind, 3, 4);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.doubleArray_setitem(val, 2, 1.);
            GLPK.doubleArray_setitem(val, 3, 1.);
            GLPK.glp_set_mat_row(lp, 4, 3, ind, val);

           /* GLPK.glp_set_row_name(lp, 5, "c5");
            GLPK.glp_set_row_bnds(lp, 5, GLPKConstants.GLP_UP, 0, 1);
            GLPK.intArray_setitem(ind, 1, 1);
            GLPK.intArray_setitem(ind, 2, 2);
            GLPK.intArray_setitem(ind, 3, 3);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.doubleArray_setitem(val, 2, 1.);
            GLPK.doubleArray_setitem(val, 3, 1.);
            GLPK.glp_set_mat_row(lp, 5, 3, ind, val); */

            // Free memory
            GLPK.delete_intArray(ind);
            GLPK.delete_doubleArray(val);

            // Define objective
            GLPK.glp_set_obj_name(lp, "z");
            GLPK.glp_set_obj_dir(lp, GLPKConstants.GLP_MAX);
            GLPK.glp_set_obj_coef(lp, 1, 97);
            GLPK.glp_set_obj_coef(lp, 2, 610);
            GLPK.glp_set_obj_coef(lp, 3, 395);
            GLPK.glp_set_obj_coef(lp, 4, 211);

            // Solve model
            parm = new glp_smcp();
            GLPK.glp_init_smcp(parm);
            ret = GLPK.glp_simplex(lp, parm);

            if (ret == 0) {
                write_lp_solution(lp);
            } else {
                System.out.println("The problem could not be solved");
            }
            // Free memory
            GLPK.glp_delete_prob(lp);
        } catch (GlpkException ex) {
            ex.printStackTrace();
        }
    }

    static void write_lp_solution(glp_prob lp) {
        int i;
        int n;
        String name;
        double val;

        name = GLPK.glp_get_obj_name(lp);
        val = GLPK.glp_get_obj_val(lp);
        System.out.print(name);
        System.out.print(" = ");
        System.out.println(val);
        n = GLPK.glp_get_num_cols(lp);

        /*
        FileWriter file = new FileWriter("bag.txt");
        BufferedWriter buffer = new BufferedWriter(file);
        */
        try (FileWriter fw = new FileWriter("data/bag.txt", true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            for (i = 1; i <= n; i++) {
                name = GLPK.glp_get_col_name(lp, i);
                val = GLPK.glp_get_col_prim(lp, i);
                System.out.print(name);
                System.out.print(" = ");
                System.out.println(val);
                if (val > 0) {
                    switch (name) {
                        case "y1":
                            out.println("1 45");
                            break;
                        case "y2":
                            out.println("1 36");
                            break;
                        case "y3":
                            out.println("1 31");
                            break;
                        case "y4":
                            out.println("1 14");
                            break;
                    }
                }
            }
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }
    }

}
