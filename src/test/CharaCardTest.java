package test;

import bean.Game;
import bean.Save;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import module.charaBox.BluCard;
import module.charaBox.CharaCard;
import module.charaBox.RedCard;
import module.charaBox.SequenceSetter;
import resources.graphics.ICSetter;

public class CharaCardTest extends Application {

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();

        Save.game = new Game(3,3,3,(byte)2,(byte)2,(byte)2,
                true,true,false,false,
                true,1,1,true,true,true,
                1,1,new byte[1][2],new String[2][3],false);

        Group redCardGroup = new Group();
        CharaCard redCard = new RedCard(redCardGroup);
        redCardGroup.setLayoutX(50);
        root.getChildren().addAll(redCardGroup);


        Group blueCardGroup = new Group();
        CharaCard bluCard = new BluCard(blueCardGroup);
        blueCardGroup.setLayoutX(50);
        blueCardGroup.setLayoutY(500);
        root.getChildren().addAll(blueCardGroup);

        redCard.name.setText("222");
        redCard.life4.setImage(null);
        redCard.stepLeft.setText("223");
        bluCard.status.setImage(ICSetter.FishBlu);
        SequenceSetter.sequenceSetter(redCardGroup,blueCardGroup,new Group(), new Group());

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
