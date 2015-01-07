/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aima.core.environment.ajedrez;

/**
 *
 * @author Edwin Mauricio Quishpe
 */

    

import java.util.LinkedHashSet;
import java.util.Set;

import aima.core.agent.Action;
import aima.core.search.framework.ActionsFunction;
import aima.core.search.framework.ResultFunction;

/**
 * @author Ravi Mohan
 * @author Ciaran O'Reilly
 */
public class AjedrezFunctionFactory {
	private static ActionsFunction _actionsFunction = null;
	private static ResultFunction _resultFunction = null;

	public static ActionsFunction getActionsFunction() {
		if (null == _actionsFunction) {
			_actionsFunction = new LabActionsFunction();
		}
		return _actionsFunction;
	}

	public static ResultFunction getResultFunction() {
		if (null == _resultFunction) {
			_resultFunction = new LabResultFunction();
		}
		return _resultFunction;
	}

	private static class LabActionsFunction implements ActionsFunction {
		public Set<Action> actions(Object state) {
			AjedrezBoard board = (AjedrezBoard) state;

			Set<Action> actions = new LinkedHashSet<Action>();

                        if(board.movimientoPosible(AjedrezBoard.M1D2AB))
                            actions.add(AjedrezBoard.M1D2AB);
                        if(board.movimientoPosible(AjedrezBoard.M1D2AR))
                            actions.add(AjedrezBoard.M1D2AR);
                        if(board.movimientoPosible(AjedrezBoard.M1I2AB))
                            actions.add(AjedrezBoard.M1I2AB);
                        if(board.movimientoPosible(AjedrezBoard.M1I2AR))
                            actions.add(AjedrezBoard.M1I2AR);
                        if(board.movimientoPosible(AjedrezBoard.M2D1AB))
                            actions.add(AjedrezBoard.M2D1AB);
                        if(board.movimientoPosible(AjedrezBoard.M2D1AR))
                            actions.add(AjedrezBoard.M2D1AR);
                        if(board.movimientoPosible(AjedrezBoard.M2I1AB))
                            actions.add(AjedrezBoard.M2I1AB);
                        if(board.movimientoPosible(AjedrezBoard.M2I1AR))
                            actions.add(AjedrezBoard.M2I1AR);
			return actions;
		}
	}

	private static class LabResultFunction implements ResultFunction {
		public Object result(Object s, Action a) {
			AjedrezBoard board = (AjedrezBoard) s;
                        
                        if(AjedrezBoard.M1D2AB.equals(a)
                                && board.movimientoPosible(AjedrezBoard.M1D2AB)){
                            AjedrezBoard newBoard = new AjedrezBoard(board);
                            newBoard.mueveM1D2AB();
                            return newBoard;
                        } else if(AjedrezBoard.M1D2AR.equals(a)
                                && board.movimientoPosible(AjedrezBoard.M1D2AR)){
                            AjedrezBoard newBoard = new AjedrezBoard(board);
                            newBoard.mueveM1D2AR();
                            return newBoard;
                        } else if(AjedrezBoard.M1I2AB.equals(a)
                                && board.movimientoPosible(AjedrezBoard.M1I2AB)){
                            AjedrezBoard newBoard = new AjedrezBoard(board);
                            newBoard.mueveM1I2AB();
                            return newBoard;
                        } else if(AjedrezBoard.M1I2AR.equals(a)
                                && board.movimientoPosible(AjedrezBoard.M1I2AR)){
                            AjedrezBoard newBoard = new AjedrezBoard(board);
                            newBoard.mueveM1I2AR();
                            return newBoard;
                        }  else if(AjedrezBoard.M2D1AB.equals(a)
                                && board.movimientoPosible(AjedrezBoard.M2D1AB)){
                            AjedrezBoard newBoard = new AjedrezBoard(board);
                            newBoard.mueveM2D1AB();
                            return newBoard;
                        }  else if(AjedrezBoard.M2D1AR.equals(a)
                                && board.movimientoPosible(AjedrezBoard.M2D1AR)){
                            AjedrezBoard newBoard = new AjedrezBoard(board);
                            newBoard.mueveM2D1AR();
                            return newBoard;
                        }  else if(AjedrezBoard.M2I1AB.equals(a)
                                && board.movimientoPosible(AjedrezBoard.M2I1AB)){
                            AjedrezBoard newBoard = new AjedrezBoard(board);
                            newBoard.mueveM2I1AB();
                            return newBoard;
                        }  else if(AjedrezBoard.M2I1AR.equals(a)
                                && board.movimientoPosible(AjedrezBoard.M2I1AR)){
                            AjedrezBoard newBoard = new AjedrezBoard(board);
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