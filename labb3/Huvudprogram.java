package labb3;

import static labb3.modell.Väderstreck.*;

import java.awt.Color;
import java.util.ArrayList;

import labb3.modell.*;


public class Huvudprogram {
//	Huvudprogram creates or rather designs how the level is to be
//	This is basically a game engine that creates how the level is designed.
//
//	Here we just add rooms and connect them


    public static void main(String[] args) {

        coolLevel();
//        exampleLevel();

    }

    public static void exampleLevel() {
        ArrayList<Rum> rum = new ArrayList<Rum>();
        rum.add(new Rum(Color.RED, 75, 75, 25, 25));
        rum.add(new Rum(Color.BLUE, 75, 50, 50, 150));
        rum.add(new Rum(Color.MAGENTA, 100, 50, 175, 100));
        rum.add(new Rum(Color.YELLOW, 100, 75, 200, 200));
        rum.add(new Rum(Color.CYAN, 100, 75, 325, 50));
        rum.add(new Rum(Color.ORANGE, 75, 75, 450, 125));
        rum.add(new Rum(Color.PINK, 100, 50, 275, 325));
        rum.add(new Rum(Color.GREEN, 75, 100, 75, 275));

        Rum.kopplaIhop(rum.get(0), SÖDER, rum.get(1), NORR);
        Rum.kopplaIhop(rum.get(0), ÖSTER, rum.get(2), NORR);
        Rum.kopplaIhop(rum.get(1), SÖDER, rum.get(3), VÄSTER);
        Rum.kopplaIhop(rum.get(2), SÖDER, rum.get(3), NORR);
        Rum.kopplaIhop(rum.get(2), ÖSTER, rum.get(4), VÄSTER);
        Rum.kopplaIhop(rum.get(4), ÖSTER, rum.get(5), NORR);
        Rum.kopplaIhop(rum.get(5), SÖDER, rum.get(6), ÖSTER);
        Rum.kopplaIhop(rum.get(3), ÖSTER, rum.get(5), VÄSTER);
        Rum.kopplaIhop(rum.get(3), SÖDER, rum.get(6), NORR);
        Rum.kopplaIhop(rum.get(7), ÖSTER, rum.get(6), VÄSTER);


        Nivå nivå = new Nivå(rum.get(3), rum);
        GUI gui = new GUI(nivå);
    }

    public static void coolLevel() {
        ArrayList<Rum> rum = new ArrayList<>();


        rum.add(new Rum(Color.RED, 100, 100, 50, 50)); // Room 0
        rum.add(new Rum(Color.BLUE, 120, 80, 200, 50)); // Room 1
        rum.add(new Rum(Color.GREEN, 150, 100, 30, 200)); // Room 2
        rum.add(new Rum(Color.YELLOW, 100, 150, 350, 200)); // Room 3
        rum.add(new Rum(Color.MAGENTA, 80, 120, 220, 330)); // Room 4
        rum.add(new Rum(Color.ORANGE, 120, 100, 500, 50)); // Room 5
        rum.add(new Rum(Color.CYAN, 150, 150, 470, 350)); // Room 6
        rum.add(new Rum(Color.PINK, 90, 90, 650, 200)); // Room 7


        Rum.kopplaIhop(rum.get(0), SÖDER, rum.get(2), NORR);
        Rum.kopplaIhop(rum.get(1), VÄSTER, rum.get(0), ÖSTER);
        Rum.kopplaIhop(rum.get(2), ÖSTER, rum.get(4), VÄSTER);
        Rum.kopplaIhop(rum.get(1), SÖDER, rum.get(4), NORR);
        Rum.kopplaIhop(rum.get(5), VÄSTER, rum.get(3), ÖSTER);
        Rum.kopplaIhop(rum.get(6), VÄSTER, rum.get(4), ÖSTER);
        Rum.kopplaIhop(rum.get(7), VÄSTER, rum.get(6), ÖSTER);


        Nivå nivå = new Nivå(rum.get(0), rum);
        GUI gui = new GUI(nivå);
    }


}
