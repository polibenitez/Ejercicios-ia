/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;
import aima.core.search.framework.HeuristicFunction;

/**
 *
 * @author zadik
 */
public class Horseheuristica1 implements HeuristicFunction {
    private static final int g1 = 1;
    private static final int g2 = 2;
    
    @Override
    public double h(Object o) {
        ModificatedBoard board = (ModificatedBoard) o;
        int n1 = board.getRow();
        int n2 = board.getColumn();
        return Math.abs(n1 - g1) + Math.abs(n2 - g2);   
    }

    
}
