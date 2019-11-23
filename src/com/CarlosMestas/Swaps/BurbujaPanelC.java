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
public class BurbujaPanelC extends JPanel implements Runnable{
    
    Thread thread;
    
    private int NUM_BOX                 =       BurbujaFrm.cantNumbers;
    private Dimension dimension         =       new Dimension(500,128);    
    private BoxNumber[] bNumber;
    
    /**
     * Constructor de clase
     */
    public BurbujaPanelC(){
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
        for(int i = 0;i < NUM_BOX;i++){
            bNumber[i].x = 10;
            bNumber[i].y = 10 + bNumber[i].HEIGHT * i ;          
            bNumber[i].setNumber(String.valueOf(bNumber[i].WIDTH ));  
        }
        repaint();    
    }
    
    public void ordenar3(){
        if(bNumber!=null)        
            new BurbujaWorker3().execute();//inicia worker
    }
     
    public class BurbujaWorker3 extends SwingWorker<Void, Void> {

        private int SPEED = 1; //velocidad de animacion (milisegundos)        
        
        @Override
        protected Void doInBackground() throws Exception {
        
        int n = BurbujaFrm.cantNumbers; 
        int gap = n; 
        boolean swapped = true; 
        while (gap != 1 || swapped == true){
            gap = getNextGap(gap);  
            swapped = false;  
            for (int i=0; i < n - gap; i++){ 
                if (bNumber[i].getValue() > bNumber[i+gap].getValue()){ 
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
            for(int i = 0; i < bNumber[0].HEIGHT;i++){
                 bNumber[a].y += 1*gap;
                 bNumber[b].y -= 1*gap;
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

    @Override
    public void run() {
        ordenar3();
    }
    
    public void stop(){
        if(thread!=null){
            thread.stop();
        thread=null;
        }
    }
}
