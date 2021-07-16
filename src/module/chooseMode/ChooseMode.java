package module.chooseMode;

import bean.*;
import mineSweeper.MineSweeper;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Random;

/**
 * <strong><big>模式选择（界面）  Choose Mode</big></strong>
 *
 * <p>玩家进行游戏模式选择，程序记录选项。</p>
 *
 * @author 分柿方橙
 * @version ver 1.0 (2021.7.8)
 * @since ver 1.1.2 (2021.7.8)
 */
public class ChooseMode {
    /* 初始数据 */
    String blockNumX = "16"; // 宽度
    String blockNumY = "16"; // 高度
    String mineNum = "40"; // 雷数
    byte level = 2; // 初始是中级

    byte timeAttri = 1; // 游戏时间
    byte landAttri = 1; // 游戏场景

    boolean charaRedChosen = false; // 红队
    boolean charaBluChosen = false; // 蓝队
    boolean charaGreChosen = false; // 绿队
    boolean charaPurChosen = false; // 紫队

    boolean modCascade; // 单人·自动开采

    String stepLim; // 多人·回合步数
    String timeLim; // 多人·回合时限
    boolean modLife; // 多人·开启生命
    boolean modCheat; // 多人·开启侦察
    boolean modCure; // 多人·开启治愈

    /* ---------------------------------------------以下是GUI---------------------------------------------------------- */

    Font mainFont = new Font("Arial",16); //字体：等线16号

    TextField userX = new TextField();
    TextField userY = new TextField();
    TextField userM = new TextField();

    TextField chaRedName = new TextField();
    TextField chaBluName = new TextField();
    TextField chaGreName = new TextField();
    TextField chaPurName = new TextField();

    TextField mulStep = new TextField();
    TextField mulTime = new TextField();

    /* 模式介绍 */
    Text modeName = new Text();
    Text modeIntro = new Text();

    Button ye = new Button("确定");
    Button no = new Button("取消");

