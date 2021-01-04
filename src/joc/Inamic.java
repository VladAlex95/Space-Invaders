/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joc;

import java.awt.Color;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import static joc.MyJFrame.R;
import static joc.MyJFrame.RG;
import static joc.MyJFrame.gloanteInamic;

import static joc.MyJFrame.inamici;
import static joc.MyJFrame.jButton1;
import static joc.MyJFrame.o;
import static joc.MyJFrame.tun;

/**
 *
 * @author Alexandru
 */
public class Inamic  extends Thread{
    
    boolean tintit;
     Vector<Cerc> cercuri;
     public static final int NRC =4;

     boolean deplaseaza(int dx){
         synchronized(o){
             for (Cerc c:cercuri)
                 c.deplaseaza(dx);
            if (cercuri.size() > 0)
                return cercuri.get(0).laMargine();
            else
                 return false;
         }
     }
    public Inamic (int x,int  y){
        cercuri = new Vector();
        for (int i=0;i<NRC;i++){
            cercuri.add(new Cerc(x,y,R,Color.BLUE));
            y+=2*R +3;
        }
        afisare();
        tintit = false;
    }
    void afisare(){
        for (Cerc c:cercuri)
            c.afisare();
    }
    void inchide(){
        synchronized(o){
          Cerc c = cercuri.get(cercuri.size()-1);
          c.stergere();
          tintit = true;
          cercuri.remove(cercuri.size()-1);
        
        }
    }
    boolean aproape(int x, int y){
        if (cercuri.size() == 0)
        return false;
            Cerc c = cercuri.get(cercuri.size()-1);
        return c.aproape(x, y);       
    }
    void stergeTot(){
        for (Cerc c:cercuri)
            c.stergere();
    }
    
    public void run(){
        while (true){
            try{
                sleep(1000 +(int)(Math.random()*5000));
            }catch (InterruptedException ex){
            Logger.getLogger(Inamic.class.getName()).log(Level.SEVERE,null,ex);
            }
            synchronized(o){
                if (cercuri.size() ==0){
                    inamici.remove(this);
                    return;
                }
            }
            Cerc c = cercuri.get(cercuri.size() -1);
            FirGlontInamic  fg = new FirGlontInamic(c.x,c.y+R+RG+3,Color.blue,1);
            fg.start();
            synchronized(o){
                gloanteInamic.add(fg);
            }
        }
    }
}
