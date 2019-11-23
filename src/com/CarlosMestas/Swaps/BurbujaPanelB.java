package com.CarlosMestas.Swaps;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

/**
 * @author Carlos Alberto Mestas Escarcena
 */
public class BurbujaPanelB extends JPanel implements Runnable{
    
    Thread thread;
    
    private int NUM_BOX                 =       BurbujaFrm.cantNumbers;
    private Dimension dimension         =       new Dimension(500,128);    
    private BoxNumber[] bNumber;
    
    /**
     * Constructor de clase
     */
    public BurbujaPanelB(){
        setSize(dimension);
        setVisible(true);                
    }
    
    @Override
    public void paintComponent(Graphics g){    
        Graphics2D g2 =(Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);    
        g2.setColor( new Color(255,255,255) );
        g2.fill(new Rectangle2D.Double(0,0,getWidth(),getHeight()));                 
        //pinta numeros y casillas
        if(bNumber!=null)
        for(BoxNumber b:bNumber){
            b.draw(g2);
        }
        
    }
    
    public void generar3(BoxNumber[] array){
        bNumber = array;
    //    System.out.println("\nZZZZZ");
        for(int i = 0;i < NUM_BOX;i++){
    //        System.out.println(i);               
            bNumber[i].x = 10;
            bNumber[i].y = 10 + bNumber[i].HEIGHT * i ;  
     //       System.out.print("$"+String.valueOf(bNumber[i].WIDTH/3)+"$");
            
              bNumber[i].setNumber(String.valueOf(bNumber[i].WIDTH ));  
       }
        repaint();    
    }
    
    public void ordenar2(){
        if(bNumber!=null)        
            new BurbujaWorker2().execute();//inicia worker
    }
     
    public class BurbujaWorker2 extends SwingWorker<Void, Void> {

        private int SPEED = 1; //velocidad de animacion (milisegundos)        
        
        @Override
        protected Void doInBackground() throws Exception {
        
        int i, j;
        BoxNumber aux;
        boolean swapped = true; 
        int start = 0; 
        int end = bNumber.length; 
        while (swapped == true) {
            swapped = false; 
            for (i = start; i < end - 1; ++i) { 
                if (bNumber[i].getValue() > bNumber[i + 1].getValue()) { 
                    aux = bNumber[i]; 
                    bNumber[i].colorBg = new Color(104,169,213);
                    bNumber[i+1].colorBg = new Color(104,169,213);
                    girar(i,i+1);  
                    bNumber[i].colorBg = new Color(80,172,178);
                    bNumber[i+1].colorBg = new Color(80,172,178);                  
                    bNumber[i] = bNumber[i + 1]; 
                    bNumber[i + 1] = aux; 
                    swapped = true;
                } 
            } 
            if (swapped == false) 
                break; 
            swapped = false; 
  
            end = end - 1; 
 
            
            for (i = end - 1; i >= start; i--) { 
                if (bNumber[i].getValue() > bNumber[i + 1].getValue()) {
                    /*
                    System.out.println();
                    for(int w = 0 ; w < bNumber.length ; w++){
                        System.out.print(bNumber[i].getValue()+"    ");
                    }
                    */
                    aux = bNumber[i]; 
                    bNumber[i].colorBg = new Color(104,169,213);
                    bNumber[i+1].colorBg = new Color(104,169,213);
                    girar(i,i+1);  
                    bNumber[i].colorBg = new Color(80,172,178);
                    bNumber[i+1].colorBg = new Color(80,172,178);                  
                    bNumber[i] = bNumber[i + 1]; 
                    bNumber[i + 1] = aux; 
                    swapped = true;
                    
                } 
            } 
            start = start + 1;
             }
           return null;
        
        }
        private void girar(int a , int b){

            for(int i=0; i < bNumber[0].HEIGHT;i++){
                bNumber[a].y += 1;
                bNumber[b].y -= 1;
                 try {
                    Thread.sleep(SPEED);
                 } catch (InterruptedException e) {}
                repaint();
            }
            
        }
        
    }
    
    @Override
    public void run() {
        ordenar2();
    }
    
    public void stop(){
        if(thread!=null){
            thread.stop();
        thread=null;
        }
    }
}