    public Stage ModeSelectStage = new Stage();
    public ChooseMode(){
        FlowPane modeSelect = new FlowPane();

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
        ToggleGroup difficulty = new ToggleGroup();
        RadioButton easy = new RadioButton("初级    9×  9地图，10地雷");
        RadioButton norm = new RadioButton("中级  16×16地图，40地雷");
        RadioButton diff = new RadioButton("高级  16×30地图，99地雷");
        RadioButton user = new RadioButton("自定义");
        easy.setFont(mainFont); easy.setLayoutX(90); easy.setLayoutY(164);
        norm.setFont(mainFont); norm.setLayoutX(90); norm.setLayoutY(194);
        diff.setFont(mainFont); diff.setLayoutX(90); diff.setLayoutY(224);
        user.setFont(mainFont); user.setLayoutX(350); user.setLayoutY(194);
        easy.setOnAction(this::processButtonEasy); easy.setToggleGroup(difficulty);
        norm.setOnAction(this::processButtonNorm); norm.setToggleGroup(difficulty);
        diff.setOnAction(this::processButtonDiff); diff.setToggleGroup(difficulty);
        user.setOnAction(this::processButtonUser); user.setToggleGroup(difficulty);
        norm.setSelected(true);//自动选择中级
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
        userX.setTextFormatter(new TextFormatter<String>(t -> {
            String value = t.getText();
            if (value.matches("[0-9]*")){ return t; }
            return null; }));
        userY.setTextFormatter(new TextFormatter<String>(t -> {
            String value = t.getText();
            if (value.matches("[0-9]*")){ return t; }
            return null; }));
        userM.setTextFormatter(new TextFormatter<String>(t -> {
            String value = t.getText();
            if (value.matches("[0-9]*")){ return t; }
            return null; }));//只能输入数字

        Group userSet = new Group(uX, uY, uM, userX, userY, userM);
        Group difficultySet = new Group(seDifficulty, easy, norm, diff, user, userSet);

        /* 游戏时间 */
        Text seTime = new Text("游戏时间");
        seTime.setFont(Font.font("Arial", 20));
        seTime.setLayoutX(75);
        seTime.setLayoutY(312);//标题字
        ToggleGroup time = new ToggleGroup();
        RadioButton dayA = new RadioButton("仅白昼");
        RadioButton nigA = new RadioButton("仅深夜");
        RadioButton cirT = new RadioButton("昼夜交替");
        RadioButton ranT = new RadioButton("随机");
        dayA.setFont(mainFont); dayA.setLayoutX(180); dayA.setLayoutY(295);
        nigA.setFont(mainFont); nigA.setLayoutX(290); nigA.setLayoutY(295);
        cirT.setFont(mainFont); cirT.setLayoutX(400); cirT.setLayoutY(295);
        ranT.setFont(mainFont); ranT.setLayoutX(510); ranT.setLayoutY(295);
        dayA.setOnAction(this::processButtonDayA); dayA.setToggleGroup(time);
        nigA.setOnAction(this::processButtonNigA); nigA.setToggleGroup(time);
        cirT.setOnAction(this::processButtonCirT); cirT.setToggleGroup(time);
        ranT.setOnAction(this::processButtonRanT); ranT.setToggleGroup(time);
        dayA.setSelected(true);//自动选择中级

        Group timeSet = new Group(seTime, dayA, nigA, cirT, ranT);

        /* 游戏场景 */
        Text seLand = new Text("游戏场景");
        seLand.setFont(Font.font("Arial", 20));
        seLand.setLayoutX(75);
        seLand.setLayoutY(352);//标题字
        ToggleGroup land = new ToggleGroup();
        RadioButton plain = new RadioButton("平原");
        RadioButton mount = new RadioButton("山区");
        RadioButton badld = new RadioButton("恶地");
        RadioButton ranMd = new RadioButton("随机");
        plain.setFont(mainFont); plain.setLayoutX(180); plain.setLayoutY(335);
        mount.setFont(mainFont); mount.setLayoutX(290); mount.setLayoutY(335);
        badld.setFont(mainFont); badld.setLayoutX(400); badld.setLayoutY(335);
        ranMd.setFont(mainFont); ranMd.setLayoutX(510); ranMd.setLayoutY(335);
        plain.setOnAction(this::processButtonPlain); plain.setToggleGroup(land);
        mount.setOnAction(this::processButtonMount); mount.setToggleGroup(land);
        badld.setOnAction(this::processButtonBadld); badld.setToggleGroup(land);
        ranMd.setOnAction(this::processButtonRanMd); ranMd.setToggleGroup(land);
        plain.setSelected(true);//自动选择中级

        Group landSet = new Group(seLand, plain, mount, badld, ranMd);

        /* 游戏角色 */
        Text seChara = new Text("角色选择");
        seChara.setFont(Font.font("Arial", 20));
        seChara.setLayoutX(75);
        seChara.setLayoutY(412);//标题字
        /* 选项 */
        CheckBox charaRed = new CheckBox("红队");
        CheckBox charaBlu = new CheckBox("蓝队");
        CheckBox charaGre = new CheckBox("绿队");
        CheckBox charaPur = new CheckBox("紫队");
        charaRed.setFont(mainFont); charaRed.setLayoutX(180); charaRed.setLayoutY(385);
        charaBlu.setFont(mainFont); charaBlu.setLayoutX(180); charaBlu.setLayoutY(415);
        charaGre.setFont(mainFont); charaGre.setLayoutX(400); charaGre.setLayoutY(385);
        charaPur.setFont(mainFont); charaPur.setLayoutX(400); charaPur.setLayoutY(415);
        charaRed.setOnAction(this::processButtonCharaRed);
        charaBlu.setOnAction(this::processButtonCharaBlu);
        charaGre.setOnAction(this::processButtonCharaGre);
        charaPur.setOnAction(this::processButtonCharaPur);
        /* 名字 */
        chaRedName.setLayoutX(260); chaRedName.setLayoutY(382);
        chaBluName.setLayoutX(260); chaBluName.setLayoutY(412);
        chaGreName.setLayoutX(480); chaGreName.setLayoutY(382);
        chaPurName.setLayoutX(480); chaPurName.setLayoutY(412);
        chaRedName.setPrefWidth(100); chaRedName.setDisable(true);
        chaBluName.setPrefWidth(100); chaBluName.setDisable(true);
        chaGreName.setPrefWidth(100); chaGreName.setDisable(true);
        chaPurName.setPrefWidth(100); chaPurName.setDisable(true);

        Group charaSet = new Group(seChara, charaRed, charaBlu, charaGre, charaPur,
                chaRedName, chaBluName, chaGreName, chaPurName);

        /* 单人游戏模组 */
        Text seSingleMod = new Text("单人模式 追加模组");
        seSingleMod.setFont(Font.font("Arial", 20));
        seSingleMod.setLayoutX(75);seSingleMod.setLayoutY(492);//标题字
        /* 自动开采 */
        CheckBox spCascade = new CheckBox("自动开采");
        spCascade.setFont(mainFont); spCascade.setLayoutX(100); spCascade.setLayoutY(505);
        spCascade.setOnAction(this::processButtonCascade);

        Group singlePlayer = new Group(seSingleMod, spCascade);

        /* 多人游戏模组 */
        Text seMultiPMod = new Text("多人模式 追加模组");
        seMultiPMod.setFont(Font.font("Arial", 20));
        seMultiPMod.setLayoutX(75);
        seMultiPMod.setLayoutY(572);//标题字
        /* 回合步数 */
        CheckBox seMulStep = new CheckBox("回合步数 (1 ~ 5步)");
        seMulStep.setFont(mainFont);
        seMulStep.setLayoutX(100);seMulStep.setLayoutY(585);
        seMulStep.setOnAction(this::processButtonMulStep);
        mulStep.setLayoutX(270); mulStep.setLayoutY(582);
        mulStep.setPrefWidth(70);
        mulStep.setDisable(true);
        mulStep.setTextFormatter(new TextFormatter<String>(t -> {
            String value = t.getText();
            if (value.matches("[0-9]*")){ return t; }
            return null; }));//只能输入数字
        /* 回合时限 */
        CheckBox seMulTime = new CheckBox("回合时限 (10 ~ 60秒)");
        seMulTime.setFont(mainFont);
        seMulTime.setLayoutX(365);seMulTime.setLayoutY(585);
        seMulTime.setOnAction(this::processButtonMulTime);
        mulTime.setLayoutX(550); mulTime.setLayoutY(582);
        mulTime.setPrefWidth(70);
        mulTime.setDisable(true);
        mulTime.setTextFormatter(new TextFormatter<String>(t -> {
            String value = t.getText();
            if (value.matches("[0-9]*")){ return t; }
            return null; }));//只能输入数字
        /* 开启生命 */
        CheckBox life = new CheckBox("开启生命");
        life.setFont(mainFont); life.setLayoutX(100); life.setLayoutY(617);
        life.setOnAction(this::processButtonLife);
        /* 开启侦察 */
        CheckBox lifeCheat = new CheckBox("开启侦察");
        lifeCheat.setFont(mainFont); lifeCheat.setLayoutX(260); lifeCheat.setLayoutY(617);
        lifeCheat.setOnAction(this::processButtonLifeCheat);
        /* 开启治愈 */
        CheckBox lifeCure = new CheckBox("开启治愈");
        lifeCure.setFont(mainFont); lifeCure.setLayoutX(420); lifeCure.setLayoutY(617);
        lifeCure.setOnAction(this::processButtonLifeCure);

        Group multiPlayer = new Group(seMultiPMod, modeSelect, seMulStep, mulStep, seMulTime, mulTime,
                life, lifeCheat, lifeCure);

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
        ye.setOnAction(this::processButYe);
        no.setOnAction(this::processButNo);

        Group goOn = new Group(ye, no);

        /* 根集合 */
        Group root = new Group(newGame, rectangle, difficultySet, timeSet, landSet, charaSet,
                singlePlayer, multiPlayer, modeHelp, goOn);

        Scene mainStartScene = new Scene(root, 688, 908, Color.color(0.909, 0.929, 0.939));

        ModeSelectStage.setTitle("开始新游戏");
        ModeSelectStage.setScene(mainStartScene);
        ModeSelectStage.setResizable(false);
        ModeSelectStage.show();
    }
    /* ---------------------------------------------以下是按键操作---------------------------------------------------------- */

