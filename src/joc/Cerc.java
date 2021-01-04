package joc;

import static joc.MyJFrame.g;
import java.awt.Color;
import static joc.MyJFrame.L;
import static joc.MyJFrame.o;

public class Cerc extends Figura {

    int R;

    void redimensionare(int xm, int ym) {
      synchronized (o){
        stergere();
        R = (int) Math.sqrt((x - xm) * (x - xm) + (y - ym) * (y - ym));
        afisare();
      }
    }

    public Cerc(int x, int y, int R, Color c) {
        super(x, y,c);
        this.R = R;
    }

    void desenare() {
        g.drawOval(x - R, y - R, 2 * R, 2 * R);

    }
    void micsoreaza(){
       stergere();
        R--;
        afisare();
        
    }
    boolean vizibil(){
        return R>5;
    }
    void coordonate(){
        System.out.println("x ="+x +", y =" +y);
    }
    
    boolean interior(int xm, int ym){
           return Math.sqrt((xm-x)*(xm-x)+(ym-y)*(ym-y)) <R;
                   
    }
    boolean laMargine(){
        return  x<R || x>=L-R;
    }
    /*
    boolean aproape (Cerc c) {
        return Math.abs(x-c.x) < R+5 && Math.abs(y-c.y) < R+5;
    }
    */
}
