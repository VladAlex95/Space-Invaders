/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joc;

import static joc.MyJFrame.g;
import java.awt.Color;
import static joc.MyJFrame.o;

/**
 *
 * @author Alexandru
 */
public class Dreptunghi extends Figura {

    int l, h;

    void redimensionare(int xm, int ym) {
       synchronized(o){
        stergere();
        l = 2 * Math.abs(x - xm);
        h = 2 * Math.abs(y - ym);
        afisare();
       }
    }

    public Dreptunghi(int x, int y, int l, int h, Color c) {
        super(x, y,c);
        this.l = l;
        this.h = h;
      
    }

    void desenare() {
        g.drawRect(x - l / 2, y - h / 2, l, h);
    }
    
    void micsoreaza(){
        stergere();
        l--;
        h--;
        afisare();
    }
    boolean vizibil(){
        return l*h >5;
    }
     void coordonate(){
            System.out.println("x ="+x +", y =" +y);
     }
    
    boolean interior(int xm, int ym){
        return Math.abs(x-xm) <l/2 && Math.abs(y - ym) <h/2;
    }
}
