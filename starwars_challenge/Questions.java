package starwars_challenge;

import java.util.Scanner;

/**
 * Star Wars name generaror
 * 
 * @author Pawel Hydzik
 * @version 1.0
 * @since 30/09/2020
 */

public class Questions {

    public static Scanner kboard = new Scanner(System.in);

    /**
     * Create objects of the Class Input and NameGenerator
     * Object userDetails contains all user inputs
     * Object NameGenerator handles the method responsible for the name generating
     */
    User userDetails = new User();
    NameGenerator generator = new NameGenerator();

    public void askUser() {

        System.out.println("Welcome to Star Wars Name Generator");
        System.out.println("");

        /**
         * Gather user inputs
         */
        System.out.println("What is your name ?");
        userDetails.setName(kboard.next().toLowerCase());

        System.out.println("What is your surname ?");
        userDetails.setSurname(kboard.next().toLowerCase());

        System.out.println("What is your mother's maiden name ?");
        userDetails.setMaidenName(kboard.next().toLowerCase());

        System.out.println("What is your place of birth ?");
        userDetails.setPOB(kboard.next().toLowerCase());

        kboard.close();

        /**
         * Pass gathered data from user to appriopriate methods and generate Star Wars
         * name
         */
        generator.generateStarWarsName(userDetails);
        generator.generateStarWarsSurname(userDetails);

        /**
         * Display the name to the user
         * (call the getString method by passing ArrayList letters by a getter)
         */
        generator.displayStarWarsName(generator.getString(generator.getList()));

    }

}
