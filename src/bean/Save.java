package bean;

import java.io.Serializable;

/**
 * <strong><big>存档  Save Data</big></strong>
 *
 * <p>记录正在运行的游戏的所有数据，可直接用来存档。</p>
 *
 * @author 分柿方橙
 * @version ver 0.1 (2021.7.13)
 * @since ver 1.1.6 (2021.7.13)
 */
public class Save implements Serializable {
    public static Game game;

    public static Chara charaRed;
    public static Chara charaBlu;
    public static Chara charaGre;
    public static Chara charaPur;

    public static Timer timeMain;
    public static Timer timeChara;
}
