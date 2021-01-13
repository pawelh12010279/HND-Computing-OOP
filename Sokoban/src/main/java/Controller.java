package main.java;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

/**
 * JavaFX Controller class
 */
public class Controller {

    private Level level; //level object
    private int keyCounter; //variable for storing no. of moves

    @FXML
    private BorderPane table; //borderpane with title, level selector and game board in the centre
    @FXML
    private GridPane board; //main Sokoban board located in the centre of the borderpane
    @FXML
    private Label keyCounterLabel; //label for displaying no. of moves
    @FXML
    private Button button1, button2, button3, button4, button5; //level selection buttons

    /**
     * Initialize method
     */
    public void initialize() {

        new Thread(() -> {

            // Invoke button events
            button1.setOnAction(this::handleButtonAction);
            button2.setOnAction(this::handleButtonAction);
            button3.setOnAction(this::handleButtonAction);
            button4.setOnAction(this::handleButtonAction);
            button5.setOnAction(this::handleButtonAction);

            // Execute the key handler AFTER level object has been instanciated and map has been drawn for the first time (otherwise it doesn't work)
            Platform.runLater(() -> board.getScene().setOnKeyPressed(event -> {

                switch (event.getCode()) {
                    case W -> {
                        level.moveElement(-1, 0);
                        updateMap();
                        keyCounter++;
                        //System.out.println(event.toString());
                    }
                    case S -> {
                        level.moveElement(1, 0);
                        updateMap();
                        keyCounter++;
                        //System.out.println(event.toString());
                    }
                    case A -> {
                        level.moveElement(0, -1);
                        updateMap();
                        keyCounter++;
                        //System.out.println(event.toString());
                    }
                    case D -> {
                        level.moveElement(0, 1);
                        updateMap();
                        keyCounter++;
                        //System.out.println(event.toString());
                    }
                }

                keyCounterLabel.setText(Integer.toString(keyCounter)); //update movesCounter label to display moves on the Scene

            }));

        }).start(); //thread start

    }

    /**
     * Method for drawing the game map on the board (gridpane)
     */
    private void drawMap() {

        for (int i = 0; i < level.getMap().size(); i++) {

            for (int j = 0; j < level.getMap().get(i).size(); j++) {

                board.add(level.getMap().get(i).get(j), j, i);

            }
        }
    }

    /**
     * Method to update the map
     */
    private void updateMap() {

        // remove all items from the gridpane and draw map anew with each move
        board.getChildren().clear();
        drawMap();

        if (level.checkLevelCompleted()) { //check if the level is completed

            Alert alert = new Alert(Alert.AlertType.INFORMATION); //display an pop-up alert informing the user that level has been complete
            alert.setTitle("Well Done!");
            alert.setHeaderText("Level complete !");
            alert.setContentText("Number of moves to complete the level: " + keyCounter);
            alert.showAndWait();

        }

    }

    /**
     * Buttons handler
     *
     * @param event button clicked
     */
    private void handleButtonAction(ActionEvent event) {

        if (event.getSource() == button1) {
            level = new Level();

        } else if (event.getSource() == button2) {
            level = new Level("./src/main/java/resources/SokobanMaps/level2.txt");

        } else if (event.getSource() == button3) {
            level = new Level("./src/main/java/resources/SokobanMaps/level3.txt");

        } else if (event.getSource() == button4) {
            level = new Level("./src/main/java/resources/SokobanMaps/level4.txt");

        } else if (event.getSource() == button5) {
            level = new Level("./src/main/java/resources/SokobanMaps/level5.txt");

        }

        updateMap(); // Initial map draw (in case any level has been drawn before and been bigger in size then remaining nodes must be cleared hence updatemap needs to be run)
        keyCounter = 0; // Set the key counter to 0 on button press
        keyCounterLabel.setText(Integer.toString(keyCounter));

    }
}
