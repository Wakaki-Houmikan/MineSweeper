package test;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import module.animation.Snow;
import module.menubar.MenuBarInGame;
import musics.BGMPlayer;

public class MenuBarTest extends Application {

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();

            Group smogSet = new Group();
            new Snow(smogSet);
            root.getChildren().addAll(smogSet);

//        for (int i = 0; i <= 10; i++){
//            Group smogSet = new Group();
//            new Snow(smogSet);
//            root.getChildren().addAll(smogSet);
//
//        }
        Group menubar = new Group();
        new MenuBarInGame(menubar);
        root.getChildren().addAll(menubar);
        BGMPlayer.setVolume(0.12);
        BGMPlayer.musicStart(5);

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
