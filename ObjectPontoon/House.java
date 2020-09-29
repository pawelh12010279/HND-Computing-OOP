package ObjectPontoon;

public class House {

    private int houseMin = 16;

    Card card1 = new Card(); // create 2 cards for house
    Card card2 = new Card();

    public int houseCards() { // reroll houses cards if lower than 16

        int house = 0;
        house = Card.calcTotal(card1.getCard(), card2.getCard());

        while (house < houseMin) {

            house = Card.calcTotal(card1.drawCard(), card2.drawCard());

        }

        return house;

    }

    public House() { // constructor

        houseCards();

    }
}
