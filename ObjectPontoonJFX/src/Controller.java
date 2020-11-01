package ObjectPontoonJFX.src;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {
    
    /**
     * FXID's for GUI objects
     */
    @FXML private Label playerCards;
    @FXML private Label houseCards;
    @FXML private Button draw;
    @FXML private Button stick;

    public void drawCard() {
        
    }

    public void displayHand() {
        
    }

    public void message() {
        
        playerCards.setText("test");
    }
}