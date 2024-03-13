package labb3.modell;


public enum Väderstreck {

    // This class is done
    // This class is cosmetic, and it only use is to be able to use the
    // words NORR etc. instead of 0,1,2, and 3, but I digress

    // NORR.index() returnerar 0,
    // ÖSTER.index() returnerar 1,
    // SÖDER.index() returnerar 2 och
    // VÄSTER.index() returnerar 3.


    NORR(0), ÖSTER(1), SÖDER(2), VÄSTER(3);

    private final int index;

    Väderstreck(int index) {
        this.index = index;
    }

    public int index() {
        return this.index;
    }

}




