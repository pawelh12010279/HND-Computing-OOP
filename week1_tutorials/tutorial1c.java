package week1_tutorials;

import java.util.Scanner;

public class tutorial1c {

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

    public static void main(String[] args) {

        Scanner kboard = new Scanner(System.in);

        String choice;
        int card1, card2, new_card, total, house, houseMin = 16;

        card1 = getRandomNumber();
        card2 = getRandomNumber();
        total = calcTotal(card1, card2);

        house = houseCards(houseMin);

        System.out.println("You have drawn " + card1 + " and " + card2);
        
        System.out.println("Do you wish to draw another card? y/n");
        choice = kboard.next();

        while  (choice.equalsIgnoreCase("y")) {

            new_card = getRandomNumber();
            System.out.println(new_card);
            total = new_card + total;

            if (busted(total) == true) {

                System.out.println("BOOOOOOOOOOOOOOOOOOSTED");
                break;

            } else {

                System.out.println("Do you wish to draw another card?");
                choice = kboard.next();

            }

        } //end while

        if (getResult(total, house) == true) {

            System.out.println("You have won with a total of " +total+ ", house drew " + house);

        } else {

            System.out.println("You have lost with a total of " +total+ ", house drew " + house);

        }

        kboard.close();

    } //end main

}