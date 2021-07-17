package module.chooseMode;

import bean.Chara;
import bean.Game;
import bean.Save;
import bean.Timer;
import javafx.stage.Stage;

import java.util.Random;

import static module.chooseMode.ChooseMode.*;

class DataAnalysis{

    void dataAnalysis(){
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
                new byte[ng_x + 2][ng_y + 2], new String[ng_x + 2][ng_y + 2],
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

        Save.timerGame = new Timer();
        Save.timerChara = new Timer();
    }
}