    /* 初级 */
    private void processButtonEasy(ActionEvent actionEvent) {
        userX.setDisable(true);
        userY.setDisable(true);
        userM.setDisable(true);//禁止填写自定义
        level = 1;
        blockNumX = "9"; blockNumY = "9"; mineNum = "10";//赋值
        modeName.setText("【初级模式】");
        modeIntro.setText("      游戏地图为9行9列网格，随机分布10个地雷，布雷率12.346%。");
    }
    /* 中级 */
    private void processButtonNorm(ActionEvent actionEvent) {
        userX.setDisable(true);
        userY.setDisable(true);
        userM.setDisable(true);//禁止填写自定义
        level = 2;
        blockNumX = "16"; blockNumY = "16"; mineNum = "40";//赋值
        modeName.setText("【中级模式】");
        modeIntro.setText("      游戏地图为16行16列网格，随机分布40个地雷，布雷率15.625%。");
    }
    /* 高级 */
    private void processButtonDiff(ActionEvent actionEvent) {
        userX.setDisable(true);
        userY.setDisable(true);
        userM.setDisable(true);//禁止填写自定义
        level = 3;
        blockNumX = "30"; blockNumY = "16"; mineNum = "99";//赋值
        modeName.setText("【高级模式】");
        modeIntro.setText("      游戏地图为16行30列网格，随机分布99个地雷，布雷率20.625%。");
    }
    /* 自定义 */
    private void processButtonUser(ActionEvent actionEvent) {
        userX.setDisable(false);
        userY.setDisable(false);
        userM.setDisable(false);//允许填写自定义
        level = 4;
        modeName.setText("【自定义模式】");
        modeIntro.setText("      您可以自行设置地图网格的行数（9 ~ 24）、列数（9 ~ 30）、地雷数\n" +
                "（10 ~ 360且布雷率 = 地雷数 ÷ (行数 × 列数) × 100% ≤ 50%）。");
    }

