package module.documents;

import graphics.BGSetter;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.FileReader;
import java.io.IOException;

/**
 * <strong><big>开发日志  Develop Log</big></strong>
 *
 * <p>展示游戏的开发日志。</p>
 *
 * @author 分柿方橙
 * @version ver 1.0 (2021.7.7)
 * @since ver 1.1.1 (2021.7.7)
 */
public class Develop {
    Button toHelpDoc = new Button("帮助");
    Button closePane = new Button("关闭");

    Stage DevDocStage = new Stage();

    /**
     * 构造方法：创建新窗口
     */
    public Develop(){
        /* 打开背景图 */
        BGSetter.Develop.setX(0);
        BGSetter.Develop.setY(0);

        FlowPane mainStartBg = new FlowPane(BGSetter.Develop);
        mainStartBg.setStyle("-fx-background-color: ALICEBLUE");

        /* 读取帮助文档 */
        StringBuilder sbHelpDoc = new StringBuilder();
        String text = null;
        try {
            FileReader file = new FileReader("src/Module/Documents/Develop.txt");
            int chara;
            while( (chara = file.read()) != -1) {
                sbHelpDoc.append((char)chara);
                text = sbHelpDoc.toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
            text = "未找到相应文件。\n请从官方网站下载本游戏；请勿随意删除游戏组件，否则可能引起游戏崩溃！";
        }
        TextArea textArea = new TextArea(text);
        textArea.setFont(Font.font("Arial", 16));
        textArea.setWrapText(true);
        textArea.setPrefWidth(400);
        textArea.setPrefHeight(340);
        textArea.setLayoutX(70);
        textArea.setLayoutY(200);
        textArea.setStyle("-fx-background-color: ALICEBLUE");
        textArea.setOpacity(.80f);
        textArea.setEditable(false);

        /* 按钮：帮助 */
        toHelpDoc.setOnAction(this::preButHelpDoc);
        toHelpDoc.setFont(Font.font("Arial",20));
        toHelpDoc.setLayoutX(90);
        toHelpDoc.setLayoutY(550);
        toHelpDoc.setPrefWidth(70);
        toHelpDoc.setPrefHeight(45);

        /* 按钮：关闭 */
        closePane.setOnAction(this::preButClosePane);
        closePane.setFont(Font.font("Arial",20));
        closePane.setLayoutX(390);
        closePane.setLayoutY(550);
        closePane.setPrefWidth(70);
        closePane.setPrefHeight(45);

        Group root = new Group(mainStartBg, textArea, toHelpDoc, closePane);

        Scene mainStartScene = new Scene(root, 528, 636, Color.ALICEBLUE);

        DevDocStage.setTitle("Mine Sweeper");
        DevDocStage.setScene(mainStartScene);
        DevDocStage.setResizable(false);
        DevDocStage.show();
    }

    /**
     * 前往帮助页
     *
     * @param actionEvent 点击“帮助”
     */
    private void preButHelpDoc(ActionEvent actionEvent) {
        /* 关闭窗口 */
        Stage primaryStage = (Stage)closePane.getScene().getWindow();
        primaryStage.close();
        /* 打开帮助 */
        Help open  = new Help();

    }

    /**
     * 关闭窗口
     *
     * @param actionEvent 点击“关闭”
     */
    private void preButClosePane(ActionEvent actionEvent) {
        /* 关闭窗口 */
        Stage primaryStage = (Stage)closePane.getScene().getWindow();
        primaryStage.close();
    }


}