package uebung_3;

import java.awt.Color;
import java.awt.Graphics;

/**
 * A Circle using the Classes Point and Shape
 */
public class Circle extends Shape {

    /**
     * the radius for the circle
     */
    protected double radius;
    protected Color color;

    /**
     * Constructor
     */
    public Circle(Point center, double radius, Color color) {
        super(center);
        
        this.color = color;
        
        int xUpperLeftCorner = (int) (anchor.x - radius);
        int yUpperLeftCorner = (int) (anchor.y - radius);
        int width = (int) (2 * radius);

        
        this.setBounds(xUpperLeftCorner, yUpperLeftCorner, width, width);

        this.radius = radius;
        this.setOpaque(false);
    }

    /**
     * Constructor
     */
    public Circle() {
        super();
        radius = 0;
    }

    /**
     * Constructor with a center and a Point p on the perimeter
     */
    public Circle(Point center, Point p) {
        super(center);
        this.radius = center.distance(p);
    }

    /**
     * Area
     */
    public double area() {
        return (2 * radius * radius * Math.PI);
    }

    /**
     * Perimeter
     */
    public double perimeter() {
        return (2 * radius * Math.PI);
    }

    /**
     * toString
     */
    public String toString() {
        return ("Circle at " + position() + " with radius=" + radius);
    }

    /**
     * clone
     */
    public Object clone() {
        return new Circle((Point) anchor.clone(), radius, new Color(color.getRed(), color.getGreen(), color.getBlue()));
    }

    /**
     * equals
     */
    public boolean equals(Object pp) {
        if (pp instanceof Circle) {
            Circle p = (Circle) pp;
            return (anchor.equals(p.anchor) && p.radius == radius);
        } else {
            return false;
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        //drawOval() braucht als Parameter den linken Oberen Eckpunkt übergeben
        //Daher zieht man vom Mittelpunkt des Kreises (anchor) sowohl auf der x
        // als auch der y Achse den Radius ab.

        super.paintComponent(g);
        int xUpperLeftCorner = (int) (anchor.x - radius);
        int yUpperLeftCorner = (int) (anchor.y - radius);
        int width = (int) (2 * radius);
        g.setColor(color);
        this.setBounds(xUpperLeftCorner, yUpperLeftCorner, width, width);
        //g.drawOval(xUpperLeftCorner, yUpperLeftCorner, width, width);
        g.fillOval(0, 0, width, width);
        
    }
}
