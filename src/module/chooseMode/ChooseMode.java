package module.chooseMode;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

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
    static String blockNumX = "16"; // 宽度
    static String blockNumY = "16"; // 高度
    static String mineNum = "40"; // 雷数
    static byte level = 2; // 初始是中级

    static byte timeAttri = 1; // 游戏时间
    static byte landAttri = 1; // 游戏场景

    static boolean charaRedChosen = false; // 红队
    static boolean charaBluChosen = false; // 蓝队
    static boolean charaGreChosen = false; // 绿队
    static boolean charaPurChosen = false; // 紫队

    static boolean modCascade; // 单人·自动开采

    static String stepLim; // 多人·回合步数
    static String timeLim; // 多人·回合时限
    static boolean modLife; // 多人·开启生命
    static boolean modCheat; // 多人·开启侦察
    static boolean modCure; // 多人·开启治愈

    /* ---------------------------------------------以下是GUI---------------------------------------------------------- */

    public Stage modeSelectStage;

    /* 模式介绍 */
    static Text modeName = new Text();
    static Text modeIntro = new Text();

    /* 输入框们 */
    static TextField userX = new TextField();
    static TextField userY = new TextField();
    static TextField userM = new TextField();

    static TextField chaRedName = new TextField();
    static TextField chaBluName = new TextField();
    static TextField chaGreName = new TextField();
    static TextField chaPurName = new TextField();

    static TextField mulStep = new TextField();
    static TextField mulTime = new TextField();

    /* 按钮们 */
    static RadioButton easy = new RadioButton("初级    9×  9地图，10地雷");
    static RadioButton norm = new RadioButton("中级  16×16地图，40地雷");
    static RadioButton diff = new RadioButton("高级  16×30地图，99地雷");
    static RadioButton user = new RadioButton("自定义");

    static RadioButton dayA = new RadioButton("仅白昼");
    static RadioButton nigA = new RadioButton("仅深夜");
    static RadioButton cirT = new RadioButton("昼夜交替");
    static RadioButton ranT = new RadioButton("随机");

    static RadioButton plain = new RadioButton("平原");
    static RadioButton mount = new RadioButton("山区");
    static RadioButton badld = new RadioButton("恶地");
    static RadioButton ranMd = new RadioButton("随机");

    static CheckBox charaRed = new CheckBox("红队");
    static CheckBox charaBlu = new CheckBox("蓝队");
    static CheckBox charaGre = new CheckBox("绿队");
    static CheckBox charaPur = new CheckBox("紫队");

    static CheckBox spCascade = new CheckBox("自动开采");

    static CheckBox seMulStep = new CheckBox("回合步数 (1 ~ 5步)");
    static CheckBox seMulTime = new CheckBox("回合时限 (10 ~ 60秒)");
    static CheckBox life = new CheckBox("开启生命");
    static CheckBox lifeCheat = new CheckBox("开启侦察");
    static CheckBox lifeCure = new CheckBox("开启治愈");

    static Button ye = new Button("确定");
    static Button no = new Button("取消");

    Group root;

    public ChooseMode(){
        root = new SetGUI().setGUI();
        new SetEvent().setEvent();

        /* 难度设置 */
        ToggleGroup difficulty = new ToggleGroup();
        easy.setToggleGroup(difficulty);
        norm.setToggleGroup(difficulty);
        diff.setToggleGroup(difficulty);
        user.setToggleGroup(difficulty);
        norm.setSelected(true);//自动选择中级
        /* 自定义 */
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

        Group userSet = new Group(userX, userY, userM);
        Group difficultySet = new Group(easy, norm, diff, user, userSet);

        /* 游戏时间 */
        ToggleGroup time = new ToggleGroup();
        dayA.setToggleGroup(time);
        nigA.setToggleGroup(time);
        cirT.setToggleGroup(time);
        ranT.setToggleGroup(time);
        dayA.setSelected(true);//自动选择中级

        Group timeSet = new Group(dayA, nigA, cirT, ranT);

        /* 游戏场景 */
        ToggleGroup land = new ToggleGroup();
        plain.setToggleGroup(land);
        mount.setToggleGroup(land);
        badld.setToggleGroup(land);
        ranMd.setToggleGroup(land);
        plain.setSelected(true);//自动选择中级

        Group landSet = new Group(plain, mount, badld, ranMd);

        /* 游戏角色 */
        Group charaSet = new Group(charaRed, charaBlu, charaGre, charaPur,
                chaRedName, chaBluName, chaGreName, chaPurName);

        /* 单人游戏模组 */
        /* 自动开采 */
        Group singlePlayer = new Group(spCascade);

        /* 多人游戏模组 */
        /* 回合步数 */
        mulStep.setTextFormatter(new TextFormatter<String>(t -> {
            String value = t.getText();
            if (value.matches("[0-9]*")){ return t; }
            return null; }));//只能输入数字
        /* 回合时限 */
        mulTime.setTextFormatter(new TextFormatter<String>(t -> {
            String value = t.getText();
            if (value.matches("[0-9]*")){ return t; }
            return null; }));//只能输入数字
        /* 开启生命 */
        /* 开启侦察 */
        /* 开启治愈 */

        Group multiPlayer = new Group(seMulStep, mulStep, seMulTime, mulTime,
                life, lifeCheat, lifeCure);

        /* 确定和取消 */

        Group goOn = new Group(ye, no);

        /* 根集合 */
        root.getChildren().addAll(difficultySet, timeSet, landSet, charaSet, singlePlayer, multiPlayer, goOn);

        Scene mainStartScene = new Scene(root, 688, 908, Color.color(0.909, 0.929, 0.939));

        modeSelectStage = new Stage();
        modeSelectStage.setTitle("开始新游戏");
        modeSelectStage.setScene(mainStartScene);
        modeSelectStage.setResizable(false);
        modeSelectStage.show();
    }

}
