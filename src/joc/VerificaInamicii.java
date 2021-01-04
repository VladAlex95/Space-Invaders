/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joc;

import static joc.MyJFrame.inamici;
import static joc.MyJFrame.initInamici;

/**
 *
 * @author Alexandru
 */
public class VerificaInamicii  extends Thread{
      public void run(){
          while (true) {
               if (inamici.size() ==0)
                   initInamici();
              try{
                  sleep(500);
                  
              }catch (InterruptedException e){}
              for (Inamic i :inamici)
                  i.afisare();
          }
      }
}
