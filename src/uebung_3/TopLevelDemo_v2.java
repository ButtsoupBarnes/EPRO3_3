package uebung_3;

/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;


/* TopLevelDemo.java requires no other files. */
public class TopLevelDemo_v2 extends JPanel implements ActionListener {

    public String bla;

    //Deklaration der Instanzvariablen
    JLabel yellowLabel = new JLabel();

    GeoPainterEK ge;
    GraphicsGenerator gg;

    int depthcounter = 0;

    //Konstruktor
    TopLevelDemo_v2() {

        yellowLabel.setOpaque(true);
        yellowLabel.setBackground(new Color(248, 213, 131));
        //yellowLabel.setPreferredSize(new Dimension(200, 180));
        yellowLabel.setPreferredSize(new Dimension(500, 500));
        //Hinzufuegen des Labels
        add(yellowLabel);

        ge = new GeoPainterEK();
        gg = new GraphicsGenerator(ge.shapesToPaint);
    }

    public JMenuBar createMenuBar() {

        //Create the menu bar.  Make it have a green background.
        JMenuBar greenMenuBar = new JMenuBar();
        greenMenuBar.setOpaque(true);
        greenMenuBar.setBackground(new Color(154, 165, 127));
        greenMenuBar.setPreferredSize(new Dimension(200, 20));

        //Menupunkt  hinzufuegen
        JMenu menu_file = new JMenu("Farbe");
        JMenu menu_file_shape = new JMenu("Form");
        greenMenuBar.add(menu_file);
        greenMenuBar.add(menu_file_shape);

        //Menueeintraege hinzufuegen
        JMenuItem item_rot = new JMenuItem("Rot");
        JMenuItem item_gruen = new JMenuItem("Gruen");
        JMenuItem item_blau = new JMenuItem("Blau");
        JMenuItem item_kreis = new JMenuItem("Kreis");
        JMenuItem item_rechteck = new JMenuItem("Rechteck");
        //1. ActionListener fuer Open anh�ngen
        item_rot.addActionListener(this);
        item_gruen.addActionListener(this);
        item_blau.addActionListener(this);
        item_kreis.addActionListener(this);
        item_rechteck.addActionListener(this);

        menu_file.add(item_rot);
        menu_file.add(item_gruen);
        menu_file.add(item_blau);

        menu_file_shape.add(item_kreis);
        menu_file_shape.add(item_rechteck);

        // JMenuBar grrenMenuBar zur�ckgeben
        return greenMenuBar;

    }

    /**
     * Create the GUI and show it. For thread safety, this method should be
     * invoked from the event-dispatching thread. Problem: Das muss eine
     * statische Methode sein, um thread-save aufgerufen werden zu koennen
     * (siehe Methode main()). Allerdings, eine statische Methode kann nicht mit
     * den Instanzvariablen der Klasse interagieren. Wir umgehen das, indem wir
     * von JPanel erben, und dieses als ContentPane in unseren Frame geben.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("TopLevelDemo Version 2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* JPanel MiniPhotoShop als ContentPane, this nicht m�gloch, umweg */
        TopLevelDemo_v2 ourTopLevelDemo = new TopLevelDemo_v2();
        //Damit k�nnen wir jede Komponente in unserer Hauptklasse adden!

        Container pane = frame.getContentPane();
        pane.add(ourTopLevelDemo.ge.lp);

        frame.setTitle("Simple example");
        frame.setSize(1000, 1000);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        frame.setJMenuBar(ourTopLevelDemo.createMenuBar());
        //Display the window.
        //frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem itemClicked;
        //Falls es ein MenuItem ist
        if (e.getSource() instanceof JMenuItem) {
            itemClicked = (JMenuItem) e.getSource();
            //Falls es das Item "Rot" war
            if (itemClicked.getText() == "Rot") {
                yellowLabel.setOpaque(true);
                yellowLabel.setBackground(new Color(255, 0, 0));
                //Wenn Hintergrundfarbe gewechselt wird, lösche alle im Moment
                //gezeichneten Formen
                gg.shapesToPaint.clear();
            }
            if (itemClicked.getText() == "Gruen") {
                yellowLabel.setOpaque(true);
                yellowLabel.setBackground(new Color(0, 255, 0));
                //Wenn Hintergrundfarbe gewechselt wird, lösche alle im Moment
                //gezeichneten Formen
                gg.shapesToPaint.clear();

            }
            if (itemClicked.getText() == "Blau") {
                yellowLabel.setOpaque(true);
                yellowLabel.setBackground(new Color(0, 0, 255));
                //Wenn Hintergrundfarbe gewechselt wird, lösche alle im Moment
                //gezeichneten Formen
                gg.shapesToPaint.clear();

            }
            if (itemClicked.getText() == "Kreis") {
                ge.addCircle(ge.randomPosition(), ge.randomSize(), ge.randomColor(), depthcounter);
                //ge.addRandomCircle();
                //System.out.println(newCircle.toString());
                gg.paintComponent(getGraphics());
                depthcounter = depthcounter + 1;

            }

            if (itemClicked.getText() == "Rechteck") {
                ge.addRectangle(ge.randomPosition(), ge.randomPosition(), ge.randomColor(),depthcounter);
                //ge.addRandomRectangle();
                //System.out.println(newCircle.toString());
                gg.paintComponent(getGraphics());
                depthcounter = depthcounter + 1;
            }

        }
    }
}
