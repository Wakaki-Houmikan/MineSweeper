package resources.graphics;

import javafx.scene.image.Image;

/**
 * <strong>图标设置器  Icon Setter</strong>
 *
 * <p>内置src/resources/graphics/IC下用Image打包的游戏图标，可重复使用。</p>
 *
 * @author 分柿方橙
 * @version ver 0.2 (2021.7.15)
 * @since ver 1.1.0 (2021.7.5)
 */
public class ICSetter {
    /* 基底 */
    public static final Image BluBase = new Image ("/resources/graphics/IC/blockBaseBlu.png");
    public static final Image GreBase = new Image ("/resources/graphics/IC/blockBaseGre.png");
    public static final Image RedBase = new Image ("/resources/graphics/IC/blockBaseRed.png");

    /* 黑暗：用于夜晚 */
    public static final Image BluDark = new Image ("/resources/graphics/IC/blockBluDark.png");
    public static final Image GreDark = new Image ("/resources/graphics/IC/blockGreDark.png");
    public static final Image RedDark = new Image ("/resources/graphics/IC/blockRedDark.png");
    /* 普通：用于白天、夜晚鼠标划过 */
    public static final Image BluNorm = new Image ("/resources/graphics/IC/blockBluNorm.png");
    public static final Image GreNorm = new Image ("/resources/graphics/IC/blockGreNorm.png");
    public static final Image RedNorm = new Image ("/resources/graphics/IC/blockRedNorm.png");
    /* 明亮：用于白天鼠标划过 */
    public static final Image BluShiny = new Image ("/resources/graphics/IC/blockBluShiny.png");
    public static final Image GreShiny = new Image ("/resources/graphics/IC/blockGreShiny.png");
    public static final Image RedShiny = new Image ("/resources/graphics/IC/blockRedShiny.png");

    /* 黑暗旗子：夜晚插旗 */
    public static final Image BluDarkFlag = new Image ("/resources/graphics/IC/blockBluDarkFlag.png");
    public static final Image GreDarkFlag = new Image ("/resources/graphics/IC/blockGreDarkFlag.png");
    public static final Image RedDarkFlag = new Image ("/resources/graphics/IC/blockRedDarkFlag.png");
    /* 普通旗子：白天插旗 */
    public static final Image BluNormFlag = new Image ("/resources/graphics/IC/blockBluNormFlag.png");
    public static final Image GreNormFlag = new Image ("/resources/graphics/IC/blockGreNormFlag.png");
    public static final Image RedNormFlag = new Image ("/resources/graphics/IC/blockRedNormFlag.png");

    /* 数字1~8 */
    public static final Image Num1 = new Image ("/resources/graphics/IC/num1.png");
    public static final Image Num2 = new Image ("/resources/graphics/IC/num2.png");
    public static final Image Num3 = new Image ("/resources/graphics/IC/num3.png");
    public static final Image Num4 = new Image ("/resources/graphics/IC/num4.png");
    public static final Image Num5 = new Image ("/resources/graphics/IC/num5.png");
    public static final Image Num6 = new Image ("/resources/graphics/IC/num6.png");
    public static final Image Num7 = new Image ("/resources/graphics/IC/num7.png");
    public static final Image Num8 = new Image ("/resources/graphics/IC/num8.png");

    /* 地雷 */
    public static final Image Spikey = new Image ("/resources/graphics/IC/spikeySilver.png");
    public static final Image SpikeyWrong = new Image ("/resources/graphics/IC/spikeyRed.png");
    public static final Image SpikeyMiss = new Image ("/resources/graphics/IC/spikeyMiss.png");

    /* 角色卡片 */
    public static final Image RedCardBG = new Image ("/resources/graphics/IC/charaRed.png");
    public static final Image BluCardBG = new Image ("/resources/graphics/IC/charaBlu.png");
    public static final Image GreCardBG = new Image ("/resources/graphics/IC/charaGre.png");
    public static final Image PurCardBG = new Image ("/resources/graphics/IC/charaPur.png");

    /* 角色头像：工作 */
    public static final Image Working = new Image ("/resources/graphics/IC/statusShovel.png");
    /* 角色头像：摸鱼 */
    public static final Image FishRed = new Image ("/resources/graphics/IC/statusFishRed.png");
    public static final Image FishBlu = new Image ("/resources/graphics/IC/statusFishBlu.png");
    public static final Image FishGre = new Image ("/resources/graphics/IC/statusFishGre.png");
    public static final Image FishPur = new Image ("/resources/graphics/IC/statusFishPur.png");
    /* 角色头像：托管 */
    public static final Image BotRed = new Image ("/resources/graphics/IC/statusBotRed.png");
    public static final Image BotBlu = new Image ("/resources/graphics/IC/statusBotBlu.png");
    public static final Image BotGre = new Image ("/resources/graphics/IC/statusBotGre.png");
    public static final Image BotPur = new Image ("/resources/graphics/IC/statusBotPur.png");
    public static final Image BotWorking = new Image ("/resources/graphics/IC/statusBotShovel.png");
    /* 角色头像：生死 */
    public static final Image Win = new Image ("/resources/graphics/IC/statusWin.png");
    public static final Image Dead = new Image ("/resources/graphics/IC/statusDead.png");

    /* 生命值 */
    public static final Image Life = new Image ("/resources/graphics/IC/life.png");

}
