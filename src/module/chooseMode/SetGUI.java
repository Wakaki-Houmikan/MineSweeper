package module.chooseMode;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import static module.chooseMode.ChooseMode.*;

/**
 * <strong>设置排版  Set GUI</strong>
 *
 * <p>为模式选择器里的按钮、文本框设置排版。</p>
 *
 * @author 分柿方橙
 * @version ver 1.0 (2021.7.16)
 * @since ver 1.1.8 (2021.7.16)
 */
class SetGUI {

    Font mainFont = new Font("Arial",16); //字体：等线16号

    /**
     * 方法·设置排版：为模式选择器里的按钮、文本框设置排版。
     *
     * @return 包含所有新增GUI组件的Group。
     */
    Group setGUI(){

        /* 三个长方形 */
        Rectangle rectangle1 = new Rectangle(60, 120, 580, 140);
        Rectangle rectangle2 = new Rectangle(60, 280, 580, 380);
        Rectangle rectangle3 = new Rectangle(60, 680, 580, 150);
        rectangle1.setStroke(Color.color(0.652, 0.704, 0.792));
        rectangle2.setStroke(Color.color(0.652, 0.704, 0.792));
        rectangle3.setStroke(Color.color(0.652, 0.704, 0.792));
        rectangle1.setFill(Color.color(0.918, 0.938, 0.949));
        rectangle2.setFill(Color.color(0.918, 0.938, 0.949));
        rectangle3.setFill(Color.color(0.918, 0.938, 0.949));

        Group rectangle = new Group(rectangle1, rectangle2, rectangle3);

        /* 题头 */
        Text newGame = new Text("开始新游戏");
        newGame.setFont(Font.font("Arial", 36));
        newGame.setLayoutX(250);
        newGame.setLayoutY(80);

        /* 难度设置 */
        Text seDifficulty = new Text("难度设置");
        seDifficulty.setFont(Font.font("Arial", 20));
        seDifficulty.setLayoutX(75);
        seDifficulty.setLayoutY(148);//标题字
        easy.setFont(mainFont); easy.setLayoutX(90); easy.setLayoutY(164);
        norm.setFont(mainFont); norm.setLayoutX(90); norm.setLayoutY(194);
        diff.setFont(mainFont); diff.setLayoutX(90); diff.setLayoutY(224);
        user.setFont(mainFont); user.setLayoutX(350); user.setLayoutY(194);

        /* 自定义 */
        Text uY = new Text("行数 (9 ~ 24)");
        Text uX = new Text("列数 (9 ~ 30)");
        Text uM = new Text("雷数 (10 ~ 360)");
        uY.setFont(mainFont); uY.setLayoutX(440); uY.setLayoutY(180);
        uX.setFont(mainFont); uX.setLayoutX(440); uX.setLayoutY(210);
        uM.setFont(mainFont); uM.setLayoutX(440); uM.setLayoutY(240);
        /* 输入框 */
        userY.setLayoutX(555); userY.setLayoutY(160);
        userX.setLayoutX(555); userX.setLayoutY(190);
        userM.setLayoutX(555); userM.setLayoutY(220);
        userY.setPrefWidth(70); userY.setDisable(true);
        userX.setPrefWidth(70); userX.setDisable(true);
        userM.setPrefWidth(70); userM.setDisable(true);

        /* 游戏时间 */
        Text seTime = new Text("游戏时间");
        seTime.setFont(Font.font("Arial", 20));
        seTime.setLayoutX(75);
        seTime.setLayoutY(312);//标题字
        dayA.setFont(mainFont); dayA.setLayoutX(180); dayA.setLayoutY(295);
        nigA.setFont(mainFont); nigA.setLayoutX(290); nigA.setLayoutY(295);
        cirT.setFont(mainFont); cirT.setLayoutX(400); cirT.setLayoutY(295);
        ranT.setFont(mainFont); ranT.setLayoutX(510); ranT.setLayoutY(295);

        /* 游戏场景 */
        Text seLand = new Text("游戏场景");
        seLand.setFont(Font.font("Arial", 20));
        seLand.setLayoutX(75);
        seLand.setLayoutY(352);//标题字
        plain.setFont(mainFont); plain.setLayoutX(180); plain.setLayoutY(335);
        mount.setFont(mainFont); mount.setLayoutX(290); mount.setLayoutY(335);
        badld.setFont(mainFont); badld.setLayoutX(400); badld.setLayoutY(335);
        ranMd.setFont(mainFont); ranMd.setLayoutX(510); ranMd.setLayoutY(335);

        /* 游戏角色 */
        /* 选项 */
        Text seChara = new Text("角色选择");
        seChara.setFont(Font.font("Arial", 20));
        seChara.setLayoutX(75);
        seChara.setLayoutY(412);//标题字
        charaRed.setFont(mainFont); charaRed.setLayoutX(180); charaRed.setLayoutY(385);
        charaBlu.setFont(mainFont); charaBlu.setLayoutX(180); charaBlu.setLayoutY(415);
        charaGre.setFont(mainFont); charaGre.setLayoutX(400); charaGre.setLayoutY(385);
        charaPur.setFont(mainFont); charaPur.setLayoutX(400); charaPur.setLayoutY(415);
        /* 名字 */
        chaRedName.setLayoutX(260); chaRedName.setLayoutY(382);
        chaBluName.setLayoutX(260); chaBluName.setLayoutY(412);
        chaGreName.setLayoutX(480); chaGreName.setLayoutY(382);
        chaPurName.setLayoutX(480); chaPurName.setLayoutY(412);
        chaRedName.setPrefWidth(100); chaRedName.setDisable(true);
        chaBluName.setPrefWidth(100); chaBluName.setDisable(true);
        chaGreName.setPrefWidth(100); chaGreName.setDisable(true);
        chaPurName.setPrefWidth(100); chaPurName.setDisable(true);

        /* 单人游戏模组 */
        Text seSingleMod = new Text("单人模式 追加模组");
        seSingleMod.setFont(Font.font("Arial", 20));
        seSingleMod.setLayoutX(75);seSingleMod.setLayoutY(492);//标题字
        /* 自动开采 */
        spCascade.setFont(mainFont); spCascade.setLayoutX(100); spCascade.setLayoutY(505);

        /* 多人游戏模组 */
        Text seMultiPMod = new Text("多人模式 追加模组");
        seMultiPMod.setFont(Font.font("Arial", 20));
        seMultiPMod.setLayoutX(75);
        seMultiPMod.setLayoutY(572);//标题字

        /* 回合步数 */
        seMulStep.setFont(mainFont);
        seMulStep.setLayoutX(100);seMulStep.setLayoutY(585);
        mulStep.setLayoutX(270); mulStep.setLayoutY(582);
        mulStep.setPrefWidth(70);
        mulStep.setDisable(true);

        /* 回合时限 */
        seMulTime.setFont(mainFont);
        seMulTime.setLayoutX(365);seMulTime.setLayoutY(585);
        mulTime.setLayoutX(550); mulTime.setLayoutY(582);
        mulTime.setPrefWidth(70);
        mulTime.setDisable(true);

        /* 开启生命 */
        life.setFont(mainFont); life.setLayoutX(100); life.setLayoutY(617);

        /* 开启侦察 */
        lifeCheat.setFont(mainFont); lifeCheat.setLayoutX(260); lifeCheat.setLayoutY(617);

        /* 开启治愈 */
        lifeCure.setFont(mainFont); lifeCure.setLayoutX(420); lifeCure.setLayoutY(617);

        /* 模式介绍 */
        modeName.setFont(Font.font("Arial", 20));
        modeName.setFill(Color.DARKBLUE);
        modeName.setLayoutX(75);
        modeName.setLayoutY(710);//模式名
        modeIntro.setFont(Font.font("Arial", 17));
        modeIntro.setFill(Color.DARKBLUE);
        modeIntro.setLayoutX(75);
        modeIntro.setLayoutY(740);//模式介绍
        modeName.setText("【中级模式】");
        modeIntro.setText("      游戏地图为16行16列网格，随机分布40个地雷，布雷率15.625%。");//初始化

        Group modeHelp = new Group(modeName, modeIntro);

        /* 确定和取消 */
        ye.setFont(Font.font("Arial",20));
        no.setFont(Font.font("Arial",20));
        ye.setLayoutX(340); ye.setLayoutY(850);
        no.setLayoutX(520); no.setLayoutY(850);
        ye.setPrefWidth(120); ye.setPrefHeight(40);
        no.setPrefWidth(120); no.setPrefHeight(40);

        return new Group(rectangle, newGame, seDifficulty, uY, uX, uM, seTime, seLand, seChara,
                seSingleMod, seMultiPMod, modeHelp);
    }
}
