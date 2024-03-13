package labb3.kontroll;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import labb3.modell.Nivå;

import static labb3.modell.Väderstreck.*;

public class Tangentbordslyssnare implements KeyListener {
    private Nivå enNivå;

    public Tangentbordslyssnare(Nivå enNivå) {
        this.enNivå = enNivå;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO: Skriv klar denna metod som automatiskt anropas så snart
        // användaren tryckt på en tangent på tangentbordet. Metoden ska
        // översätta tangenten till ett väderstreck och sen anropa hoppaÅt i
        // enNivå med detta väderstreck. Här ska
        //
        // w betyda "hoppa åt NORR",
        // d betyda "hoppa åt ÖSTER",
        // s betyda "hoppa åt SÖDER" och
        // a betyda "hoppa åt VÄSTER".

        switch (e.getKeyCode()) {
            case KeyEvent.VK_W: // 'W' key
                System.out.println("WW");
                enNivå.hoppaÅt(NORR);
                break;
            case KeyEvent.VK_D: // 'D' key
                enNivå.hoppaÅt(ÖSTER);
                break;
            case KeyEvent.VK_S: // 'S' key
                enNivå.hoppaÅt(SÖDER);
                break;
            case KeyEvent.VK_A: // 'A' key
                enNivå.hoppaÅt(VÄSTER);
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Används inte men måste implementeras eftersom keyTyped finns i
        // gränssnittet KeyListener.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Används inte men måste implementeras eftersom keyReleased finns is
        // gränssnittet KeyListener.
    }
}
