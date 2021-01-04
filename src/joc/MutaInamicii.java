/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joc;

import static joc.MyJFrame.inamici;
import static joc.MyJFrame.o;

/**
 *
 * @author Alexandru
 */
public class MutaInamicii extends Thread {
    static  int directie =1;
    boolean laMargine =false;
    public void run(){
        while (true){
            synchronized(o){
                for (Inamic i:inamici)
                    if (i.deplaseaza(directie))
                        laMargine = true;
            }
            if (laMargine){
                directie = -directie;
                laMargine = false;
            }
            try{
                sleep(20);
            }
            catch (InterruptedException e){}
        }
    }
        
}
