package ObjectPontoon;

import java.util.Scanner;

public class Pontoon {

    public static Scanner kboard = new Scanner(System.in);

    public void startGame() {

        String choice;
        int total;

        /**
         * Create an object of a class for house
         */
        House house = new House(); 

        /**
         * New player get 2 cards
         */
        Card card1 = new Card(); 
        Card card2 = new Card();

        /**
         * Show total for first 2 cards drawn
         */
        total = Card.calcTotal(card1.getCard(), card2.getCard());

        System.out.println("You have drawn " + card1.getCard() + " and " + card2.getCard());
        System.out.println("Current hand: " + total);

        /**
         * Ask for user input
         */
        System.out.println("Do you wish to draw another card? y/n");
        choice = kboard.next();

        /**
         * Verify user input
         */
        while (choice.equalsIgnoreCase("y")) {

            Card card3 = new Card();
            System.out.println("Card drawn = " + card3.getCard());
            total = Card.calcTotal(total, card3.getCard());
            System.out.println("Current hand: " + total);

            if (Card.busted(total) == true) {

                System.out.println("Busted!, your score was " + total + " which is over 21");
                break;

            } else {

                System.out.println("Do you wish to draw another card? y/n");
                choice = kboard.next();

            }

        } // end while

        if (Card.getResult(total, house.houseCards()) == true) {

            System.out.println("You have won with a total of " + total + ", house scored " + house.houseCards());
            // displayCards(cardsDrawn);

        } else {

            System.out.println("You have lost with a total of " + total + ", house scored " + house.houseCards());
            // displayCards(cardsDrawn);

        }

    }

}
