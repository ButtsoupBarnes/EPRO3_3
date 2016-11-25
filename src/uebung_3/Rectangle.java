package uebung_3;

import java.awt.Color;
import java.awt.Graphics;

/**
 * A Rectangle using the Classes Point and Shape
 */
public class Rectangle extends Shape {

    /**
     * the second Point for the Rectangle
     */
    protected Point rightLowerCorner;
    protected Color color;

    /**
     * Constructor
     */
    public Rectangle(Point leftUpperCorner, Point rightLowerCorner, Color color) {
        super(leftUpperCorner);
        this.rightLowerCorner = (Point) rightLowerCorner.clone();
        this.color = color;

        int x = (int) rightLowerCorner.x;
        int y = (int) rightLowerCorner.y;

        this.setBounds(x, y, (int) width(), (int) height());

        this.setOpaque(false);

    }

    /**
     * Area
     */
    public double area() {
        return (width() * height());
    }

    /**
     * Perimeter
     */
    public double perimeter() {
        return (2 * (width() + height()));
    }

    // helper
    /**
     * Returns the width of the rectangle
     */
    private double width() {
        return (Math.abs(rightLowerCorner.x - anchor.x));
    }

    /**
     * Returns the height of the rectangle
     */
    private double height() {
        return (Math.abs(anchor.y - rightLowerCorner.y));
    }

    /**
     * toString
     */
    public String toString() {
        return ("Rectangle at " + position()
                + " with width=" + width() + " and heigth=" + height());
    }

    /**
     * clone, makes a deep copy of the Rectange (clones both Points)
     */
    public Object clone() {
        return new Rectangle((Point) anchor.clone(),
                (Point) rightLowerCorner.clone(), new Color(color.getRed(), color.getGreen(), color.getBlue()));
    }

    /**
     * equals
     */
    public boolean equals(Object rr) {
        if (rr instanceof Rectangle) {
            Rectangle r = (Rectangle) rr;
            return (anchor.equals(r.anchor)
                    && rightLowerCorner.equals(r.rightLowerCorner));
        } else {
            return false;
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = (int) rightLowerCorner.x;
        int y = (int) rightLowerCorner.y;
        this.setBounds(x, y, (int) width(), (int) height());
        g.setColor(color);

        //g.drawRect(x, y, (int)width(), (int)height());
        g.fillRect(0, 0, (int) width(), (int) height());
    }
}
