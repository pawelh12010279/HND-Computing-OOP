package main;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

/**
 * JavaFX Controller class
 */
public class Controller {

    private Level level = new Level();

    @FXML
    private BorderPane table = new BorderPane(); //borderpane with title, level selector and game board in the centre
    @FXML
    private GridPane board; //main Sokoban board located in the centre of the borderpane
    @FXML
    private ChoiceBox<String> levelChoice = new ChoiceBox<>(); //level selector

    /**
     * Initialize method
     */
    public void initialize() {

        drawMap();

    }

    /**
     * Method for drawing the game map on the board (gridpane)
     */
    public void drawMap() {

        for (int i = 0; i < level.getMap().size(); i++) {

            for (int j = 0; j < level.getMap().get(i).size(); j++) {

                board.add(level.getMap().get(i).get(j), j, i);

            }

        }

    }

}