    /* 白天 */
    private void processButtonDayA(ActionEvent actionEvent) {
        timeAttri = 1;
        modeName.setText("【终为白昼】");
        modeIntro.setText("      将游戏设置在白昼进行。若玩家打开的区块为安全区块（该区块及紧邻\n" +
                "其的周围八格不含地雷），与其紧邻的8个区块将被自动打开，如此往复，\n" +
                "直到没有新的区块能再被此循环打开。");
    }
    /* 夜晚 */
    private void processButtonNigA(ActionEvent actionEvent) {
        timeAttri = 2;
        modeName.setText("【终为深夜】");
        modeIntro.setText("      将游戏设置在深夜进行。无论玩家打开的区块是否安全（安全区块自身\n" +
                "及紧邻的周围八格不含地雷），都只能在每次鼠标操作中打开这一个方块。");
    }
    /* 昼夜交替 */
    private void processButtonCirT(ActionEvent actionEvent) {
        timeAttri = 3;
        modeName.setText("【昼夜交替】");
        modeIntro.setText("      开始游戏时，游戏内时间为白昼 · 上午，接着，游戏每运行8分钟，将完\n" +
                "成一次昼夜循环。关于白昼与深夜的区别，参见 “游戏时间——仅白昼” 和 “游\n" +
                "戏时间——仅深夜” 模式的帮助。");
    }
    /* 随机 */
    private void processButtonRanT(ActionEvent actionEvent) {
        timeAttri = 4;
        modeName.setText("【随机】");
        modeIntro.setText("      随机选择游戏时间设置。");
    }


