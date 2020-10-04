package starwars_challenge;

import java.util.ArrayList;

/**
 * Star Wars name generaror
 * 
 * @author Pawel Hydzik
 * @version 1.0
 * @since 30/09/2020
 */

public class NameGenerator {

    /**
     * Arraylist which stores characters needed for generating Star Wars name
     */
    private ArrayList<Character> characters = new ArrayList<>();

    /**
     * Getter for the ArrayList letters
     * @return
     */
    public ArrayList<Character> getList() {

        return characters;

    }

    public void generateStarWarsName(User userDetails) {

        for (int i = 0; i < 3; i++) {

            characters.add(userDetails.getSurname().charAt(i));

        }

        for (int i = 0; i < 2; i++) {

            characters.add(userDetails.getName().charAt(i));

        }

    }

    public void generateStarWarsSurname(User userDetails) {

        for (int i = 0; i < 2; i++) {

            characters.add(userDetails.getMaidenName().charAt(i));

        }

        for (int i = 0; i < 3; i++) {

            characters.add(userDetails.getPOB().charAt(i));

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
