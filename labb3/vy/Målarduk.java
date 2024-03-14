package labb3.vy;

import java.awt.*;

import labb3.kontroll.Tangentbordslyssnare;
import labb3.modell.Gång;
import labb3.modell.Nivå;
import labb3.modell.Rum;

import labb3.verktyg.Punkt;


import javax.swing.*;

import static labb3.GlobalaKonstanter.*;
import static labb3.verktyg.Grafik.*;


public class Målarduk extends JPanel {


    private final Nivå enNivå;


    public Målarduk(Nivå enNivå) {
        this.enNivå = enNivå;
        setBackground(MARKFÄRG); // Set the background color. Replace WHITE with the appropriate MARKFÄRG
        setFocusable(true);
        Tangentbordslyssnare listener = new Tangentbordslyssnare(enNivå);
        addKeyListener(listener);
        requestFocusInWindow();
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);


        for (Rum element : enNivå.getRumLista()) {
            this.ritaRum(g, element);
        }
        this.ritaMarkörFörVarAnvändarenÄr(g);
        this.ritaGångarFrånRum(g);

    }

    private void ritaRum(Graphics g, Rum ettRum) {

        g.setColor(VÄGGFÄRG);
        g.fillRect(ettRum.getÖvX(), ettRum.getÖvY(), ettRum.getBredd(), ettRum.getHöjd());

        g.setColor(ettRum.getGolvfärg());
        g.fillRect(ettRum.getÖvX() + VÄGGTJOCKLEK, ettRum.getÖvY() + VÄGGTJOCKLEK,
                ettRum.getBredd() - VÄGGTJOCKLEK * 2, ettRum.getHöjd() - VÄGGTJOCKLEK * 2);


    }

    private void ritaGångarFrånRum(Graphics g) {
        for (Rum i : enNivå.getRumLista()) {
            this.baspunkt(g, i);
            this.pivotpunkt(g, i);
            this.ritaGång(g, i);
        }


    }

    private void baspunkt(Graphics g, Rum ettRum) {

        for (Gång element : ettRum.getRumetsGångar()) {
            Punkt[] punktpairs = element.getPunktPairs();

            drawThickLine(g, punktpairs[0], punktpairs[1], VÄGGTJOCKLEK, GÅNGFÄRG);
            drawThickLine(g, punktpairs[2], punktpairs[3], VÄGGTJOCKLEK, GÅNGFÄRG);

        }

    }

    private void pivotpunkt(Graphics g, Rum ettRum) {
        for (Gång element : ettRum.getRumetsGångar()) {
            Punkt[] punktpairs = element.getPunktPairs();

            fillCircle(g, punktpairs[0], HALV_VÄGGTJOCKLEK, GÅNGFÄRG);
            fillCircle(g, punktpairs[2], HALV_VÄGGTJOCKLEK, GÅNGFÄRG);

        }


    }

    private void ritaGång(Graphics g, Rum ettRum) {
        for (Gång element : ettRum.getRumetsGångar()) {
            Punkt[] punktpairs = element.getPunktPairs();

            drawThickLine(g, punktpairs[0], punktpairs[2], VÄGGTJOCKLEK, GÅNGFÄRG);

        }

    }

    private void ritaMarkörFörVarAnvändarenÄr(Graphics g) {
        Rum currentRum = enNivå.getCurrentRum();

        Punkt mittPunkt = new Punkt((int) (currentRum.getÖvX() + currentRum.getBredd() * 0.5),
                (int) (currentRum.getÖvY() + currentRum.getHöjd() * 0.5));

        fillCircle(g, mittPunkt, ANVÄNDARRADIE, ANVÄNDARFÄRG);


    }
}
