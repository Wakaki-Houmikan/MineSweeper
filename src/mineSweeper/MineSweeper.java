package mineSweeper;

import resources.documents.Develop;
import module.chooseMode.ChooseMode;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import resources.graphics.BGSetter;

/**
 * <strong><big>Project Mine Sweeper Java Edition</big></strong>
 *
 * @author 久置乙醚工作室 · 分柿方橙Spikey
 * @version ver 1.0 (2021.7.1)
 * @since ver 1.0.0 (2021.7.1)
 */
public class MineSweeper extends Application {

    Button startGame = new Button("开始游戏");//开始游戏
    Button loadGame = new Button("读取存档");//读取存档
    Button rankingList = new Button("排行榜");//排行榜
    Button developLog = new Button("开发日志");//开发日志

    public void start(Stage primaryStage){
        /* 展示背景 */
        BGSetter.Main.setX(0);
        BGSetter.Main.setY(0);
        FlowPane mainStartBg = new FlowPane(BGSetter.Main);
        mainStartBg.setStyle("-fx-background-color: ALICEBLUE");

        /* 按钮：开始游戏 */
        startGame.setOnAction(this::preButStartGame);
        startGame.setFont(Font.font("Arial",28));
        startGame.setLayoutX(180);
        startGame.setLayoutY(230);
        startGame.setPrefWidth(180);
        startGame.setPrefHeight(50);

        /* 按钮：读取存档 */
        loadGame.setOnAction(this::preButLoadGame);
        loadGame.setFont(Font.font("Arial",28));
        loadGame.setLayoutX(180);
        loadGame.setLayoutY(300);
        loadGame.setPrefWidth(180);
        loadGame.setPrefHeight(50);

        /* 按钮：排行榜 */
        rankingList.setOnAction(this::preButRankingList);
        rankingList.setFont(Font.font("Arial",28));
        rankingList.setLayoutX(180);
        rankingList.setLayoutY(370);
        rankingList.setPrefWidth(180);
        rankingList.setPrefHeight(50);

        /* 按钮：开发信息 */
        developLog.setOnAction(this::preButDevelopLog);
        developLog.setFont(Font.font("Arial",28));
        developLog.setLayoutX(180);
        developLog.setLayoutY(440);
        developLog.setPrefWidth(180);
        developLog.setPrefHeight(50);

        Group root = new Group(mainStartBg, startGame, loadGame, rankingList, developLog);

        Scene mainStartScene = new Scene(root, 528, 636, Color.ALICEBLUE);

        primaryStage.setTitle("Mine Sweeper");
        primaryStage.setScene(mainStartScene);
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    /* 点击开始游戏 */
    public void preButStartGame(ActionEvent event) {
        /* 关闭现窗口GameStartPane */
        Stage primaryStage = (Stage)startGame.getScene().getWindow();
        primaryStage.close();
        /* 开启新窗口GameMainPane */
        new ChooseMode();
    }

    public void preButLoadGame(ActionEvent event) {
        /* 点击读取存档后进行的操作 */
//        try {
//            ObjectForSave saveData = (ObjectForSave) ResourceManager.Load("save.txt");
//            System.out.println("yes2");
//            GameData game = saveData.game;
//            CharaData Red = saveData.Red;
//            CharaData Blu = saveData.Blu;
//            CharaData Gre = saveData.Gre;
//            CharaData Pur = saveData.Pur;
//            Time TimeMain = saveData.timeMain;
//            Time TimeChara = saveData.timeChara;
//            int[][] Map = saveData.map;
//            String[][] Status = saveData.status;
//            game.setLoadSave(true);
//            System.out.println(game.isLoadSave());
//            new GameMainPlane(game, Red, Blu, Gre, Pur, TimeMain, TimeChara, Map, Status);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    public void preButRankingList(ActionEvent event) {
//        new RankingPlane();
    }

    public void preButDevelopLog(ActionEvent event) {
        new Develop();
    }

    public static void main(String[] args)
    {
        launch(args);
    }

}
