/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import aima.core.agent.Action;
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
 * @author zadik
 */
public class HorseDemo {
    static ModificatedBoard boardInicial = new ModificatedBoard(4,2);

    public static void main(String[] args) {
        HorseBreadthDemo();
        HorseDepthGraphDemo();
        Horseheuristica1();
        Horseheuristica2();
    }

    private static void HorseBreadthDemo() {
        System.out.println("\nbusqueda en anchura -->");
        try {
            Problem problem = new Problem(boardInicial, HorseFunctionFactory.getActionsFunction(), HorseFunctionFactory.getResultFunction(), new HorseGoalTest());
            Search search = new BreadthFirstSearch();
            SearchAgent agent = new SearchAgent(problem, search);
            printActions(agent.getActions());
            printInstrumentation(agent.getInstrumentation());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void HorseDepthGraphDemo() {
        System.out.println("\nbusqueda en profundidad -->");
        try {
            Problem problem = new Problem(boardInicial, HorseFunctionFactory.getActionsFunction(), HorseFunctionFactory.getResultFunction(), new HorseGoalTest());
            Search search = new DepthFirstSearch(new GraphSearch());
            SearchAgent agent = new SearchAgent(problem, search);
            printActions(agent.getActions());
            printInstrumentation(agent.getInstrumentation());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private static void Horseheuristica1() {
        System.out.println("\n Funcion heuristica 1 -->");
        try {
            Problem problem = new Problem(boardInicial, HorseFunctionFactory.getActionsFunction(), HorseFunctionFactory.getResultFunction(), new HorseGoalTest());
            Search search = new AStarSearch(new GraphSearch(), new Horseheuristica1());
            SearchAgent agent = new SearchAgent(problem, search);
            printActions(agent.getActions());
            printInstrumentation(agent.getInstrumentation());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private static void Horseheuristica2() {
        System.out.println("\nFuncion heuristica 2-->");
        try {
            Problem problem = new Problem(boardInicial, HorseFunctionFactory.getActionsFunction(), HorseFunctionFactory.getResultFunction(), new HorseGoalTest());
            Search search = new AStarSearch(new GraphSearch(), new Horseheuristica2());
            SearchAgent agent = new SearchAgent(problem, search);
            printActions(agent.getActions());
            printInstrumentation(agent.getInstrumentation());
        } catch (Exception e) {
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
