/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aima.core.environment.ajedrez;

import aima.core.search.framework.GoalTest;

/**
 *
 * @author Edwin Mauricio Quishpe
 */
public class AjedrezGoalTest implements GoalTest{
    AjedrezBoard objetivo = new AjedrezBoard(1, 2); //objetivo que queremos alcanzar
    @Override
    public boolean isGoalState(Object o) {
        AjedrezBoard board = (AjedrezBoard) o;
		return board.equals(objetivo);
    }
    
}
