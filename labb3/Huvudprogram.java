package labb3;

import static labb3.modell.Väderstreck.*;

import java.awt.Color;
import java.util.ArrayList;

import labb3.modell.*;
import java.util.Scanner;

public class Huvudprogram {
//	Huvudprogram creates or rather designs how the level is to be
//	This is basically a game engine that creates how the level is designed.
//
//	Here we just add rooms and connect them


	public static void main(String[] args) {

		ArrayList<Rum> rum = new ArrayList<Rum>();


//		// TODO Skapa även andra uppsättningar rum/gångar för att kunna testköra
//		// ordentligt. Lägg varje uppsättning (även den givna nedan) i separata
//		// metoder här i klassen. Såna bör vara deklarerade static för att kunna
//		// anropas från main (som ju också är static).
//
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
//
//		// TODO: Skapa en nivå med argumenten rum.get(3) och rum.
		Nivå nivå = new Nivå(rum.get(3),rum); // Start in rumA

//
//		// TODO: Skapa en instans av klassen GUI och skicka med nivån ovan som
//		// argument. Man kan ha en referensvariabel som refererar till
//		// GUI-instansen men det är är inte nödvändigt.
		GUI gui = new GUI(nivå);

	}
//
//}



//		// Create rooms
//		Rum rumA = new Rum(Color.BLUE, 10, 10, 0, 0);
//		Rum rumB = new Rum(Color.GREEN, 10, 10, 20, 20);
//		Rum rumC = new Rum(Color.RED, 10, 10, 40, 40);
//
//		// Connect rooms: A -> B -> C
//		Rum.kopplaIhop(rumA, ÖSTER, rumB, VÄSTER);
//		Rum.kopplaIhop(rumB, ÖSTER, rumC, VÄSTER);
//		Rum.kopplaIhop(rumC, ÖSTER, rumA, VÄSTER);
//
//
//		ArrayList<Rum> rumLista = new ArrayList<>();
//		rumLista.add(rumA);
//		rumLista.add(rumB);
//		rumLista.add(rumC);
//
//		Nivå nivå = new Nivå(rumA, rumLista); // Start in rumA
//
//		Scanner scanner = new Scanner(System.in);
//		String input = "";
//		System.out.println("Du är nu i rum: " + nivå.getCurrentRum().getGolvfärg());
//
//		while (!input.equals("exit")) {
//			System.out.println("Gå till (ÖSTER/VÄSTER), skriv 'exit' för att avsluta:");
//			input = scanner.nextLine().toUpperCase();
//
//			try {
//				if (input.equals("ÖSTER") || input.equals("VÄSTER")) {
//					nivå.hoppaÅt(Väderstreck.valueOf(input));
//					System.out.println("Du är nu i rum: " + nivå.getCurrentRum().getGolvfärg());
//				}
//			} catch (IllegalArgumentException e) {
//				System.out.println("Du kan inte gå åt det hållet.");
//			}
//		}
//		scanner.close();
//	}
}
