package ObjectPontoonJFX.src;

public class Card extends Check {

    /**
     * Class attributes
     */
    private int cardValue;

    /**
     * Constructor for the class Card
     */
    public Card() {

        cardValue = (int) (Math.random() * 10) + 1;

    }

    /**
     * Getter for the instanced variables of the class Card
     * 
     * @return randomised card value in 1-10 range
     */
    public int getCard() { // getter

        return cardValue;

    }

    /**
     * Setter for the instance varaibles for the class Card
     * 
     * @param newCard
     */
    public void setCard(int newCard) { // setter

        this.cardValue = newCard;

    }

    /**
     * Method for drawing a new card
     * 
     * @return newly drawn card
     */
    public int drawCard() {

        setCard((int) (Math.random() * 10) + 1);

        int newCard = getCard();

        return newCard;

    }

} // end class