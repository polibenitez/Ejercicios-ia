/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.util.LinkedHashSet;
import java.util.Set;

import aima.core.agent.Action;
import aima.core.search.framework.ActionsFunction;
import aima.core.search.framework.ResultFunction;
/**
 *
 * @author zadik
 */
public class HorseFunctionFactory {
    private static ActionsFunction _actionsFunction = null;
	private static ResultFunction _resultFunction = null;

	public static ActionsFunction getActionsFunction() {
		if (null == _actionsFunction) {
			_actionsFunction = new HorseActionsFunction();
		}
		return _actionsFunction;
	}

	public static ResultFunction getResultFunction() {
		if (null == _resultFunction) {
			_resultFunction = new HorseResultFunction();
		}
		return _resultFunction;
	}
        private static class HorseActionsFunction implements ActionsFunction {
		public Set<Action> actions(Object state) {
			ModificatedBoard board = (ModificatedBoard) state;

			Set<Action> actions = new LinkedHashSet<Action>();

                        if(board.canMove(ModificatedBoard.M1D2AB))
                            actions.add(ModificatedBoard.M1D2AB);
                        if(board.canMove(ModificatedBoard.M1D2AR))
                            actions.add(ModificatedBoard.M1D2AR);
                        if(board.canMove(ModificatedBoard.M1I2AB))
                            actions.add(ModificatedBoard.M1I2AB);
                        if(board.canMove(ModificatedBoard.M1I2AR))
                            actions.add(ModificatedBoard.M1I2AR);
                        if(board.canMove(ModificatedBoard.M2D1AB))
                            actions.add(ModificatedBoard.M2D1AB);
                        if(board.canMove(ModificatedBoard.M2D1AR))
                            actions.add(ModificatedBoard.M2D1AR);
                        if(board.canMove(ModificatedBoard.M2I1AB))
                            actions.add(ModificatedBoard.M2I1AB);
                        if(board.canMove(ModificatedBoard.M2I1AR))
                            actions.add(ModificatedBoard.M2I1AR);
			return actions;
		}
	}

	private static class HorseResultFunction implements ResultFunction {
		public Object result(Object s, Action a) {
			ModificatedBoard board = (ModificatedBoard) s;
                        
                        if(ModificatedBoard.M1D2AB.equals(a)
                                && board.canMove(ModificatedBoard.M1D2AB)){
                            ModificatedBoard newBoard = new ModificatedBoard(board);
                            newBoard.mueveM1D2AB();
                            return newBoard;
                        } else if(ModificatedBoard.M1D2AR.equals(a)
                                && board.canMove(ModificatedBoard.M1D2AR)){
                            ModificatedBoard newBoard = new ModificatedBoard(board);
                            newBoard.mueveM1D2AR();
                            return newBoard;
                        } else if(ModificatedBoard.M1I2AB.equals(a)
                                && board.canMove(ModificatedBoard.M1I2AB)){
                            ModificatedBoard newBoard = new ModificatedBoard(board);
                            newBoard.mueveM1I2AB();
                            return newBoard;
                        } else if(ModificatedBoard.M1I2AR.equals(a)
                                && board.canMove(ModificatedBoard.M1I2AR)){
                            ModificatedBoard newBoard = new ModificatedBoard(board);
                            newBoard.mueveM1I2AR();
                            return newBoard;
                        }  else if(ModificatedBoard.M2D1AB.equals(a)
                                && board.canMove(ModificatedBoard.M2D1AB)){
                            ModificatedBoard newBoard = new ModificatedBoard(board);
                            newBoard.mueveM2D1AB();
                            return newBoard;
                        }  else if(ModificatedBoard.M2D1AR.equals(a)
                                && board.canMove(ModificatedBoard.M2D1AR)){
                            ModificatedBoard newBoard = new ModificatedBoard(board);
                            newBoard.mueveM2D1AR();
                            return newBoard;
                        }  else if(ModificatedBoard.M2I1AB.equals(a)
                                && board.canMove(ModificatedBoard.M2I1AB)){
                            ModificatedBoard newBoard = new ModificatedBoard(board);
                            newBoard.mueveM2I1AB();
                            return newBoard;
                        }  else if(ModificatedBoard.M2I1AR.equals(a)
                                && board.canMove(ModificatedBoard.M2I1AR)){
                            ModificatedBoard newBoard = new ModificatedBoard(board);
                            newBoard.mueveM2I1AR();
                            return newBoard;
                        }
                        else{
                            System.out.println("No es ninguna");
                        }
			return s;
		}
	}
}
