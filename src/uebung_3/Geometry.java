/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uebung_3;

import java.awt.Graphics;

/**
 *
 * @author Floyd
 */
public interface Geometry {
    // just the abstract interface

    /**
     * calculate the area, the sub class has to implement this
     */
    public double area();

    /**
     * calculate the perimeter, the sub class has to implement this
     */
    public double perimeter();
    
    public void paint(Graphics g);
}
