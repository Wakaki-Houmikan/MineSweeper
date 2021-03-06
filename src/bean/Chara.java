package bean;

/**
 * <strong>角色数据  Character Data</strong>
 * <p>
 * 记录游戏中各角色的数据。
 *
 * @author 分柿方橙
 * @version ver 1.2 (2021.7.7)
 * @since ver 1.1.0 (2021.7.5)
 */
public class Chara {

    /** 选中 */
    private boolean chosen;
    /** 颜色 */
    private String color;
    /** 名字 */
    private String name;
    /** 分数 */
    private int score;
    /** 失误 */
    private int miss;

    /** 时间上限 */
    private int timeLim;
    /** 步数上限 */
    private int stepLim;
    /** 生命上限 */
    private int lifeLim;

    /** 剩余时间 */
    private int timeLeft;
    /** 剩余步数 */
    private int stepLeft;
    /** 剩余生命 */
    private int lifeLeft;

    /**  */
    private boolean onRound; // 是不是现在回合
    /**  */
    private boolean robot;   // 是不是机器人
    /**  */
    private boolean dead;    // 有没有死
    /**  */
    private boolean win;     // 有没有赢

    /**
     * 无参构造器：空壳
     */
    public Chara(){

    }

    /**
     * 一般构造器：记录角色的属性值。
     *
     * @param chosen 是否选中（这里应为true）
     * @param color 颜色（红、蓝、绿、紫）
     * @param name 角色名
     * @param score 得分
     * @param miss 失误
     * @param timeLim 时间上限
     * @param stepLim 步数上限
     * @param lifeLim 生命上限
     * @param timeLeft 剩余时间
     * @param stepLeft 剩余步数
     * @param lifeLeft 剩余生命
     * @param onRound 是否处于现回合
     * @param robot 是否处于机器人状态
     * @param dead 是否处于死亡状态
     * @param win 是否被判定为胜利
     */
    public Chara(boolean chosen, String color, String name, int score, int miss,
                 int timeLim, int stepLim, int lifeLim,
                 int timeLeft, int stepLeft, int lifeLeft,
                 boolean onRound, boolean robot, boolean dead, boolean win) {
        this.chosen = chosen;
        this.color = color;
        this.name = name;
        this.score = score;
        this.miss = miss;
        this.timeLim = timeLim;
        this.stepLim = stepLim;
        this.lifeLim = lifeLim;
        this.timeLeft = timeLeft;
        this.stepLeft = stepLeft;
        this.lifeLeft = lifeLeft;
        this.onRound = onRound;
        this.robot = robot;
        this.dead = dead;
        this.win = win;
    }

    /**
     * 简单构造器：只将chosen（“是否选中”）属性记录为false。
     *
     * @param chosen 是否选中
     */
    public Chara(boolean chosen) {
        this.chosen = chosen;
    }

    /* 一系列的set get方法 */
    public boolean isChosen() { return chosen; }
    public void setChosen(boolean chosen) { this.chosen = chosen; }

    public String getColor() { return color; }
    public void getColor(String color) { this.color = color; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }

    public int getMiss() { return miss; }
    public void setMiss(int miss) { this.miss = miss; }

    public int getTimeLim() { return timeLim; }
    public void setTimeLim(int timeLim) { this.timeLim = timeLim; }

    public int getStepLim() { return stepLim; }
    public void setStepLim(int stepLim) { this.stepLim = stepLim; }

    public int getLifeLim() { return lifeLim; }
    public void setLifeLim(int lifeLim) { this.lifeLim = lifeLim; }

    public int getTimeLeft() { return timeLeft; }
    public void setTimeLeft(int timeLeft) { this.timeLeft = timeLeft; }

    public int getStepLeft() { return stepLeft; }
    public void setStepLeft(int stepLeft) { this.stepLeft = stepLeft; }

    public int getLifeLeft() { return lifeLeft; }
    public void setLifeLeft(int lifeLeft) { this.lifeLeft = lifeLeft; }

    public boolean isOnRound() { return onRound; }
    public void setOnRound(boolean onRound) { this.onRound = onRound; }

    public boolean isRobot() { return robot; }
    public void setRobot(boolean robot) { this.robot = robot; }

    public boolean isDead() { return dead; }
    public void setDead(boolean dead) { this.dead = dead; }

    public boolean isWin() { return win; }
    public void setWin(boolean win) { this.win = win; }
}