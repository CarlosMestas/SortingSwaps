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
public class BurbujaPanelA extends JPanel implements Runnable{
    
    Thread thread;
    
    
    private int NUM_BOX                 =       BurbujaFrm.cantNumbers;  
    private Dimension dimension         =       new Dimension(500,128);    
    private BoxNumber[] bNumber;
    
    public BurbujaPanelA(){
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

    public void ordenar(){
        if(bNumber!=null)        
            new BurbujaWorker().execute();//inicia worker
    }
     
    public class BurbujaWorker extends SwingWorker<Void, Void> {

        private int SPEED = 1;      
        
        @Override
        protected Void doInBackground() throws Exception {
    
        int i, j;
        BoxNumber aux;
        for(i=0;i<bNumber.length-1;i++)
            for(j=0;j<bNumber.length-i-1;j++)
                if(bNumber[j+1].getValue()<bNumber[j].getValue()){
                    aux = bNumber[j+1];
                    //animar movimiento
                    bNumber[j].colorBg = new Color(104,169,213);
                    bNumber[j+1].colorBg = new Color(104,169,213);
                 	 
                    girar(j,j+1);     
                      
                    bNumber[j].colorBg = new Color(80,172,178);
                    bNumber[j+1].colorBg = new Color(80,172,178);
                    bNumber[j+1]=bNumber[j];
                    bNumber[j]=aux;
                }
            BurbujaFrm.jButton1.setEnabled(true);
            BurbujaFrm.jButton2.setEnabled(true);
            BurbujaFrm.jButton3.setEnabled(true);
            BurbujaFrm.jButton4.setEnabled(true);        
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
    
    public void start(){
        if(thread == null){
            thread = new Thread((java.lang.Runnable) this);
            thread.start();
        }
    }
    @Override
    public void run() {
        ordenar();

    }
    
    public void stop(){
        if(thread!=null){
            thread.stop();
        thread=null;
        }
    }
    
}
