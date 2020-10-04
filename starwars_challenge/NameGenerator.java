package starwars_challenge;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Star Wars name generaror
 * 
 * @author Pawel Hydzik
 * @version 1.0
 * @since 30/09/2020
 */

public class NameGenerator {

    public static Scanner kboard = new Scanner(System.in);

    /**
     * Arraylist which stores characters needed for generating Star Wars name
     */
    private ArrayList<Character> letters = new ArrayList<>();

    /**
     * Create object of a class Input containing user inputs  
     */
    Input userDetails = new Input();

    public void askUser() {

        System.out.println("Welcome to Star Wars Name Generator");
        System.out.println("");

        /**
         * Gather user inputs
         */
        System.out.println("What is your name ?");

        //userDetails.setName(kboard.next().toLowerCase());


        while (!kboard.hasNext()) {

            System.out.println("wrong ");
            kboard.next();


            if (kboard.hasNext()) {

                System.out.println("What is your name ?");
                userDetails.setName(kboard.next().toLowerCase());
    
            }
           // break;

        }

        

        System.out.println("What is your surname ?");
        userDetails.setSurname(kboard.next().toLowerCase());

        System.out.println("What is your mother's maiden name ?");
        userDetails.setMaidenName(kboard.next().toLowerCase());

        System.out.println("What is your place of birth ?");
        userDetails.setPOB(kboard.next().toLowerCase());

        kboard.close();

        /**
         * Pass gathered data from user to appriopriate methods and generate Star Wars name
         */
        generateStarWarsName(userDetails);
        generateStarWarsSurname(userDetails);

        /**
         * Display the name to the user
         */
        displayStarWarsName(getString(letters));

    }

    public void generateStarWarsName(Input userDetails) {

        for (int i = 0; i < 3; i++) {

            letters.add(userDetails.getSurname().charAt(i));

        }

        for (int i = 0; i < 2; i++) {

            letters.add(userDetails.getName().charAt(i));

        }

    }

    public void generateStarWarsSurname(Input userDetails) {

        for (int i = 0; i < 2; i++) {

            letters.add(userDetails.getMaidenName().charAt(i));

        }

        for (int i = 0; i < 3; i++) {

            letters.add(userDetails.getPOB().charAt(i));

        }

    }

    public void displayStarWarsName(String fullname) {

        /**
         * Substing method used to splitting fullname into 2 separate strings 
         */
        String swName = fullname.substring(0, 1).toUpperCase() + fullname.substring(1, 5);
        String swSurname = fullname.substring(5, 6).toUpperCase() + fullname.substring(6, 10);

        System.out.println("Your Star Wars name is " + swName + " " + swSurname);

    }

    /**
     * StringBuilder class is used to convert ArrayList of Characters to String
     * https://docs.oracle.com/javase/tutorial/java/data/buffers.html
     * 
     * @param letters
     * @return string consisting of all characters combined in the ArrayList letters
     */

    public String getString(ArrayList<Character> letters) {

        StringBuilder builder = new StringBuilder(letters.size());
        for (Character ch : letters) {
            builder.append(ch);
        }
        return builder.toString();
    }
}
