package module.chooseMode;

import javafx.event.ActionEvent;
import javafx.stage.Stage;
import mineSweeper.MineSweeper;
import module.gamePlay.GamePlay;

import static module.chooseMode.ChooseMode.*;

class SetEvent {
    void setEvent(){
        /* 难度设置 */
        easy.setOnAction(this::processButtonEasy);
        norm.setOnAction(this::processButtonNorm);
        diff.setOnAction(this::processButtonDiff);
        user.setOnAction(this::processButtonUser);

        /* 游戏时间 */
        dayA.setOnAction(this::processButtonDayA);
        nigA.setOnAction(this::processButtonNigA);
        cirT.setOnAction(this::processButtonCirT);
        ranT.setOnAction(this::processButtonRanT);

        /* 游戏场景 */
        plain.setOnAction(this::processButtonPlain);
        mount.setOnAction(this::processButtonMount);
        badld.setOnAction(this::processButtonBadld);
        ranMd.setOnAction(this::processButtonRanMd);

        /* 游戏角色 */
        charaRed.setOnAction(this::processButtonCharaRed);
        charaBlu.setOnAction(this::processButtonCharaBlu);
        charaGre.setOnAction(this::processButtonCharaGre);
        charaPur.setOnAction(this::processButtonCharaPur);

        /* 单人模组 */
        spCascade.setOnAction(this::processButtonCascade);

        /* 多人模组 */
        seMulStep.setOnAction(this::processButtonMulStep);
        seMulTime.setOnAction(this::processButtonMulTime);
        life.setOnAction(this::processButtonLife);
        lifeCheat.setOnAction(this::processButtonLifeCheat);
        lifeCure.setOnAction(this::processButtonLifeCure);

        /* 确定和取消 */
        ye.setOnAction(this::processButYe);
        no.setOnAction(this::processButNo);
    }


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
        new DataAnalysis().dataAnalysis();

        /* 开启新窗口GamePlay */
        Stage Stage = (Stage)no.getScene().getWindow();
        Stage.close();
        new GamePlay();
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
