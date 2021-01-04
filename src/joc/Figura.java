package joc;

import static joc.MyJFrame.g;
import java.awt.Color;
import static joc.MyJFrame.R;
import static joc.MyJFrame.RG;
import static joc.MyJFrame.o;

public abstract class Figura {

    int x, y;
    Color c;
   
    boolean tintit = true;

    abstract void redimensionare(int xm, int ym);

     public Figura() {}

    public Figura(int x, int y, Color c) {
        this.x = x;
        this.y = y;
        this.c =c;
        c = Color.BLACK;
    }
    
    
    
     
    void Coloreaza(Color c) {
        this.c = c;
        afisare();
    }

    void deplaseaza(int xm, int ym) {
       synchronized(o) {
        stergere();
        demarcare();
        x = xm;
        y = ym;
        afisare();
        //marcare();
        }
   }
     void deplaseaza(int dx){
        deplaseaza(x + dx,y);
    }
    
    void afisare() {
        synchronized(o){
        g.setColor(c);
        desenare();
        }
    }

    void stergere() {
        synchronized(o) {
        g.setColor(Color.WHITE);
        desenare();
        }
    }

    abstract void desenare();

    void desenaremarcaj() {
        g.drawLine(x - 5, y, x + 5, y);
        g.drawLine(x, y - 5, x, y + 5);
    }

    void marcare() {
        g.setColor(c);
        desenaremarcaj();
    }

    void demarcare() {
        g.setColor(Color.white);
        desenaremarcaj();
    }

    boolean aproape(int xm, int ym) {
        int dist = R + RG + 5;
        return Math.abs(x - xm) <= dist && Math.abs(y - ym) <= dist;
    }
    boolean aproapeG(int xm,int ym){
     int dist = R+RG +3; 
     return Math.abs(x - xm) <= dist && Math.abs(y - ym) <= dist;
    }
    void finalizare() {}
     void micsoreaza(){}
    abstract boolean vizibil();
    abstract boolean interior(int xm,int ym);
 
}
