/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aima.gui.demo.search;

import aima.core.agent.Action;
import aima.core.environment.ajedrez.AjedrezBoard;
import aima.core.environment.ajedrez.AjedrezFunctionFactory;
import aima.core.environment.ajedrez.AjedrezGoalTest;
import aima.core.environment.ajedrez.AjedrezHeuristicFunction1;
import aima.core.environment.ajedrez.AjedrezHeuristicFunction2;
import aima.core.search.framework.GraphSearch;
import aima.core.search.framework.Problem;
import aima.core.search.framework.Search;
import aima.core.search.framework.SearchAgent;
import aima.core.search.informed.AStarSearch;
import aima.core.search.uninformed.BreadthFirstSearch;
import aima.core.search.uninformed.DepthFirstSearch;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author Edwin Mauricio Quishpe
 */
public class AjedrezDemo {

    static AjedrezBoard boardInicial = new AjedrezBoard(4,2);

    public static void main(String[] args) {
        primeroPorAnchura();
        primeroPorProfundidad();
        AEstrellaH1();
        AEstrellaH2();
    }

    private static void primeroPorAnchura() {
        System.out.println("\nAjedrez busqueda primero por ANCHURA -->");
        try {
            Problem problem = new Problem(boardInicial, AjedrezFunctionFactory.getActionsFunction(), AjedrezFunctionFactory.getResultFunction(), new AjedrezGoalTest());
           
            Search search = new BreadthFirstSearch();
            SearchAgent agent = new SearchAgent(problem, search);
            printActions(agent.getActions());
            printInstrumentation(agent.getInstrumentation());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void primeroPorProfundidad() {
        System.out.println("\nAjedrez busqueda primero por PROFUNDIDAD -->");
        try {
            Problem problem = new Problem(boardInicial, AjedrezFunctionFactory.getActionsFunction(), AjedrezFunctionFactory.getResultFunction(), new AjedrezGoalTest());
            Search search = new DepthFirstSearch(new GraphSearch());
            SearchAgent agent = new SearchAgent(problem, search);
            //System.out.println("Entra aqui");
            printActions(agent.getActions());
            printInstrumentation(agent.getInstrumentation());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    private static void AEstrellaH1(){
        System.out.println("\nAjedrez Busqueda A* con heuristica 1");
        try{
            Problem problema = new Problem(
                                            boardInicial,
                                            AjedrezFunctionFactory.getActionsFunction(),
                                            AjedrezFunctionFactory.getResultFunction(),
                                            new AjedrezGoalTest()
                                            );
            Search search = new AStarSearch(new GraphSearch(), new AjedrezHeuristicFunction1());
            SearchAgent agent = new SearchAgent(problema, search);
			printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
     private static void AEstrellaH2(){
        System.out.println("\nAjedrez Busqueda A* con heuristica 2");
        try{
            Problem problema = new Problem(
                                            boardInicial,
                                            AjedrezFunctionFactory.getActionsFunction(),
                                            AjedrezFunctionFactory.getResultFunction(),
                                            new AjedrezGoalTest()
                                            );
            Search search = new AStarSearch(new GraphSearch(), new AjedrezHeuristicFunction2());
            SearchAgent agent = new SearchAgent(problema, search);
			printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void printInstrumentation(Properties properties) {
        Iterator<Object> keys = properties.keySet().iterator();
        while (keys.hasNext()) {
            String key = (String) keys.next();
            String property = properties.getProperty(key);
            System.out.println(key + " : " + property);
        }

    }

    private static void printActions(List<Action> actions) {
        for (int i = 0; i < actions.size(); i++) {
            String action = actions.get(i).toString();
            System.out.println(action);
        }
    }
}
