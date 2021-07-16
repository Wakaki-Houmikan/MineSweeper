package test;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import module.animation.Snow;
import module.menubar.MenuBarInGame;
import resources.musics.BGMPlayer;

public class BGMPlayerTest extends Application {

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Group snowSet = new Group();
        new Snow(snowSet);
        root.getChildren().addAll(snowSet);

        Group menubar = new Group();
        new MenuBarInGame(menubar);
        root.getChildren().addAll(menubar);

        BGMPlayer.musicStart(4);

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
