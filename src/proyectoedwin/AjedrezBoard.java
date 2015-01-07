/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aima.core.environment.ajedrez;

import aima.core.agent.Action;
import aima.core.agent.impl.DynamicAction;

/**
 *
 * @author Edwin Mauricio Quishpe
 */
public class AjedrezBoard {
    /*Primero definimos las acciones que se pueden realizar
    Luego hay que programar cuando NO es permitido realizar estas acciones
    es decir que debemos localizar los puntos en los que no se puede hacer
    un movimiento, por lo general en los limites del tablero y hay que tomar 
    en cuenta el casillero que no es posible usar
    */
    public static Action M1D2AR = new DynamicAction("1D2AR");
    public static Action M2D1AR = new DynamicAction("2D1AR");
    public static Action M2D1AB = new DynamicAction("2D1AB");
    public static Action M1D2AB = new DynamicAction("1D2AB");
    public static Action M1I2AB = new DynamicAction("1I2AB");
    public static Action M2I1AB = new DynamicAction("2I1AB");
    public static Action M2I1AR = new DynamicAction("2I1AR");
    public static Action M1I2AR = new DynamicAction("1I2AR");
   
    private int fila;
    private int columna;
    private static int TAM=5;
    
    //Defino el contructor con el estado inicial del tablero
    public AjedrezBoard(){
        this.fila = 4;
        this.columna = 4;
    }
    
    //contructor con los parametros
    public AjedrezBoard(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }
    
    //controcutor con un objeto de esta misma clase
    
    public AjedrezBoard(AjedrezBoard copia) {
        this(copia.getFila(), copia.getColumna());
    }

    //redefinimos geter y seter de filas y columnas
    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }
    
    
    //Hacemos los movimientos
    //M1D2AR movimiento tipo 1
    public void mueveM1D2AR(){
        //this.fila += 1;
        //this.columna -= 2;         
        this.fila -= 2;
        this.columna += 1;
    }
    
    //M2D1AR movimiento tipo 2
    public void mueveM2D1AR(){
        this.fila -= 1;
        this.columna += 2;         
    }

    //M2D1AB movimiento tipo 3
    public void mueveM2D1AB(){
        this.fila += 1;
        this.columna += 2;
    }
    //M1D2AB movimiento tipo 4
    public void mueveM1D2AB(){
        this.fila += 2 ;
        this.columna += 1;
    }
    //M1I2AB movimiento tipo 5
    public void mueveM1I2AB(){
        this.fila += 2;
        this.columna -= 1;
    }
    //M2I1AB movimiento tipo 6
    public void mueveM2I1AB(){
        this.fila += 1;
        this.columna -= 2;
    }
    //M2I1AR movimiento tipo 7
    public void mueveM2I1AR(){
        this.fila -= 1;
        this.columna -= 2;
    }
    //M1I2AR movimiento tipo 8
    public void mueveM1I2AR(){
        this.fila -= 2;
        this.columna -= 1;
    }
    
    public boolean movimientoPosible(Action a){
        boolean resp=true;
        boolean casi=false; //casilla que restringe el problema 0/4
        
        //movimiento que se pueden hacer con el caballo
        if(a.equals(M1D2AR)){           //movimiento tipo1
            resp = (getColumna() + 1 < TAM) && (getFila() - 2 > -1 );
            casi = (getColumna() + 1 == 4 ) && (getFila() - 2 == 0 );
        } else if(a.equals(M2D1AR)){    //movimiento tipo 2
            resp = (getColumna() + 2 < TAM) && (getFila() - 1 > -1 );
            casi = (getColumna() + 2 == 4 ) && (getFila() - 1 == 0 );
        } else if(a.equals(M2D1AB)){    //movimiento tipo 3
            resp = (getColumna() + 2 < TAM) && (getFila() + 1 < TAM);
            casi = (getColumna() + 2 == 4 ) && (getFila() + 1 == 0);
        } else if(a.equals(M1D2AB)){    //movimiento tipo 4
            resp = (getColumna() + 1 < TAM) && (getFila() + 2 < TAM);
            casi = (getColumna() + 1 == 4 ) && (getFila() + 2 == 0 );
        } else if(a.equals(M1I2AB)){    //movimiento tipo 5
            resp = (getColumna() - 1 > -1 ) && (getFila() + 2 < TAM);
            casi = (getColumna() - 1 == 4 ) && (getFila() + 2 == 0 );
        } else if(a.equals(M2I1AB)){    //movimiento tipo 6
            resp = (getColumna() - 2 > -1 ) && (getFila() + 1 < TAM);
            casi = (getColumna() - 2 == 4 ) && (getFila() + 1 == 0 );
        } else if(a.equals(M2I1AR)){    //movimiento tipo 7
            resp = (getColumna() - 2 > -1 ) && (getFila() - 1 > -1 );
            casi = (getColumna() - 2 == 4 ) && (getFila() - 1 == 0 );
        } else if(a.equals(M1I2AR)){    //movimiento tipo 8
            resp = (getColumna() - 1 > -1 ) && (getFila() - 2 > -1 );
            casi = (getColumna() - 1 == 4 ) && (getFila() - 2 == 0 );
        }
        
        if(casi){ // restringe la casilla del problema
            resp=false;
            System.out.println("Mueve falso " + a.toString());
        }
        
        return resp;
    }
    
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AjedrezBoard other = (AjedrezBoard) obj;
        if (this.fila != other.fila) {
            return false;
        }
        if (this.columna != other.columna) {
            return false;
        }
        return true;
    }
    
     @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + this.fila;
        hash = 31 * hash + this.columna;
        return hash;
    }

    @Override
    public String toString() {
        return "AjedrezBoard{" + "fila=" + fila + ", columna=" + columna + '}';
    }    
    
    public int tamTablero(){
        return TAM;
    }
}
