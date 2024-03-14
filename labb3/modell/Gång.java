package labb3.modell;

import labb3.verktyg.Punkt;


import static labb3.GlobalaKonstanter.*;


public class Gång {


    private Rum från;
    private Rum till;

    private Väderstreck riktningUtUrFrån;
    private Väderstreck riktningInITill;


    public Gång(Rum från, Väderstreck riktningUtUrFrån, Rum till,
                Väderstreck riktningInITill) {
        this.från = från;
        this.till = till;
        this.riktningUtUrFrån = riktningUtUrFrån;
        this.riktningInITill = riktningInITill;


    }

    public Punkt[] getPunktPairs() {

        // The first two Punkts are the punkts for från and the other two for till

        Punkt[] PunktPairs = new Punkt[4];


        System.arraycopy(this.punktPair(this.från, this.riktningUtUrFrån), 0, PunktPairs, 0, 2);
        System.arraycopy(this.punktPair(this.till, this.riktningInITill), 0, PunktPairs, 2, 2);

        return PunktPairs;
    }


    private Punkt[] punktPair(Rum rum, Väderstreck väderstreck) {


        // Creates the pair of punkts to draw the paths in målarduk.

        int x = rum.getÖvX();
        int y = rum.getÖvY();
        int width = rum.getBredd();
        int height = rum.getHöjd();

        Punkt[] punktPair = new Punkt[2];


        switch (väderstreck) {
            case NORR:
                punktPair[0] = new Punkt(x + width / 2, y);
                punktPair[1] = new Punkt(x + width / 2, y + VÄGGTJOCKLEK);
                break;
            case SÖDER:
                punktPair[0] = new Punkt(x + width / 2, y + height);
                punktPair[1] = new Punkt(x + width / 2, y + height - VÄGGTJOCKLEK);
                break;
            case ÖSTER:
                punktPair[0] = new Punkt(x + width, y + height / 2);
                punktPair[1] = new Punkt(x + width - VÄGGTJOCKLEK, y + height / 2);
                break;
            case VÄSTER:
                punktPair[0] = new Punkt(x, y + height / 2);
                punktPair[1] = new Punkt(x + VÄGGTJOCKLEK, y + height / 2);
                break;
        }


        return punktPair;
    }


}
