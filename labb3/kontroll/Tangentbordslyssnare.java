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

        switch (e.getKeyCode()) {
            case KeyEvent.VK_W: // 'W' key
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
