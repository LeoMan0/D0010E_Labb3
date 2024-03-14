package labb3.modell;

import java.awt.Color;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Rum {


    // TODO: Lägg till tillståndsvariabler.
    private ArrayList<Gång> rumetsGångar = new ArrayList<>();


    private Color golvfärg;
    private int bredd, höjd;

    private int övX, övY;


    private Rum[] vägar = new Rum[4];


    public Rum(Color golvfärg, int bredd, int höjd, int övX, int övY) {
        // TODO: Kopiera parametrarna in i tillståndsvariablerna. (övX,övY) är
        // koordinaten för rummets övre vänstra hörn och lagras lämpligen som en
        // instans av klassen Punkt i paketet verktyg.


        this.golvfärg = golvfärg;
        this.bredd = bredd;
        this.höjd = höjd;
        this.övX = övX;
        this.övY = övY;


    }

    public static void kopplaIhop(Rum från, Väderstreck riktningUtUrFrån,
                                  Rum till, Väderstreck riktningInITill) {

        // Here I have to access the Rum från and change it so that
        // från vägar[riktningUtUrFrån.index()] = till
        // and
        // till vägar[riktningInITill.index()] = från

        från.vägar[riktningUtUrFrån.index()] = till; // Kopplar från-rummet till till-rummet i angiven riktning
        till.vägar[riktningInITill.index()] = från; // Kopplar till-rummet till från-rummet i angiven riktning


        från.rumetsGångar.add(new Gång(från, riktningUtUrFrån, till, riktningInITill));
        till.rumetsGångar.add(new Gång(till, riktningInITill, från, riktningUtUrFrån));


    }

    public static void main(String[] args) {
        //Rum testRum = new Rum(Color.BLUE, 10, 20, 0, 0);

        // Använd getters för att skriva ut information om rummet
//		System.out.println("Golvfärg: " + testRum.getGolvfärg());
//		System.out.println("Bredd: " + testRum.getBredd());
//		System.out.println("Höjd: " + testRum.getHöjd());
//		System.out.println("ÖvX: " + testRum.getÖvX());
//		System.out.println("ÖvY: " + testRum.getÖvY());


//		Rum rum1 = new Rum(Color.BLUE, 10, 20, 0, 0);
//		Rum rum2 = new Rum(Color.RED, 15, 25, 5, 5);
//
//		// Koppla ihop rum1 och rum2
//		kopplaIhop(rum1, Väderstreck.NORR, rum2, Väderstreck.SÖDER);
//
//		// Testa och se om kopplingen fungerar
//		System.out.println("Rum kopplat från rum1 åt NORR: " + (rum1.finnsUtgångÅt(Väderstreck.NORR) ? "Ja" : "Nej"));
//		System.out.println("Rum kopplat från rum2 åt SÖDER: " + (rum2.finnsUtgångÅt(Väderstreck.SÖDER) ? "Ja" : "Nej"));
    }

    // TODO: Skriv "getters", metoder som returnerar tillståndsvariablernas
    // värden.
    public Color getGolvfärg() {
        return golvfärg;
    }

    public int getBredd() {
        return bredd;
    }

    public int getHöjd() {
        return höjd;
    }

    public int getÖvX() {
        return övX;
    }

    public int getÖvY() {
        return övY;
    }

    public ArrayList<Gång> getRumetsGångar() {
        return rumetsGångar;
    }

    //
    // som ska kontrollera om det från ett rum finns en utgång åt visst
    // väderstreck.

    // TODO: Skriv instansmetoden
    //
    // Gång gångenÅt(Väderstreck väderstreck) som
    //
    // returnerar den gång som leder från ett rum i riktning väderstreck. Om
    // sådan gång saknas ska ett undantag kastas med lämpligt felmeddelande.

    // TODO: Skrivklar metoden nedan som kopplar ihop två rum med en gång.

    // TODO: Skriv instansmetoden
    //
    public boolean finnsUtgångÅt(Väderstreck väderstreck) {
        return vägar[väderstreck.index()] != null;
    }

    public Rum vartHamnarJag(Väderstreck väderstreck) {
        if (this.finnsUtgångÅt(väderstreck)) {
            return vägar[väderstreck.index()];
        } else {
            throw new IllegalArgumentException("Ingen utgång i den här riktningen");
            // This could be changed to just be the Rum object itself maybe
            // Technically it would work the same but if I where to do
            // more stuff with this project I wouldn't want it to since
            // It would redraw everything
        }
    }


}
