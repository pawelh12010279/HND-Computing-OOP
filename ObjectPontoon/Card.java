package ObjectPontoon;

public class Card {

    private int cardValue;

    public Card() { // constructor

        cardValue = (int) (Math.random() * 10) + 1;

    }

    public int getCard() { // getter

        return cardValue;

    }

    public void setCard(int newCard) { // setter

        this.cardValue = newCard;

    }

    public int drawCard() { // method for card drawing

        setCard((int) (Math.random() * 10) + 1);

        int newCard = getCard();

        return newCard;

    }

    // static method to calc total of both cards
    public static int calcTotal(int card1, int card2) {

        return (card1 + card2);

    }

    public static boolean busted(int total) {

        if (total > 21) {

            return true;

        } else {

            return false;

        }

    }

    public static boolean getResult(int total, int house) {

        if (total > house && total <= 21) {

            return true;

        } else {

            return false;

        }

    }


} // end class