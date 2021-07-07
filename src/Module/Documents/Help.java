package Module.Documents;

import Graphics.BGSetter;
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
 * <strong><big>帮助文档  Help Document</big></strong>
 *
 * <p>展示游戏的帮助文档。</p>
 *
 * @author 分柿方橙
 * @version ver 1.0 (2021.7.7)
 * @since ver 1.1.1 (2021.7.7)
 */
public class Help {

    Button toDevDoc = new Button("日志");
    Button closePane = new Button("关闭");

    Stage HelpDocStage = new Stage();

    /**
     * 构造方法：创建新窗口
     */
    public Help(){
        /* 打开背景图 */
        BGSetter.Help.setX(0);
        BGSetter.Help.setY(0);

        FlowPane mainStartBg = new FlowPane(BGSetter.Help);
        mainStartBg.setStyle("-fx-background-color: ALICEBLUE");

        /* 读取帮助文档 */
        StringBuilder sbHelpDoc = new StringBuilder();
        String text = null;
        try {
            FileReader file = new FileReader("src/Module/Documents/Help.txt");
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
        toDevDoc.setOnAction(this::preButHelpDoc);
        toDevDoc.setFont(Font.font("Arial",20));
        toDevDoc.setLayoutX(90);
        toDevDoc.setLayoutY(550);
        toDevDoc.setPrefWidth(70);
        toDevDoc.setPrefHeight(45);

        /* 按钮：关闭 */
        closePane.setOnAction(this::preButClosePane);
        closePane.setFont(Font.font("Arial",20));
        closePane.setLayoutX(390);
        closePane.setLayoutY(550);
        closePane.setPrefWidth(70);
        closePane.setPrefHeight(45);

        Group root = new Group(mainStartBg, textArea, toDevDoc, closePane);

        Scene mainStartScene = new Scene(root, 528, 636, Color.ALICEBLUE);

        HelpDocStage.setTitle("Mine Sweeper");
        HelpDocStage.setScene(mainStartScene);
        HelpDocStage.setResizable(false);
        HelpDocStage.show();
    }

    /** 前往帮助页
     *
     * @param actionEvent 点击“帮助”
     */
    private void preButHelpDoc(ActionEvent actionEvent) {
        /* 关闭窗口 */
        Stage primaryStage = (Stage)closePane.getScene().getWindow();
        primaryStage.close();
        /* 打开帮助 */
        Develop open  = new Develop();

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
