/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joc;


import static joc.MyJFrame.autorepeat;
import static joc.MyJFrame.jSlider1;
import static joc.MyJFrame.o;

/**
 *
 * @author Alexandru
 */
public class FirTaste extends Thread {
    int  directie;
    Figura f;

    public FirTaste(int directie, Figura f) {
        this.directie = directie;
        this.f = f;
        autorepeat = true;
    }
    
    public void run() {
        while (autorepeat){
           synchronized(o){
            if (f==null)
                return;
        }
            f.deplaseaza(f.x +directie, f.y);
            try {
                sleep(jSlider1.getValue()/10+2);
            }catch(InterruptedException e){}
        }
    }
}
