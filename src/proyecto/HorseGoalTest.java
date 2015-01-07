/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;
import aima.core.search.framework.GoalTest;
/**
 *
 * @author zadik
 */
public class HorseGoalTest implements GoalTest{
    ModificatedBoard goal = new ModificatedBoard(1,2);

	public boolean isGoalState(Object state) {
		ModificatedBoard board = (ModificatedBoard) state;
		return board.equals(goal);
	}
}
