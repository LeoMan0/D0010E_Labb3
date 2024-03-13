package labb3.vy;

import java.awt.*;

import labb3.kontroll.Tangentbordslyssnare;
import labb3.modell.Gång;
import labb3.modell.Nivå;
import labb3.modell.Rum;
import labb3.modell.Väderstreck;
import labb3.verktyg.Punkt;
import labb3.verktyg.Grafik;


import javax.swing.*;

import static labb3.GlobalaKonstanter.*;
import static labb3.verktyg.Grafik.fillCircle;

// TODO: Ändra nästa rad så att en Målarduk "är-en" JPanel.

public class Målarduk extends JPanel {

    // This is here so I can test stuff

    private final Nivå enNivå;


    public Målarduk(Nivå enNivå) {
        this.enNivå = enNivå;
        setBackground(Color.WHITE); // Set the background color. Replace WHITE with the appropriate MARKFÄRG
        setFocusable(true); // Makes the panel capable of receiving keyboard focus
        Tangentbordslyssnare listener = new Tangentbordslyssnare(enNivå);
        addKeyListener(listener);
        requestFocusInWindow(); // Request focus to receive key input
    }

    // TODO: Lätt till @Override på metoden nedan.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
//		 g.setColor(Color.BLUE);
//		 g.fillRect(10, 10, 100, 100);

        for (Rum element : enNivå.getRumLista()) {
            this.ritaRum(g, element);
        }
        this.ritaMarkörFörVarAnvändarenÄr(g);
        // TODO Lägg till ett anrop till paintComponent i omedelbara
        // överklassen (JPanel). Skicka med g som argument.

        // TODO: Lägg till kod som ritar ut en grafisk vy av enNivå.
        //
        // För att underlätta finns hjälpmetoder som ska skrivas klara. Studera
        // noga bilderna i labbinstruktionen för att få fram formlerna för
        // bas- och pivotpunkternas koordinater. Använd ritmetoderna i klassen
        // labb3.verktyg.Grafik. Anropa hjälpmetoderna från paintComponent.
    }

    private void ritaRum(Graphics g, Rum ettRum) {

        g.setColor(ettRum.getGolvfärg());
        g.fillRect(ettRum.getÖvX(), ettRum.getÖvY(), ettRum.getBredd(), ettRum.getHöjd());


    }

    private void ritaGångarFrånRum(Graphics g, Rum ettRum) {

    }

    private Punkt baspunkt(Rum ettRum, Väderstreck enRiktning) {
        return null; /* endast här för att Eclipse inte ska klaga */
    }

    private Punkt pivotpunkt(Rum ettRum, Väderstreck enRiktning) {
        return null; /* endast här för att Eclipse inte ska klaga */
    }

    private void ritaGång(Graphics g, Gång enGång) {

    }

    private void ritaMarkörFörVarAnvändarenÄr(Graphics g) {
        Rum currentRum = enNivå.getCurrentRum();

        Punkt mittPunkt = new Punkt((int) (currentRum.getÖvX() + currentRum.getBredd() * 0.5),
                (int) (currentRum.getÖvY() + currentRum.getHöjd() * 0.5));

        fillCircle(g, mittPunkt, ANVÄNDARRADIE, ANVÄNDARFÄRG);


    }
}
