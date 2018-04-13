/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Nelson
 */
public class LineExample extends JPanel{

    public LineExample() {
        this.setPreferredSize(new Dimension(800, 600));
    } // constructor
    
    private void draw(Graphics g){
        // dibujar los ejes del plano cartesiano
        for (int i = 0; i <=100000; i++) {
            int R= (int)(Math.random()*256);
            int G= (int)(Math.random()*256);
            int B= (int)(Math.random()*256);        
            Color aleatorio= new Color(R, G, B);
            g.setColor(aleatorio);
        
        double x= rangeRandom(0, 900);
        double y= rangeRandom(0, 900);
        double x1= rangeRandom(0, 900);
        double y1= rangeRandom(0, 900);

        linearFunction(g, x1, y1, x, y);
        
        }
        //linearFunction(g, 0, 0, 100, 600);

    } // draw
    
    // funcion lineal f(x) = m x + b
    // x1 y x2 es el rango en el que se graficara la funcion
    double rangeRandom(double max, double min){
        double range= Math.abs(max-min);
        return (Math.random()*range)+(min<=max ? min : max);
    
    }
    
    private void linearFunction(Graphics g, double x0, double y0, double x1, double y1){        
        
        double y;
        //double punto;
        
        //calculo de pendiente y del termino b (interseccion con eje y)
        double m = (y0 - y1) / (x0 - x1);
        double b = y0 - ((y0 - y1) / (x0 - x1)) * x0;
        
        for(double x = x0; x <= x1; x += 1){
        //for(double x = x0; x <= x1; x += 0.1){
             y = (m * x + b);// * 10; // se multiplica por 10 para escalar el punto a representar en pantalla
             //punto = x;// * 10;
             g.drawLine((int)coord_x(x), (int)coord_y(y), (int)coord_x(x), (int)coord_y(y)); 
        } // for

    }// linearFunction
    
    
    private double coord_x(double x)
    {
        return x;
    }
    
    private double coord_y(double y)
    {
        double real_y = (double)this.getHeight() - y;
        return real_y;
    }   
    
    
   @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // se llama al meto draw
        draw(g);

    }
    
    public static void main(String[] args) {
        JFrame window = new JFrame("Graphing Function");
        window.setContentPane(new LineExample());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        window.pack();
        window.setResizable(false);
        window.setLocation(150, 100);
        window.setVisible(true);         
    }
    
} // fin clase



