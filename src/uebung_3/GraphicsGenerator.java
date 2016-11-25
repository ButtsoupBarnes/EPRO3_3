/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uebung_3;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/**
 *
 * @author Floyd
 */
public class GraphicsGenerator extends JPanel {

    ArrayList<Shape> shapesToPaint;

    public GraphicsGenerator(ArrayList<Shape> shapesToPaint) {
        this.shapesToPaint = shapesToPaint;
    }

    @Override
    public void paintComponent(Graphics g) {
        for (Shape shape : shapesToPaint) {
            g.setColor(Color.white);
            shape.paint(g);
        }
    }
}
