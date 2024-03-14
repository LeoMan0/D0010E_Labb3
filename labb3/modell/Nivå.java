package labb3.modell;


import java.util.ArrayList;
import java.util.Observable;


// This class contains all the roams of the level and what room we are in
// as well as away to change what room we are in.

public class Nivå extends Observable {

    private Rum currentRum;
    private ArrayList<Rum> rumLista;

    public Nivå(Rum startrum, ArrayList<Rum> rumLista) {
        this.rumLista = rumLista;
        if (rumLista.contains(startrum)) {
            this.currentRum = startrum;
        } else {
            throw new IllegalArgumentException("Rum does not exist");
        }


        // Here we just check if there are any rooms are overlapping with some math.
        // By checking all rooms against all other rooms
        for (int i = 0; i < rumLista.size(); i++) {
            for (int j = i + 1; j < rumLista.size(); j++) {
                Rum rum1 = rumLista.get(i);
                Rum rum2 = rumLista.get(j);

                boolean overlap = rum1.getÖvX() < rum2.getÖvX() + rum2.getBredd() &&
                        rum1.getÖvX() + rum1.getBredd() > rum2.getÖvX() &&
                        rum1.getÖvY() < rum2.getÖvY() + rum2.getHöjd() &&
                        rum1.getÖvY() + rum1.getHöjd() > rum2.getÖvY();

                if (overlap) {
                    //throw new IllegalArgumentException("Overlapping rooms unlucky");
                }

            }
        }


    }

    public ArrayList<Rum> getRumLista() {
        return rumLista;
    }


    public Rum getCurrentRum() {
        return this.currentRum;
    }


    // Changes room by changing the current room.
    public void hoppaÅt(Väderstreck väderstreck) {

        this.currentRum = currentRum.vartHamnarJag(väderstreck);
        setChanged(); // Mark this Observable as having been changed
        notifyObservers(); // Notify all of its observers

    }


}
