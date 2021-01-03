package main;

import javafx.application.Platform;
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
    private Label movesCounter; //label for displaying no. of moves

    @FXML
    private Button button1; //level selection buttons
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private Button button4;
    @FXML
    private Button button5;


    /**
     * Initialize method
     */
    public void initialize() {

        new Thread(() -> {

            //Button handlers
            button1.setOnAction((event) -> {
                level = new Level("./src/main/resources/SokobanMaps/level1.txt");
                updateMap();
                keyCounter = 0;
                movesCounter.setText(Integer.toString(keyCounter));
            });

            button2.setOnAction((event) -> {
                level = new Level("./src/main/resources/SokobanMaps/level2.txt");
                updateMap();
                keyCounter = 0;
                movesCounter.setText(Integer.toString(keyCounter));
            });

            button3.setOnAction((event) -> {
                level = new Level("./src/main/resources/SokobanMaps/level3.txt");
                updateMap();
                keyCounter = 0;
                movesCounter.setText(Integer.toString(keyCounter));
            });

            button4.setOnAction((event) -> {
                level = new Level("./src/main/resources/SokobanMaps/level4.txt");
                updateMap();
                keyCounter = 0;
                movesCounter.setText(Integer.toString(keyCounter));
            });

            button5.setOnAction((event) -> {
                level = new Level("./src/main/resources/SokobanMaps/level5.txt");
                updateMap();
                keyCounter = 0;
                movesCounter.setText(Integer.toString(keyCounter));
            });

            //execute the key handler LATER AFTER level object has been instanciated and map has been drawn for the first time (otherwise it doesn't work)
            Platform.runLater(() -> board.getScene().setOnKeyPressed(event -> {

                switch (event.getCode()) {
                    case W -> {
                        level.move(-1, 0);
                        updateMap();
                        keyCounter++;
                    }
                    case S -> {
                        level.move(1, 0);
                        updateMap();
                        keyCounter++;
                    }
                    case A -> {
                        level.move(0, -1);
                        updateMap();
                        keyCounter++;
                    }
                    case D -> {
                        level.move(0, 1);
                        updateMap();
                        keyCounter++;
                    }
                }
                movesCounter.setText(Integer.toString(keyCounter));
            }));
        }).start();

    }

    /**
     * Method run after each move to recreate a map, and run a
     */
    private void updateMap() {

        board.getChildren().clear(); // remove all items from the gridpane and draw map anew with each move
        drawMap();

        if (level.checkLevelCompleted()) { //check if the level is completed

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Well Done!");
            alert.setHeaderText("Level complete !");
            alert.setContentText("All crates has been correctly placed :)");

            alert.showAndWait();
        }

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

}
