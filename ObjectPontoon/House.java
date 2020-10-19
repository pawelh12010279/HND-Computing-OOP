package ObjectPontoon;

public class House {

    private int houseMin = 16;

    /**
     * Initialize 2 object of the class Card for the house player
     */
    Card card1 = new Card(); 
    Card card2 = new Card();

    /**
     * Method for rerolling houses cards if lower than 16
     * @return value higher than 16
     */
    public int houseCards() { 

        int house = 0;
        house = Check.calcTotal(card1.getCard(), card2.getCard());

        while (house < houseMin) {

            house = Check.calcTotal(card1.drawCard(), card2.drawCard());

        }

        return house;

    }

    /**
     * Constructor
     */
    public House() { 

        houseCards();

    }
}