    /* 平原 */
    private void processButtonPlain(ActionEvent actionEvent) {
        landAttri = 1;
        modeName.setText("【平原】");
        modeIntro.setText("      将游戏设置在山区场景中进行。山区气候寒冷、地势崎岖，生长着高草\n" +
                "和零星的花卉。若游戏内时间被设置为 “昼夜交替” ，则昼夜等长。");
    }
    /* 山区 */
    private void processButtonMount(ActionEvent actionEvent) {
        landAttri = 2;
        modeName.setText("【山区】");
        modeIntro.setText("      将游戏设置在平原场景中进行。平原气候温和、地势平坦，生长着耐寒\n" +
                "的矮草和杉树，青色的山石常常裸露。若时间模式被设置为 “昼夜交替” ，\n" +
                "则夜晚略长于白日。若在 “多人对战” 模式中开启 “治愈” 模式，则深夜\n" +
                "期间生命值恢复速度为通常值的一半。");
    }
    /* 恶地 */
    private void processButtonBadld(ActionEvent actionEvent) {
        landAttri = 3;
        modeName.setText("【恶地】");
        modeIntro.setText("      将游戏设置在恶地场景中进行。恶地气候炎热、地势有一定起伏，零散\n" +
                "生长着仙人掌等沙漠耐旱植物。若时间模式被设置为 “昼夜交替” ，则白日\n" +
                "略长于夜晚。若在 “多人对战” 模式中开启 “治愈” 模式，则白昼期间生\n" +
                "命值恢复速度为通常值的一半。");
    }
    /* 随机 */
    private void processButtonRanMd(ActionEvent actionEvent) {
        landAttri = 4;
        modeName.setText("【随机】");
        modeIntro.setText("      随机选择游戏场景设置。");
    }


    /* 红 */
    int countRed = 0; // 记录鼠标点击次数，初始、点偶数次不能编辑，奇数次能编辑
    private void processButtonCharaRed(ActionEvent actionEvent) {
        countRed++;
        if (countRed % 2 == 0){
            chaRedName.setText("");
            chaRedName.setDisable(true);
            charaRedChosen = false;
        } else {
            chaRedName.setDisable(false);
            charaRedChosen = true;
        }
        modeName.setText("【红队成员】");
        modeIntro.setText("      红队的一位成员将参与本次扫雷任务。请在文本框中输入队员名字：\n" +
                "不得以数字开头。");
    }
    /* 蓝 */
    int countBlu = 0; // 记录鼠标点击次数，初始、点偶数次不能编辑，奇数次能编辑
    private void processButtonCharaBlu(ActionEvent actionEvent) {
        countBlu++;
        if (countBlu % 2 == 0){
            chaBluName.setText("");
            chaBluName.setDisable(true);
            charaBluChosen = false;
        } else {
            chaBluName.setDisable(false);
            charaBluChosen = true;
        }
        modeName.setText("【蓝队成员】");
        modeIntro.setText("      蓝队的一位成员将参与本次扫雷任务。请在文本框中输入队员名字：\n" +
                "不得以数字开头。");
    }
    /* 绿 */
    int countGre = 0; // 记录鼠标点击次数，初始、点偶数次不能编辑，奇数次能编辑
    private void processButtonCharaGre(ActionEvent actionEvent) {
        countGre++;
        if (countGre % 2 == 0){
            chaGreName.setText("");
            chaGreName.setDisable(true);
            charaGreChosen = false;
        } else {
            chaGreName.setDisable(false);
            charaGreChosen = true;
        }
        modeName.setText("【绿队成员】");
        modeIntro.setText("      绿队的一位成员将参与本次扫雷任务。请在文本框中输入队员名字：\n" +
                "不得以数字开头。");
    }
    /* 紫 */
    int countPur = 0; // 记录鼠标点击次数，初始、点偶数次不能编辑，奇数次能编辑
    private void processButtonCharaPur(ActionEvent actionEvent) {
        countPur++;
        if (countPur % 2 == 0){
            chaPurName.setText("");
            chaPurName.setDisable(true);
            charaPurChosen = false;
        } else {
            chaPurName.setDisable(false);
            charaPurChosen = true;
        }
        modeName.setText("【紫队成员】");
        modeIntro.setText("      紫队的一位成员将参与本次扫雷任务。请在文本框中输入队员名字：\n" +
                "不得以数字开头。");
    }

