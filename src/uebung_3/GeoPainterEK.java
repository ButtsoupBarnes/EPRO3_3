/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uebung_3;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JLayeredPane;

/**
 *
 * @author Floyd
 */
public class GeoPainterEK {
    
    ArrayList<Shape> shapesToPaint;
    Random rand;
    
    JLayeredPane lp = new JLayeredPane();

    public GeoPainterEK() {
        shapesToPaint = new ArrayList<Shape>();
        rand = new Random();        
    }

    public ArrayList<Shape> getShapesToPaint() {
        return shapesToPaint;
    }

    public void addCircle(Point center, double radius, Color color, int depth) {
        Shape newCircle = new Circle(center, radius, color);
        lp.add(newCircle, depth);
    }

    public void addRectangle(Point leftUpperCorner, Point rightLowerCorner, Color color, int depth) {
        Rectangle newRect = new Rectangle(leftUpperCorner, rightLowerCorner, color);
        lp.add(newRect, depth);
    }
  
    public Point randomPosition() {
        int randomX = rand.nextInt(500);
        int randomY = rand.nextInt(500);
        return new Point(randomX, randomY);
    }

    public int randomSize() {
        return rand.nextInt(100);
    }
    
    public Color randomColor(){
        return new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
    }
}
