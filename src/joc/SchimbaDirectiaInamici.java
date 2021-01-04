/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joc;

import java.util.Random;
import static joc.MutaInamicii.directie;

/**
 *
 * @author Alexandru
 */
public class SchimbaDirectiaInamici extends Thread {
    public static final int MIN =1,MAX =5;
    Random rand = new Random();
    public void run(){
        while (true){
            try{
            sleep(rand.nextInt((MAX-MIN +1)+MIN)*1000);
        }catch (InterruptedException e){}
            directie = -directie;
       }
    }
}
