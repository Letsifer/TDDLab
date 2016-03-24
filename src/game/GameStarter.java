package game;

import java.util.Scanner;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import logic.MoveResults;
import logic.Structure;
import static javafx.application.Application.launch;

/**
 *
 * @author gea
 */
public class GameStarter extends Application{
    
    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("/game/Interface.fxml"));

            Scene scene = new Scene(fXMLLoader.load());

            GameController controller = (GameController)fXMLLoader.getController();
            controller.initStructure(4, 512, primaryStage);
            
            primaryStage.setTitle("Игра 512");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
