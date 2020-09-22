package week1_tutorials;

import java.util.Scanner;

public class tutorial1 {

    public static void main(String[] args) {

        Scanner kboard = new Scanner(System.in);

        String choice;
        int card1, card2, new_card, total;

        card1 = (int)(Math.random() * 10) +1;
        card2 = (int)(Math.random() * 10) +1;
        total = card1 + card2;

        System.out.println("You have drawn " + card1 + " and " + card2);
        
        System.out.println("Do you wish to draw another card? y/n");
        choice = kboard.next();

        while  (choice.equalsIgnoreCase("y")) {

            new_card = (int)(Math.random() * 10) +1;
            System.out.println(new_card);
            total = new_card + total;
            System.out.println("Do you wish to draw another card?");
            choice = kboard.next();    

        }

        if (total > 19 && total <=21) {

            System.out.println("You have won with a total of " +total);

        } else {

            System.out.println("You have lost with a total of " +total);

        }


        kboard.close();
    }

}
