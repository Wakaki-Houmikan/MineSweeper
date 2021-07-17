package bean;

import java.io.Serializable;

/**
 * <strong>存档  Save Data</strong>
 * <p>
 * 记录正在运行的游戏的所有数据，可直接用来存档。
 *
 * @author 分柿方橙
 * @version ver 0.1 (2021.7.13)
 * @since ver 1.1.6 (2021.7.13)
 */
public class Save implements Serializable {
    /**
     * 游戏数据
     */
    public static Game game;

    /**
     * 角色数据：红
     */
    public static Chara charaRed;
    /**
     * 角色数据·蓝
     */
    public static Chara charaBlu;
    /**
     * 角色数据·绿
     */
    public static Chara charaGre;
    /**
     * 角色数据·紫
     */
    public static Chara charaPur;

    /**
     * 计时器：游戏
     */
    public static Timer timerGame;
    /**
     * 计时器：角色
     */
    public static Timer timerChara;
}
