/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aima.core.environment.ajedrez;

import aima.core.search.framework.HeuristicFunction;

/**
 *
 * @author Edwin Mauricio Quishpe
 */
public class AjedrezHeuristicFunction1 implements HeuristicFunction{
    private static final int g1 = 1;
    private static final int g2 = 2;
    
    /**
     * @param state
     * @return 
     */
    @Override
    public double h(Object state) {
        AjedrezBoard board = (AjedrezBoard) state;
        int n1 = board.getFila();
        int n2 = board.getColumna();
        return Math.abs(n1 - g1) + Math.abs(n2 + g2);
    }
}