    /* 自动开采 */
    int countCascade = 0; // 记录鼠标点击次数，初始、点偶数次不能编辑，奇数次能编辑
    private void processButtonCascade(ActionEvent actionEvent) {
        countCascade++;
        modCascade = countCascade % 2 != 0;
        modeName.setText("【自动开采】");
        modeIntro.setText("      若玩家打开的区块为安全区块（该区块及紧邻其的周围八格不含地雷），\n" +
                "与其紧邻的8个区块将被自动打开，如此往复，直到没有新的区块能再被此\n" +
                "循环打开。");
    }

    /* 回合步数 */
    int countStep = 0; // 记录鼠标点击次数，初始、点偶数次不能编辑，奇数次能编辑
    private void processButtonMulStep(ActionEvent actionEvent) {
        countStep++;
        if (countStep % 2 == 0){
            mulStep.setText("");
            mulStep.setDisable(true);
        } else {
            mulStep.setDisable(false);
        }
        modeName.setText("【回合步数】");
        modeIntro.setText("      多人模式下，设置每回合每位玩家所能进行的鼠标操作（打开区块、标\n" +
                "记一区块为雷区、标记一区块可疑）次数。缺省值为5次。");
    }
    /* 回合时限 */
    int countTime = 0; // 记录鼠标点击次数，初始、点偶数次不能编辑，奇数次能编辑
    private void processButtonMulTime(ActionEvent actionEvent) {
        countTime++;
        if (countTime % 2 == 0){
            mulTime.setText("");
            mulTime.setDisable(true);
        } else {
            mulTime.setDisable(false);
        }
        modeName.setText("【回合时限】");
        modeIntro.setText("      多人模式下，设置每回合每位玩家进行鼠标操作 “回合步数” 上限次鼠\n" +
                "标操作的最大限制时间。缺省值为20秒。");
    }

    /* 开启生命 */
    int countLife = 0; // 记录鼠标点击次数，初始、点偶数次不能编辑，奇数次能编辑
    private void processButtonLife(ActionEvent actionEvent) {
        countLife++;
        modLife = countLife % 2 != 0;
        modeName.setText("【开启生命】");
        modeIntro.setText("      多人模式下，游戏初始每位玩家都有5点生命值。玩家每触碰一次地雷，\n" +
                "将失去1点生命值；当玩家生命值降为0时，玩家死亡；若所有雷被标记前，\n" +
                "所有玩家均死亡，游戏提前结束，且本次游戏成绩不记入排行榜。仅当选择\n" +
                " “开启生命” 时， “开启侦察” 和 “开启治愈” 选项有效.");
    }
    /* 开启侦察 */
    int countCheat = 0; // 初始、点偶数次不能编辑，奇数次能编辑
    private void processButtonLifeCheat(ActionEvent actionEvent) {
        countCheat++;
        modCheat = countCheat % 2 != 0;
        modeName.setText("【开启侦察】");
        modeIntro.setText("      多人模式下，玩家可在自己回合，执行 “侦察” 操作。玩家将消耗1点生\n" +
                "命值，将指定区块及其相邻8块区块正确打开或正确标正记为雷。\n" +
                "      若未选择 “开启生命” 选项，本选项不生效。");
    }
    /* 开启治愈 */
    int countCure = 0; // 初始、点偶数次不能编辑，奇数次能编辑
    private void processButtonLifeCure(ActionEvent actionEvent) {
        countCure++;
        modCure = countCure % 2 != 0;
        modeName.setText("【开启治愈】");
        modeIntro.setText("      多人模式下，玩家将逐渐恢复生命值。生命值恢复速度受游戏时间、场\n" +
                "景影响。\n" +
                "      若未选择 “开启生命” 选项，本选项不生效。");
    }

