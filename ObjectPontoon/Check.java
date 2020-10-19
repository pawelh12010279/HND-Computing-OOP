package ObjectPontoon;

public class Check {

    /**
     * static method to calc total of both cards
     */
    public static int calcTotal(int card1, int card2) {

        return (card1 + card2);

    }

    /**
     * Method for checking whether player has went bust (value of cards > 21)
     * 
     * @param total - calculated value of all cards held by player
     * @return boolean value whether player went bust or not
     */
    public static boolean busted(int total) {

        if (total > 21) {

            return true;

        } else {

            return false;

        }

    }

    /**
     * Method for checking whether Player won the game or House
     * 
     * @param total - calculated value of all cards held by player
     * @param house - value of Houses' cards
     * @return boolean value - win = true
     */
    public static boolean getResult(int total, int house) {

        if (total > house && total <= 21) {

            return true;

        } else {

            return false;

        }

    }
}
