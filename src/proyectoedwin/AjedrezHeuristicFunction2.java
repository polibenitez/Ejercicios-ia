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
public class AjedrezHeuristicFunction2 implements HeuristicFunction{
    private static final int g1 = 1;
    private static final int g2 = 2;
    
    public double h(Object state) {
        AjedrezBoard board = (AjedrezBoard) state;
        int n1 = board.getFila();
        int n2 = board.getColumna();
        return CalcularHeuristica(n1, n2);
    }
    private double CalcularHeuristica(int n1, int n2){
        int resp = Math.abs(n1 - g1) + Math.abs(n2 + g2);
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
        return resp;
    }
     
    /*
    public double h(Object state) {
        //AjedrezBoard board = (AjedrezBoard) state;
        //int tam = board.tamTablero();
        int tam =5;
        int resp=0;
        //int n1 = board.getFila();
        //int n2 = board.getColumna();
        for(int i=0;i<tam;i++){
            for (int j = 0; j < tam; j++) {
                //resp += CalcularHeuristica(i, j);
                System.out.println(CalcularHeuristica(i, j));
            }
        }
        
        return resp;
        //return CalcularHeuristica(board.getFila(), board.getColumna());
    }
    
    private double CalcularHeuristica(int n1, int n2){
        double resp =1;
        
        //aqui debo calcular el valor absoluto de todas las posibliidades que se den al expandir un nodo
        return Math.abs(n1 - g1) + Math.abs(n2 + g2);
    }
    
    public static void main(String[] args) {
           AjedrezHeuristicFunction1 state = new AjedrezHeuristicFunction1();
           state.h(new Object());
    }*/
}
