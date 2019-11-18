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
    public int WIDTH            =       24;
    public int HEIGHT           =       32;    
    public int x;
    public int y;    
    Color colorBg;
    private Dimension dimensionText;
    private Color[] color       = {     new Color(80,172,178)};

    public BoxNumber(){
        Random rn = new Random();        
        colorBg =  color[rn.nextInt(color.length)];
    }
    
    public BoxNumber(int height){
        Random rn = new Random();        
        colorBg =  color[rn.nextInt(color.length)];
        this.HEIGHT = this.HEIGHT * height;     
    }
    
    public void draw(Graphics2D g2){     
        Polygon boxPolygon = new Polygon();
        boxPolygon.addPoint( x, 650 - HEIGHT );  
        boxPolygon.addPoint( x + WIDTH, 650 - HEIGHT );  
        boxPolygon.addPoint( x + WIDTH, 650 );  
        boxPolygon.addPoint( x, 650 ); 

        g2.setColor( colorBg );
        g2.fillPolygon( boxPolygon );
        g2.setColor( new Color(0,0,0) );
        g2.drawPolygon( boxPolygon );
        
        if(getNumber().length()>0){            
            g2.setFont( font ); 
            g2.drawString( getNumber(), x+(WIDTH/2-dimensionText.width/2), 640);        
        }
        
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
