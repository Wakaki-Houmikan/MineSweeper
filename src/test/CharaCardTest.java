package test;

import bean.Game;
import bean.Save;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import module.charaBox.BluCard;
import module.charaBox.RedCard;

public class CharaCardTest extends Application {

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();

        Save.game = new Game(3,3,3,(byte)2,(byte)2,(byte)2,
                true,true,true,true,
                true,1,1,true,true,true,
                1,1,new byte[1][2],new String[2][3],false);

        Group redCard = new Group();
        RedCard redPanel = new RedCard(redCard);
        redCard.setLayoutX(50);
        root.getChildren().addAll(redCard);


        Group blueCard = new Group();
        new BluCard(blueCard);
        blueCard.setLayoutX(50);
        blueCard.setLayoutY(500);
        root.getChildren().addAll(blueCard);

        redPanel.name.setText("222");
        redPanel.life4.setImage(null);

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
