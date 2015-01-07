/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;
import aima.core.search.framework.HeuristicFunction;
import java.lang.Object;
/**
 *
 * @author zadik
 */
public class Horseheuristica2 implements HeuristicFunction {
    private static final int g1 = 1;
    private static final int g2 = 2;
    
    


    @Override
    public double h(Object o) {
        ModificatedBoard board = (ModificatedBoard) o;
        int n1 = board.getRow();
        int n2 = board.getColumn();
        int resp=Math.abs(n1 - g1) + Math.abs(n2 - g2);
       
        switch (resp) {
            case 0:
                resp = 0;
                break;
            case 1: case 9: case 10:
                resp = 3;
                break;
            case 2: case 6: case 7: case 8:
                resp = 2;    
                break;
            case 3: case 4: case 5:
                resp = 1;
                break;
        }
        return resp;    }

    
}
