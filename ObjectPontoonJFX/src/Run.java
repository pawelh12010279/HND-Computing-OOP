package ObjectPontoonJFX.src;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Run extends Application {

    public static void main(String[] args) {

        launch(args);

     //   Pontoon game = new Pontoon();
      //  game.startGame();

    }

    @Override
    public void start(Stage mainStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("Layout.fxml"));
        mainStage.setTitle("Pontoon - Lidl version");

        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();

    }
}
