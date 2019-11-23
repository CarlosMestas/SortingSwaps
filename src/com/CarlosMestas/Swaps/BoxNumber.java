package com.CarlosMestas.Swaps;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * @author Carlos Alberto Mestas Escarcena
 */
public class BoxNumber {
        
    private Font font           =       new Font("Tahoma", Font.BOLD, 12); 
    private String number       =       "0";
    public int WIDTH            =       360 / BurbujaFrm.maxRandom;
    public int HEIGHT           =       630 / BurbujaFrm.cantNumbers;  

    public int x;
    public int y;    
    Color colorBg;
    private Dimension dimensionText;
    private Color[] color       = {     new Color(80,172,178)};

    public BoxNumber(int width){
        Random rn = new Random();        
        colorBg =  color[rn.nextInt(color.length)];
        this.WIDTH = this.WIDTH * width;
    }
    
    public void draw(Graphics2D g2){     
        Polygon boxPolygon = new Polygon();
        boxPolygon.addPoint( x, y );  
        boxPolygon.addPoint( x + WIDTH, y );  
        
        boxPolygon.addPoint( x + WIDTH, y + HEIGHT ); 

        boxPolygon.addPoint( x, y + HEIGHT );  
        g2.setColor( colorBg );
        g2.fillPolygon( boxPolygon );
        g2.setColor( new Color(0,0,0) );
        g2.drawPolygon( boxPolygon );
  
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
        dimensionText = calculateFontDimension(number);
    }
    
    public int getValue() {
        return Integer.valueOf(number);
    }
    
    private Dimension calculateFontDimension(String text){       
        BufferedImage image = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = image.createGraphics();            
        g2.setStroke(new BasicStroke(0.0f));
        FontRenderContext frc = g2.getFontRenderContext();
        TextLayout layout = new TextLayout(text, font, frc);
        layout.draw(g2, 0, 0);
        Rectangle2D bounds = layout.getBounds();
        bounds.setRect(bounds.getX(),
                      bounds.getY(),
                      bounds.getWidth(),
                      bounds.getHeight());
        int w = (int) bounds.getWidth();
        int h = (int) bounds.getHeight();            
        g2.draw(bounds);
        g2.dispose();
        return new Dimension(w,h);
    }
 
}
