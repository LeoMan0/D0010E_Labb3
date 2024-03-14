package labb3.modell;

import java.awt.Color;
import java.util.ArrayList;

public class Rum {

    private ArrayList<Gång> rumetsGångar = new ArrayList<>();
    private Color golvfärg;
    private int bredd, höjd;
    private int övX, övY;
    private Rum[] vägar = new Rum[4];


    public Rum(Color golvfärg, int bredd, int höjd, int övX, int övY) {
        
        this.golvfärg = golvfärg;
        this.bredd = bredd;
        this.höjd = höjd;
        this.övX = övX;
        this.övY = övY;
    }

    public static void kopplaIhop(Rum från, Väderstreck riktningUtUrFrån,
                                  Rum till, Väderstreck riktningInITill) {


        från.vägar[riktningUtUrFrån.index()] = till; // Kopplar från-rummet till till-rummet i angiven riktning
        till.vägar[riktningInITill.index()] = från; // Kopplar till-rummet till från-rummet i angiven riktning


        från.rumetsGångar.add(new Gång(från, riktningUtUrFrån, till, riktningInITill));
        //till.rumetsGångar.add(new Gång(till, riktningInITill, från, riktningUtUrFrån));


    }

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


    public boolean finnsUtgångÅt(Väderstreck väderstreck) {
        return vägar[väderstreck.index()] != null;
    }

    public Rum vartHamnarJag(Väderstreck väderstreck) {
        if (this.finnsUtgångÅt(väderstreck)) {
            return vägar[väderstreck.index()];
        } else {
            throw new IllegalArgumentException("Ingen utgång i den här riktningen");
            //return this;

            // Gång gångenÅt(Väderstreck väderstreck) som
            //
            // returnerar den gång som leder från ett rum i riktning väderstreck. Om
            // sådan gång saknas ska ett undantag kastas med lämpligt felmeddelande.
        }
    }


}
