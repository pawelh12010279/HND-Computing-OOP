package week1_tutorials;

import java.util.Scanner;

public class tutorial1d {

    public static int getRandomNumber() {

        return (int)(Math.random() * 10) +1;

    }

    public static int calcTotal(int card1, int card2) {

        return (card1 + card2);

    }

    public static boolean getResult(int total, int house) {

        if (total > house && total <=21) {

            return true;

        } else {

            return false;

        }
        
    }

    public static boolean busted(int total) {
        
        if (total > 21) {

            return true;

        } else {

            return false;

        }

    }

    public static int houseCards(int houseMin) {
        
        int house = 0;

        while (house < houseMin) {

            house = calcTotal(getRandomNumber(), getRandomNumber());    

        }

        return house;

    }

    public static void displayCards(int cardsDrawn[]) {

        System.out.print("Your cards = ");

        for (int i = 1; i < 10; i++) {

            if  (cardsDrawn[i] != 0) {

                if (i == 1) {

                    System.out.print(cardsDrawn[i]);

                } else {

                    System.out.print(", " + cardsDrawn[i]);

                }
            }
        }

        System.out.println();
        
    }

    public static void main(String[] args) {

        Scanner kboard = new Scanner(System.in);

        String choice;
        int card1, card2, new_card, total, house, houseMin = 16, cardCount = 3, cardsDrawn[] = new int[10];

        house = houseCards(houseMin);
        cardsDrawn[0] = house;

        card1 = getRandomNumber();
        cardsDrawn[1] = card1;
        card2 = getRandomNumber();
        cardsDrawn[2] = card2;
        total = calcTotal(card1, card2);

        System.out.println("You have drawn " + card1 + " and " + card2);
        
        System.out.println("Do you wish to draw another card? y/n");
        choice = kboard.next();

        while  (choice.equalsIgnoreCase("y")) {

            new_card = getRandomNumber();
            cardsDrawn[cardCount++] = new_card;
            System.out.println("Card drawn = " + new_card);
            total = calcTotal(new_card, total);

            if (busted(total) == true) {

                System.out.println("Busted");
                displayCards(cardsDrawn);
                break;

            } else {

                System.out.println("Do you wish to draw another card? y/n");
                choice = kboard.next();

            }

        } //end while

        if (getResult(total, house) == true) {

            System.out.println("You have won with a total of " +total+ ", house scored " + house);
            displayCards(cardsDrawn);

        } else {

            System.out.println("You have lost with a total of " +total+ ", house scored " + house);
            displayCards(cardsDrawn);

        }

        kboard.close();

    } //end main

}