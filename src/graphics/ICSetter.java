package graphics;

import javafx.scene.image.ImageView;

/* Icon Setter */
public class ICSetter {
    /* 基底 */
    public final ImageView bluBase = new ImageView(String.valueOf(ICSetter.class.getResource("/graphics/IC/blockBaseBlu.png")));
    public final ImageView greBase = new ImageView(String.valueOf(ICSetter.class.getResource("/graphics/IC/blockBaseGre.png")));
    public final ImageView redBase = new ImageView(String.valueOf(ICSetter.class.getResource("/graphics/IC/blockBaseRed.png")));

    /* 黑暗：用于夜晚 */
    public final ImageView bluDark = new ImageView(String.valueOf(ICSetter.class.getResource("/graphics/IC/blockBluDark.png")));
    public final ImageView greDark = new ImageView(String.valueOf(ICSetter.class.getResource("/graphics/IC/blockGreDark.png")));
    public final ImageView redDark = new ImageView(String.valueOf(ICSetter.class.getResource("/graphics/IC/blockRedDark.png")));
    /* 普通：用于白天、夜晚鼠标划过 */
    public final ImageView bluNorm = new ImageView(String.valueOf(ICSetter.class.getResource("/graphics/IC/blockBluNorm.png")));
    public final ImageView greNorm = new ImageView(String.valueOf(ICSetter.class.getResource("/graphics/IC/blockGreNorm.png")));
    public final ImageView redNorm = new ImageView(String.valueOf(ICSetter.class.getResource("/graphics/IC/blockRedNorm.png")));
    /* 明亮：用于白天鼠标划过 */
    public final ImageView bluShiny = new ImageView(String.valueOf(ICSetter.class.getResource("/graphics/IC/blockBluShiny.png")));
    public final ImageView greShiny = new ImageView(String.valueOf(ICSetter.class.getResource("/graphics/IC/blockGreShiny.png")));
    public final ImageView redShiny = new ImageView(String.valueOf(ICSetter.class.getResource("/graphics/IC/blockRedShiny.png")));

    /* 黑暗旗子：夜晚插旗 */
    public final ImageView bluDarkFlag = new ImageView(String.valueOf(ICSetter.class.getResource("/graphics/IC/blockBluDarkFlag.png")));
    public final ImageView greDarkFlag = new ImageView(String.valueOf(ICSetter.class.getResource("/graphics/IC/blockGreDarkFlag.png")));
    public final ImageView redDarkFlag = new ImageView(String.valueOf(ICSetter.class.getResource("/graphics/IC/blockRedDarkFlag.png")));
    /* 普通旗子：白天插旗 */
    public final ImageView bluNormFlag = new ImageView(String.valueOf(ICSetter.class.getResource("/graphics/IC/blockBluNormFlag.png")));
    public final ImageView greNormFlag = new ImageView(String.valueOf(ICSetter.class.getResource("/graphics/IC/blockGreNormFlag.png")));
    public final ImageView redNormFlag = new ImageView(String.valueOf(ICSetter.class.getResource("/graphics/IC/blockRedNormFlag.png")));

    /* 数字1~8 */
    public final ImageView num1 = new ImageView(String.valueOf(ICSetter.class.getResource("/graphics/IC/num1.png")));
    public final ImageView num2 = new ImageView(String.valueOf(ICSetter.class.getResource("/graphics/IC/num2.png")));
    public final ImageView num3 = new ImageView(String.valueOf(ICSetter.class.getResource("/graphics/IC/num3.png")));
    public final ImageView num4 = new ImageView(String.valueOf(ICSetter.class.getResource("/graphics/IC/num4.png")));
    public final ImageView num5 = new ImageView(String.valueOf(ICSetter.class.getResource("/graphics/IC/num5.png")));
    public final ImageView num6 = new ImageView(String.valueOf(ICSetter.class.getResource("/graphics/IC/num6.png")));
    public final ImageView num7 = new ImageView(String.valueOf(ICSetter.class.getResource("/graphics/IC/num7.png")));
    public final ImageView num8 = new ImageView(String.valueOf(ICSetter.class.getResource("/graphics/IC/num8.png")));

}