    /**
     * 点击确定：创建新游戏
     * @param actionEvent 点击确定
     */
    private void processButYe(ActionEvent actionEvent) {
        /* 用于创建新游戏的数据：ng = newGame */
        int ng_x; int ng_y; int ng_m; byte ng_time; byte ng_land; byte ng_charaNum = 0;
        boolean ng_charaRed = false; boolean ng_charaBlu = false; boolean ng_charaGre = false; boolean ng_charaPur = false;
        String ng_nameRed = null; String ng_nameBlu = null; String ng_nameGre = null; String ng_namePur = null;
        boolean ng_modCascade = false; int ng_stepLim = 0; int ng_timeLim = 0;
        boolean ng_modLife = false; boolean ng_modCheat = false; boolean ng_modCure = false;

        /* 处理：三大属性 */
        if (level == 1){ // 初级
            ng_y = 9; ng_x = 9; ng_m = 10;
        } else if (level == 2){ // 中级
            ng_y = 16; ng_x = 16; ng_m = 40;
        } else if (level == 3){ // 高级
            ng_y = 16; ng_x = 30; ng_m = 99;
        } else if (level == 4){ // 自定义
            blockNumX = userX.getText();
            blockNumY = userY.getText();
            mineNum = userM.getText(); // 获得文本框信息
            if (blockNumX.equals("")){ blockNumX = "16"; }
            else if (blockNumX.length() > 5){ blockNumX = blockNumX.substring(0, 3); }
            if (blockNumY.equals("")){ blockNumY = "16"; }
            else if (blockNumY.length() > 5){ blockNumY = blockNumY.substring(0, 3); }
            if (mineNum.equals("")){ mineNum = "40"; }
            else if (mineNum.length() > 5){ mineNum = mineNum.substring(0, 3); }
            ng_y = Integer.parseInt(blockNumX);
            ng_x = Integer.parseInt(blockNumY);
            ng_m = Integer.parseInt(mineNum); // String转int
            if (ng_y < 9 ){ ng_y = 9; } else if (ng_y > 24){ ng_y = 24; }
            if (ng_x < 9 ){ ng_x = 9; } else if (ng_x > 30){ ng_y = 30; }
            if (ng_m < 10 ){ ng_m = 10; } else if (ng_m > ng_y * ng_x / 2){ ng_m = ng_y * ng_x / 2; } // 限制取值
        } else {
            ng_y = Integer.parseInt(blockNumX);
            ng_x = Integer.parseInt(blockNumY);
            ng_m = Integer.parseInt(mineNum);
        }

        /* 处理：时间和场景 */
        if (timeAttri == 4){ ng_time = (byte) (new Random().nextInt(3) + 1); }
        else { ng_time = timeAttri; }
        if (landAttri == 4){ ng_land = (byte) (new Random().nextInt(3) + 1); }
        else { ng_land = landAttri; }

        /* 判断人数 */
        byte charaNum = 0;
        if ( charaRedChosen ){
            charaNum++; ng_charaRed = true; ng_nameRed = chaRedName.getText();
            if (ng_nameRed.equals("")){ ng_nameRed = "红队工兵"; }
        }
        if ( charaBluChosen ){
            charaNum++; ng_charaBlu = true; ng_nameBlu = chaBluName.getText();
            if (ng_nameBlu.equals("")){ ng_nameBlu = "蓝队工兵"; }
        }
        if ( charaGreChosen ){
            charaNum++; ng_charaGre = true; ng_nameGre = chaGreName.getText();
            if (ng_nameGre.equals("")){ ng_nameGre = "绿队工兵"; }
        }
        if ( charaPurChosen ){
            charaNum++; ng_charaPur = true; ng_namePur = chaGreName.getText();
            if (ng_namePur.equals("")){ ng_namePur = "紫队工兵"; }
        } // 队员选择

        /* 单人模式 */
        if (charaNum == 0 || charaNum == 1){
            ng_modCascade = modCascade;
            if (charaNum == 0){
                ng_charaNum = 1; ng_charaBlu = true; charaBluChosen = true; ng_nameBlu = "蓝队工兵";
            } //如果没有选择任何玩家，则默认用户选择了蓝队
        }
        /* 多人模式 */
        else { ng_charaNum = charaNum;
            /* 步数和时间限制 */
            stepLim = mulStep.getText();
            timeLim = mulTime.getText();
            if (stepLim.equals("")){ stepLim = "5"; }
            else if (stepLim.length() > 5){ stepLim = stepLim.substring(0, 3); }
            if (timeLim.equals("")){ timeLim = "20"; }
            else if (timeLim.length() > 5){ timeLim = timeLim.substring(0, 3); }
            ng_stepLim = Integer.parseInt(stepLim);
            ng_timeLim = Integer.parseInt(timeLim);
            if (ng_stepLim < 1){ ng_stepLim = 1; } else if (ng_stepLim > 5){ ng_stepLim = 5; }
            if (ng_timeLim < 10){ ng_timeLim = 10; } else if (ng_timeLim > 60){ ng_timeLim = 60; }
            /* 生命设置 */
            if (modLife) {
                ng_modLife = true; ng_modCheat = modCheat; ng_modCure = modCure;
            } else {
                ng_modLife = false; ng_modCheat = false; ng_modCure = false;
            } // 必须选择开生命值才能选开作弊和治愈
        }

        /* 关闭现窗口 */
        Stage primaryStage = (Stage)ye.getScene().getWindow();
        primaryStage.close();

        /* 创建一个Game */
        Save.game = new Game(ng_x, ng_y, ng_m, ng_time, ng_land, ng_charaNum,
                ng_charaRed, ng_charaBlu, ng_charaGre, ng_charaPur,
                ng_modCascade, ng_stepLim, ng_timeLim,
                ng_modLife, ng_modCheat, ng_modCure,
                0, 0,
                new byte[ng_x][ng_y], new String[ng_x][ng_y],
                false);

        /* 创建四个角色 */
        if (charaRedChosen) {
            Save.charaRed = new Chara(true, "red", ng_nameRed, 0, 0,
                    ng_timeLim, ng_stepLim, 5, ng_timeLim, ng_stepLim, 5,
                    false, false, false,false); }
        else { Save.charaRed = new Chara(false); }
        if (charaBluChosen) {
            Save.charaBlu = new Chara(true, "blu", ng_nameBlu, 0, 0,
                    ng_timeLim, ng_stepLim, 5, ng_timeLim, ng_stepLim, 5,
                    false, false, false,false); }
        else { Save.charaBlu = new Chara(false); }
        if (charaGreChosen) {
            Save.charaGre = new Chara(true, "gre", ng_nameGre, 0, 0,
                    ng_timeLim, ng_stepLim, 5, ng_timeLim, ng_stepLim, 5,
                    false, false, false,false); }
        else { Save.charaGre = new Chara(false); }
        if (charaPurChosen) {
            Save.charaPur = new Chara(true, "pur", ng_namePur, 0, 0,
                    ng_timeLim, ng_stepLim, 5, ng_timeLim, ng_stepLim, 5,
                    false, false, false,false); }
        else { Save.charaPur = new Chara(false); }//如果角色被选择，用前一种；没被选择，后一种

        /* 开启新窗口GameMainPane */
//        new GameMainPlane(game0, charaRed, charaBlu, charaGre, charaPur, new TimeData(), new TimeData());
    }


    /**
     * 点击取消：返回主菜单
     * @param actionEvent 点击取消
     */
    private void processButNo(ActionEvent actionEvent) {
        /* 打开开始界面 */
        Stage Stage = (Stage)no.getScene().getWindow();
        Stage.close();
        MineSweeper open  = new MineSweeper();
        open.start(new Stage());
    }
}
