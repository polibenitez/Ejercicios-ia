/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import aima.core.agent.Action;
import aima.core.agent.impl.DynamicAction;


/**
 *
 * @author zadik
 */
public class ModificatedBoard {
    public static Action M1D2AR = new DynamicAction("1D2AR");
    public static Action M2D1AR = new DynamicAction("2D1AR");
    public static Action M2D1AB = new DynamicAction("2D1AB");
    public static Action M1D2AB = new DynamicAction("1D2AB");
    public static Action M1I2AB = new DynamicAction("1I2AB");
    public static Action M2I1AB = new DynamicAction("2I1AB");
    public static Action M2I1AR = new DynamicAction("2I1AR");
    public static Action M1I2AR = new DynamicAction("1I2AR");
    
    private int row;
    private int column;
    private int TAM=5;
    
//    private static char state[][] = 
//       {{'O', 'O', 'O', 'O', 'X'},
//        {'O', 'O', 'O', 'O', 'O'},
//        {'O', 'O', 'O', 'O', 'O'},
//        {'O', 'O', 'O', 'O', 'O'},
//        {'O', 'O', 'O', 'O', 'O'}};
    
    public ModificatedBoard() {
        this.row = 4;
        this.column = 4;
    }
    public ModificatedBoard(int row,int column) {
        this.row = row;
        this.column = column;
    }
    public ModificatedBoard(ModificatedBoard a) {
//        this.row = a.getRow();
//        this.column = a.getColumn();
        this(a.getRow(),a.getColumn());
    }
    
    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }
    

    //Hacemos los movimientos
    //M1D2AR movimiento tipo 1
    public void mueveM1D2AR(){
        //this.row += 1;
        //this.column -= 2;         
        this.row -= 2;
        this.column += 1;
    }
    
    //M2D1AR movimiento tipo 2
    public void mueveM2D1AR(){
        this.row -= 1;
        this.column += 2;         
    }

    //M2D1AB movimiento tipo 3
    public void mueveM2D1AB(){
        this.row += 1;
        this.column += 2;
    }
    //M1D2AB movimiento tipo 4
    public void mueveM1D2AB(){
        this.row += 2 ;
        this.column += 1;
    }
    //M1I2AB movimiento tipo 5
    public void mueveM1I2AB(){
        this.row += 2;
        this.column -= 1;
    }
    //M2I1AB movimiento tipo 6
    public void mueveM2I1AB(){
        this.row += 1;
        this.column -= 2;
    }
    //M2I1AR movimiento tipo 7
    public void mueveM2I1AR(){
        this.row -= 1;
        this.column -= 2;
    }
    //M1I2AR movimiento tipo 8
    public void mueveM1I2AR(){
        this.row -= 2;
        this.column -= 1;
    }
    public boolean canMove(Action a){
        boolean resp=true;
        boolean casillaprohibida=false; 
        //System.out.println("movimiento posible nos pasa: "+ a.toString());
        //movimientos que se pueden hacer con el caballo
       
        if(a.equals(M1D2AR)){
            resp = (getColumn() + 1 < TAM) && (getRow() - 2 > -1 );
            casillaprohibida = (getColumn() + 1 == 4 ) && (getRow() - 2 == 0 );
        } else if(a.equals(M2D1AR)){
            resp = (getColumn() + 2 < TAM) && (getRow() - 1 > -1 );
            casillaprohibida = (getColumn() + 2 == 4 ) && (getRow() - 1 == 0 );
        } else if(a.equals(M2D1AB)){
            resp = (getColumn() + 2 < TAM) && (getRow() + 1 < TAM);
            casillaprohibida = (getColumn() + 2 == 4 ) && (getRow() + 1 == 0);
        } else if(a.equals(M1D2AB)){
            resp = (getColumn() + 1 < TAM) && (getRow() + 2 < TAM);
            casillaprohibida = (getColumn() + 1 == 4 ) && (getRow() + 2 == 0 );
        } else if(a.equals(M1I2AB)){
            resp = (getColumn() - 1 > -1 ) && (getRow() + 2 < TAM);
            casillaprohibida = (getColumn() - 1 == 4 ) && (getRow() + 2 == 0 );
        } else if(a.equals(M2I1AB)){
            resp = (getColumn() - 2 > -1 ) && (getRow() + 1 < TAM);
            casillaprohibida = (getColumn() - 2 == 4 ) && (getRow() + 1 == 0 );
        } else if(a.equals(M2I1AR)){
            resp = (getColumn() - 2 > -1 ) && (getRow() - 1 > -1 );
            casillaprohibida = (getColumn() - 2 == 4 ) && (getRow() - 1 == 0 );
        } else if(a.equals(M1I2AR)){
            resp = (getColumn() - 1 > -1 ) && (getRow() - 2 > -1 );
            casillaprohibida = (getColumn() - 1 == 4 ) && (getRow() - 2 == 0 );
        }
        
        if(casillaprohibida){ // restrinción de la casilla del problema
            resp=false;
            System.out.println("Mueve falso " + a.toString());
        }
        
        return resp;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ModificatedBoard other = (ModificatedBoard) obj;
        if (this.row != other.row) {
            return false;
        }
        if (this.column != other.column) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + this.row;
        hash = 31 * hash + this.column;
        return hash;
    }

    @Override
    public String toString() {
        return "ModificateBoard{" + "row=" + row + ", column=" + column + '}';
    }    
}
