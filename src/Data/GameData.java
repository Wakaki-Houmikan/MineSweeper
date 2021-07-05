package Data;

import java.io.Serializable;

/* 游戏数据 */
public class GameData implements Serializable {

    private int x; // 宽度
    private int y; // 高度
    private int m; // 雷数

    private byte time; // 游戏时间：1 白昼  2 暗夜  3 昼夜  4 随机
    private byte land; // 游戏场景：1 平原  2 山区  3 恶地  4 随机

    private byte charaNum;    // 人数
    private boolean charaRed; // 选择红队
    private boolean charaBlu; // 选择蓝队
    private boolean charaGre; // 选择绿队
    private boolean charaPur; // 选择紫队

    private String nameRed; // 红队名字
    private String nameBlu; // 蓝队名字
    private String nameGre; // 绿队名字
    private String namePur; // 紫队名字

    private boolean modAuto; // 单人·自动开采

    private int stepLim; // 多人·回合步数
    private int timeLim; // 多人·回合时限
    private boolean modLife; // 多人·开启生命
    private boolean modCheat; // 多人·开启侦察
    private boolean modCure; // 多人·开启治愈

    private int stepTotal; //记录总步数
    private int timeTotal; //记录总时间
    
    private boolean loadSave; //是个存档

    /* 建造器 */
    public GameData(int x, int y, int m, byte time, byte land, byte charaNum,
                    boolean charaRed, boolean charaBlu, boolean charaGre, boolean charaPul,
                    String nameRed, String nameBlu, String nameGre, String namePul,
                    boolean modAuto, int modStepLimit, int modTimeLimit,
                    boolean modLife, boolean modCheat, boolean modCure,
                    int stepTotal, int timeTotal, boolean loadSave) {
        this.x = x;
        this.y = y;
        this.m = m;
        this.time = time;
        this.land = land;
        this.charaNum = charaNum;
        this.charaRed = charaRed;
        this.charaBlu = charaBlu;
        this.charaGre = charaGre;
        this.charaPur = charaPul;
        this.nameRed = nameRed;
        this.nameBlu = nameBlu;
        this.nameGre = nameGre;
        this.namePur = namePul;
        this.modAuto = modAuto;
        this.stepLim = modStepLimit;
        this.timeLim = modTimeLimit;
        this.modLife = modLife;
        this.modCheat = modCheat;
        this.modCure = modCure;
        this.stepTotal = stepTotal;
        this.timeTotal = timeTotal;
        this.loadSave = loadSave;
    }

    /* set get方法 */

    public int getX() { return x; }
    public void setX(int x) { this.x = x; }

    public int getY() { return y; }
    public void setY(int y) { this.y = y; }

    public int getM() { return m; }
    public void setM(int m) { this.m = m; }

    public byte getTime() { return time; }
    public void setTime(byte time) { this.time = time; }

    public byte getLand() { return land; }
    public void setLand(byte land) { this.land = land; }

    public byte getCharaNum() { return charaNum; }
    public void setCharaNum(byte charaNum) { this.charaNum = charaNum; }

    public boolean isCharaRed() { return charaRed; }
    public void setCharaRed(boolean charaRed) { this.charaRed = charaRed; }

    public boolean isCharaBlu() { return charaBlu; }
    public void setCharaBlu(boolean charaBlu) { this.charaBlu = charaBlu; }

    public boolean isCharaGre() { return charaGre; }
    public void setCharaGre(boolean charaGre) { this.charaGre = charaGre; }

    public boolean isCharaPur() { return charaPur; }
    public void setCharaPur(boolean charaPur) { this.charaPur = charaPur; }

    public String getNameRed() { return nameRed; }
    public void setNameRed(String nameRed) { this.nameRed = nameRed; }

    public String getNameBlu() { return nameBlu; }
    public void setNameBlu(String nameBlu) { this.nameBlu = nameBlu; }

    public String getNameGre() { return nameGre; }
    public void setNameGre(String nameGre) { this.nameGre = nameGre; }

    public String getNamePur() { return namePur; }
    public void setNamePur(String namePur) { this.namePur = namePur; }

    public boolean isModAuto() { return modAuto; }
    public void setModAuto(boolean modAuto) { this.modAuto = modAuto; }

    public int getStepLim() { return stepLim; }
    public void setStepLim(int stepLim) { this.stepLim = stepLim; }

    public int getTimeLim() { return timeLim; }
    public void setTimeLim(int timeLim) { this.timeLim = timeLim; }

    public boolean isModLife() { return modLife; }
    public void setModLife(boolean modLife) { this.modLife = modLife; }

    public boolean isModCheat() { return modCheat; }
    public void setModCheat(boolean modCheat) { this.modCheat = modCheat; }

    public boolean isModCure() { return modCure; }
    public void setModCure(boolean modCure) { this.modCure = modCure; }

    public int getStepTotal() { return stepTotal; }
    public void setStepTotal(int stepTotal) { this.stepTotal = stepTotal; }

    public int getTimeTotal() { return timeTotal; }
    public void setTimeTotal(int timeTotal) { this.timeTotal = timeTotal; }

    public boolean isLoadSave() { return loadSave; }
    public void setLoadSave(boolean loadSave) { this.loadSave = loadSave; }
}

