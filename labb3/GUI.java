package labb3;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

import labb3.modell.Nivå;
import labb3.modell.Rum;
import labb3.vy.Målarduk;

import javax.swing.*;

public class GUI extends JFrame implements Observer {

    private Målarduk målarduk;

    public GUI(Nivå enNivå) {


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        enNivå.addObserver(this); //Un clear if needed here
        målarduk = new Målarduk(enNivå);


        int width = 0;
        int height = 0;

        for (Rum i : enNivå.getRumLista()) {
            if (i.getÖvX() > width) {
                width = i.getÖvX();
            }
            if (i.getÖvY() > height) {
                height = i.getÖvY();
            }


        }

        målarduk.setPreferredSize(new Dimension((int) (width * 1.2), (int) (height * 1.8)));

        setContentPane(målarduk);
        pack();
        setVisible(true);
    }


    public void update(Observable o, Object arg) {
        målarduk.repaint();
    }
}
