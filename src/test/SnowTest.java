package test;

import module.animation.Smog;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SnowTest extends Application {

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Group smogSet = new Group();
        new Smog(smogSet);
        root.getChildren().addAll(smogSet);

        Scene scene = new Scene(root, 1900,960, Color.BLACK);

        primaryStage.setTitle("Mine Sweeper");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
