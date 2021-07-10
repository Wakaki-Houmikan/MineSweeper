package bean;

import java.io.Serializable;

/**
 * <strong><big>游戏数据  Game Data</big></strong>
 *
 * <p>记录游戏数据。</p>
 *
 * @author 分柿方橙
 * @version ver 1.4 (2021.7.7)
 * @since ver 1.1.0 (2021.7.5)
 */
public class Game implements Serializable {

    private int blockNumX; // 宽度（列数）
    private int blockNumY; // 高度（行数）
    private int mineNum; // 雷数

    private byte timeAttri; // 游戏时间：1 白昼  2 暗夜  3 昼夜  4 随机
    private byte landAttri; // 游戏场景：1 平原  2 山区  3 恶地  4 随机

    private byte charaNum;    // 人数
    private boolean charaRedChosen; // 选择红队
    private boolean charaBluChosen; // 选择蓝队
    private boolean charaGreChosen; // 选择绿队
    private boolean charaPurChosen; // 选择紫队

    private boolean modCascade; // 单人·级联开采

    private int stepLim; // 多人·回合步数
    private int timeLim; // 多人·回合时限
    private boolean modLife; // 多人·开启生命
    private boolean modCheat; // 多人·开启侦察
    private boolean modCure; // 多人·开启治愈

    private int stepTotal; //记录总步数
    private int timeTotal; //记录总时间

    private byte[][] mapMatrix; //地图矩阵
    private String[][] statusMatrix; //状态矩阵

    private boolean loadSave; //是个存档

    /**
     * 构造器：创建一部新游戏
     * @param blockNumX 横向区块数
     * @param blockNumY 竖向区块数
     * @param mineNum 地雷数
     * @param timeAttri 昼夜设置：1 白天、2 黑夜、3、交替
     * @param landAttri 地形设置：1 平原、2 冰山、3 恶地
     * @param charaNum 已选择的角色数量
     * @param charaRedChosen 是否选择红队
     * @param charaBluChosen 是否选择蓝队
     * @param charaGreChosen 是否选择绿队
     * @param charaPulChosen 是否选择紫队
     * @param modCascade 单人模式：级联开采模组
     * @param modStepLimit 多人模式：每位角色每次行动的步数限制
     * @param modTimeLimit 多人模式：每位角色每次行动的时间限制
     * @param modLife 多人模式：开启生命值模式
     * @param modCheat 多人模式：开启作弊模式
     * @param modCure 多人模式：开启治愈模式
     * @param stepTotal 记录走过的步数
     * @param timeTotal 记录经过的时间
     * @param mapMatrix 地图矩阵：-1为雷，0~8为周边雷数
     * @param statusMatrix 状态矩阵：null 无状态；flagged 插旗；opened 开启
     * @param loadSave 是否为读取存档（true：该数据从存档中读取得到；false：不是）
     */
    public Game(int blockNumX, int blockNumY, int mineNum, byte timeAttri, byte landAttri, byte charaNum,
                boolean charaRedChosen, boolean charaBluChosen, boolean charaGreChosen, boolean charaPulChosen,
                boolean modCascade, int modStepLimit, int modTimeLimit,
                boolean modLife, boolean modCheat, boolean modCure,
                int stepTotal, int timeTotal,
                byte[][] mapMatrix, String[][] statusMatrix,
                boolean loadSave) {
        this.blockNumX = blockNumX;
        this.blockNumY = blockNumY;
        this.mineNum = mineNum;
        this.timeAttri = timeAttri;
        this.landAttri = landAttri;
        this.charaNum = charaNum;
        this.charaRedChosen = charaRedChosen;
        this.charaBluChosen = charaBluChosen;
        this.charaGreChosen = charaGreChosen;
        this.charaPurChosen = charaPulChosen;
        this.modCascade = modCascade;
        this.stepLim = modStepLimit;
        this.timeLim = modTimeLimit;
        this.modLife = modLife;
        this.modCheat = modCheat;
        this.modCure = modCure;
        this.stepTotal = stepTotal;
        this.timeTotal = timeTotal;
        this.mapMatrix = mapMatrix;
        this.statusMatrix = statusMatrix;
        this.loadSave = loadSave;
    }

    /* set get方法 */
    public int getBlockNumX() { return blockNumX; }
    public void setBlockNumX(int blockNumX) { this.blockNumX = blockNumX; }

    public int getBlockNumY() { return blockNumY; }
    public void setBlockNumY(int blockNumY) { this.blockNumY = blockNumY; }

    public int getMineNum() { return mineNum; }
    public void setMineNum(int mineNum) { this.mineNum = mineNum; }

    public byte getTimeAttri() { return timeAttri; }
    public void setTimeAttri(byte timeAttri) { this.timeAttri = timeAttri; }

    public byte getLandAttri() { return landAttri; }
    public void setLandAttri(byte landAttri) { this.landAttri = landAttri; }

    public byte getCharaNum() { return charaNum; }
    public void setCharaNum(byte charaNum) { this.charaNum = charaNum; }

    public boolean isCharaRedChosen() { return charaRedChosen; }
    public void setCharaRedChosen(boolean charaRedChosen) { this.charaRedChosen = charaRedChosen; }

    public boolean isCharaBluChosen() { return charaBluChosen; }
    public void setCharaBluChosen(boolean charaBluChosen) { this.charaBluChosen = charaBluChosen; }

    public boolean isCharaGreChosen() { return charaGreChosen; }
    public void setCharaGreChosen(boolean charaGreChosen) { this.charaGreChosen = charaGreChosen; }

    public boolean isCharaPurChosen() { return charaPurChosen; }
    public void setCharaPurChosen(boolean charaPurChosen) { this.charaPurChosen = charaPurChosen; }

    public boolean isModCascade() { return modCascade; }
    public void setModCascade(boolean modCascade) { this.modCascade = modCascade; }

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

    public byte[][] getMapMatrix() { return mapMatrix; }
    public void setMapMatrix(byte[][] mapMatrix) { this.mapMatrix = mapMatrix; }

    public String[][] getStatusMatrix() { return statusMatrix; }
    public void setStatusMatrix(String[][] statusMatrix) { this.statusMatrix = statusMatrix; }

    public boolean isLoadSave() { return loadSave; }
    public void setLoadSave(boolean loadSave) { this.loadSave = loadSave; }
}

