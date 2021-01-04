/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joc;

import java.awt.Color;
import static joc.MyJFrame.H;
import static joc.MyJFrame.RG;
import static joc.MyJFrame.gloanteTun;
import static joc.MyJFrame.inamici;
import static joc.MyJFrame.jTextFieldPunctaj;
import static joc.MyJFrame.o;
import static joc.MyJFrame.punctaj;

/**
 *
 * @author Alexandru
 */
public class FirGlontTun  extends Thread{
    Cerc glont;
    int directie;
  
    FirGlontTun(int x, int y, Color c,int directie)
    {
       glont  = new Cerc (x,y,RG,c);
       this.directie = directie;
    }
    public void run(){
        while (glont.x > -5 &&glont.y < H +5){
            glont.deplaseaza(glont.x, glont.y + directie);
            if (glont.y < 0 || glont.y  > H){ //daca iesin afara le sterg
                glont.stergere();
              return;
        }
            synchronized(o){
                for (Inamic i :inamici){
                    if (i.aproape(glont.x, glont.y)){
                       i.inchide();
                   // if (!i.tintit){ // sa nu incrementam
                        punctaj++;
                        jTextFieldPunctaj.setText(punctaj +"");
                    
                    glont.stergere();
                    gloanteTun.remove(this);
                    return;
                    //i.stop();
                  //  inamici.remove(i);
                    //break;
                    
                }
            }
    }
        try{
            sleep(5);
        }catch (InterruptedException e){}
    
    }
        
    }
}
