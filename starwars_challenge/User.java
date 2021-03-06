package starwars_challenge;

/**
 * Star Wars name generaror
 * 
 * @author Pawel Hydzik
 * @version 1.0
 * @since 30/09/2020
 */

public class User {

    /**
     * Class attributes
     */
    private String surname;
    private String name;
    private String maidenName;
    private String POB;

    /**
     * Setters for the Input class variables
     * 
     * @param name sets the encapsulated instance variable name
     */
    public void setName(String name) {

        this.name = name;

    }

    public void setSurname(String surname) {

        this.surname = surname;

    }

    public void setMaidenName(String maidenName) {

        this.maidenName = maidenName;

    }

    public void setPOB(String POB) {

        this.POB = POB;

    }

    /**
     * Getters for the Input class variables
     * 
     * @return passes back the encapsulated instance variables
     */
    public String getName() {

        return name;

    }

    public String getSurname() {

        return surname;

    }

    public String getMaidenName() {

        return maidenName;

    }

    public String getPOB() {

        return POB;

    }

   /* public String toString() {

        return name + "" + surname + "" + maidenName + "" + POB;
    } */

}
