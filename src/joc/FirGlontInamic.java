/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joc;

import java.awt.Color;
import static joc.MyJFrame.H;
import static joc.MyJFrame.RG;
import static joc.MyJFrame.fvi;
import static joc.MyJFrame.gloanteInamic;
import static joc.MyJFrame.gloanteTun;

import static joc.MyJFrame.inamici;
import static joc.MyJFrame.jButton1;
import static joc.MyJFrame.o;
import static joc.MyJFrame.tun;

/**
 *
 * @author Alexandru
 */
public class FirGlontInamic extends Thread {
    Cerc glont;
    int directie;
   
    FirGlontInamic(int x, int y,Color c,int directie)
    {
        glont = new Cerc(x,y,RG,c);
        this.directie = directie;
    }
    public void run(){
        while (glont.x> -5 && glont.y < H+5){
           glont.deplaseaza(glont.x,glont.y + directie);
           synchronized(o){
               cauta: for (int i=0;i<gloanteInamic.size();i++)
                        for (int j =0;j<gloanteTun.size();j++){
                         FirGlontInamic  fgi = gloanteInamic.get(i);
                         FirGlontTun fgt = gloanteTun.get(j);
                         Cerc ci = fgi.glont;
                         Cerc ct = fgt.glont;
                         if (ci.aproapeG(ct.x,ct.y)){
                             fgi.stop();
                             fgt.stop();
                             ci.stergere();
                             ct.stergere();
                             gloanteInamic.remove(i);
                             gloanteTun.remove(j);
                             break cauta;
                           }
                        }
             }
           if (glont.y < 0 || glont.y >H){//daca ies in afara
               glont.stergere();
               return;
               
           }
           if (directie ==1 && tun != null){//glont de la inamic
               
               if (tun.aproape(glont.x,glont.y)){
                   synchronized(o){
                       tun.stergere();
                       tun =null;
                       fvi.stop();
                       for (Inamic i:inamici){
                           i.stergeTot();
                           i.stop();
                       }
                       for (FirGlontInamic fgi:gloanteInamic){
                           fgi.glont.stergere();
                       fgi.stop();
                   }
                       
               }
                   jButton1.setEnabled(true);
                   return;
           }
               else
                   tun.afisare();
           
           
        }
           try{
               sleep(5);
           }catch (InterruptedException e){}
    }
    }
    
}
