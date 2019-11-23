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
public class BurbujaPanel extends JPanel{
    
    private int NUM_BOX                 =       15;
    private Dimension dimension         =       new Dimension(500,128);    
    private int max                     =       20;
    private int min                     =       1;
    private BoxNumber[] bNumber;
    
    public BurbujaPanel(){
        setSize(dimension);
        setVisible(true);                
    }
    
    @Override
    public void paintComponent(Graphics g){    
        Graphics2D g2 =(Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);    
        g2.setColor( new Color(255,255,255) );
        g2.fill(new Rectangle2D.Double(0,0,getWidth(),getHeight()));                 
        if(bNumber!=null)
        for(BoxNumber b:bNumber){
            b.draw(g2);
        }    
    }
    
    public void generar3(BoxNumber[] array){
        bNumber = array;
        for(int i = 0;i < NUM_BOX;i++){
            System.out.println(i);               
            bNumber[i].x = 10 + bNumber[i].WIDTH * i;
            bNumber[i].y = 42 ;  
            bNumber[i].setNumber(String.valueOf(bNumber[i].HEIGHT/32));  
        }
        repaint();    
    }
    
    public void ordenar(){
        if(bNumber!=null)        
            new BurbujaWorker().execute();//inicia worker
    }
     
    public class BurbujaWorker extends SwingWorker<Void, Void> {

        private int SPEED = 5;           
        @Override
        protected Void doInBackground() throws Exception {
        int i, j;
        BoxNumber aux;
        for(i=0;i<bNumber.length-1;i++)
            for(j=0;j<bNumber.length-i-1;j++)
                if(bNumber[j+1].getValue()<bNumber[j].getValue()){
                    aux=bNumber[j+1];
                    //animar movimiento
                    bNumber[j].colorBg = new Color(104,169,213);
                    bNumber[j+1].colorBg = new Color(104,169,213);
                 	 
                    girar(j,j+1);     
                      
                    bNumber[j].colorBg = new Color(80,172,178);
                    bNumber[j+1].colorBg = new Color(80,172,178);
                    bNumber[j+1]=bNumber[j];
                    bNumber[j]=aux;
                }         
            return null;
        }
        
        private void girar(int a , int b){
            for(int i=0; i< bNumber[0].WIDTH;i++){
                 bNumber[a].x += 1;
                 bNumber[b].x -= 1;
                 try {
                    Thread.sleep(SPEED);
                 } catch (InterruptedException e) {}
                repaint();
            }
        }
    }
    
    public void ordenar2(){
        if(bNumber!=null)        
            new BurbujaWorker2().execute();//inicia worker
    }
     
    public class BurbujaWorker2 extends SwingWorker<Void, Void> {

        private int SPEED = 5; 
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
                    System.out.println();
                    for(int w = 0 ; w < bNumber.length ; w++){
                        System.out.print(bNumber[i].getValue()+"    ");
                    }
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

            for(int i=0; i< bNumber[0].WIDTH;i++){
                 bNumber[a].x += 1;
                 bNumber[b].x -= 1;
                 try {
                    Thread.sleep(SPEED);
                 } catch (InterruptedException e) {}
                repaint();
            }
            
        }
        
    }
    
    public void ordenar3(){
        if(bNumber!=null)        
            new BurbujaWorker3().execute();//inicia worker
    }
     
    public class BurbujaWorker3 extends SwingWorker<Void, Void> {

        private int SPEED = 5; //velocidad de animacion (milisegundos)        
        
        @Override
        protected Void doInBackground() throws Exception {
        
        int n = bNumber.length; 
        int gap = n; 
        boolean swapped = true; 
        while (gap != 1 || swapped == true){
            gap = getNextGap(gap);  
            swapped = false;  
            for (int i=0; i < n - gap; i++){ 
                if (bNumber[i].getValue() > bNumber[i+gap].getValue()){ 
                    System.out.println();
                    for(int w = 0 ; w < bNumber.length ; w++){
                        System.out.print(bNumber[i].getValue()+"****");
                    }
                    BoxNumber temp = bNumber[i]; 
                    bNumber[i].colorBg = new Color(104,169,213);
                    bNumber[i+gap].colorBg = new Color(104,169,213);
                 	 
                    girar(i,i+gap,gap);     
                      
                    bNumber[i].colorBg = new Color(80,172,178);
                    bNumber[i+gap].colorBg = new Color(80,172,178);
                    
                    bNumber[i] = bNumber[i + gap]; 
                    bNumber[i + gap] = temp; 
                    swapped = true;
                } 
            } 
            
        }
        return null;
        }
        private void girar(int a , int b, int gap){
            for(int i = 0; i < bNumber[0].WIDTH;i++){
                 bNumber[a].x += 1*gap;
                 bNumber[b].x -= 1*gap;
                 try {
                    Thread.sleep(SPEED);
                 } catch (InterruptedException e) {}
                repaint();
            }
            
        }
        
        public int getNextGap(int gap){ 
            gap = (gap * 10) / 13; 
            if (gap < 1) 
                return 1; 
            return gap; 
        } 
        
    }
    
}