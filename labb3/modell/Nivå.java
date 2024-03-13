package labb3.modell;

import java.util.ArrayList;

// TODO: Gör så att klassen Nivå ärver Observable i paketet java.util. 
public class Nivå  {
	// In Huvudprogram we design the level here is the methods
	// In which room we start in and how we move between the rooms.


	// TODO: Lägg till tillståndsvariabler för att hålla reda på nivåns rum och
	// i vilket rum som användaren "är".

	private Rum currentRum;

	// Nu existerar endast rummen som object i den den efterblivna arraylist rum
	public Nivå(Rum startrum, ArrayList<Rum> rumLista) {
		// TODO: Kopiera in startrum och rum in i tillståndsvariablerna.
		if(rumLista.contains(startrum)){
			this.currentRum = startrum;
		}
		else{
			// TODO: Kontrollera att startrum finns med i rum. Om inte, kasta
			// undantag med lämpligt felmeddelande.
			throw new IllegalArgumentException("Rum does not exist");
		}


		// TODO: Kontrollera att inga rum överlappar varandra. Om det ändå är
		// fallet, kasta undantag med lämpligt felmeddelande.
	}

	// TODO: Skriv en instansmetod som returnerar alla rummen. Denna behöver
	// Målarduk för att veta vilka rum som finns på nivån och som ska ritas ut.

	// TODO Skriv en instansmetod som returnerar en referens till det rum som
	// användaren "är i".

	public Rum getCurrentRum(){
		return this.currentRum;
	}

	// TODO: Skriv klar instansmetoden hoppaÅt nedan så att den ändrar det rum
	// som användaren "är i" om det är möjligt genom att följa en gång från
	// rummet och i riktning väderstreck.
	//
	// Om väderstreck inte är en riktning i vilken det finns en gång, så ändras
	// inte rummet användaren "är i" (och inte heller kastas undantag). (Denna
	// metod använder kontrolldelen av programmet för att begära ett hopp till
	// angränsande rum efter att användaren tryckt på en tangent.)




	// Hoppåt will work like this.
	// First find out in what room i'm supposed to go to.
	// Then just change current room right?

	public void hoppaÅt(Väderstreck väderstreck) {

		  this.currentRum = currentRum.vartHamnarJag(väderstreck);

	}
}
