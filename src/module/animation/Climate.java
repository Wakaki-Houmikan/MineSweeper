package module.animation;

import bean.Timer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.ArrayList;

/**
 * <strong>气候动画  Climate Animation</strong>
 * <p>
 * 该动画借助TranslateTransition（位移动画）类，控制1200个籽粒以随机的速率从起始点往终止点单向运动，以实现气候效果（下雪、烟雾）。
 * <p>
 * 籽粒：边长为6以内随机数的正方形，颜色存在一定扰动。
 * <p>
 * 单个籽粒的运动：反复地以均匀速度从起始点直线运动到终止点。技术细节参见其子类的帮助文档。
 * <p>
 * 籽粒群：从动画开始运行的一瞬间起，在接下来的一定时间内，每0.1秒新增4个籽粒，并令其进行上述运动，周而复始。
 * <p>
 * 作者制作本动画时，参考了<a href="https://github.com/ajithkp560/SnowFallingAnimationJavaFX">ajithkp560的作品</a>，
 * 并对其进行了大幅魔改和优化。代表性改动如下：
 * <ul>
 * <li>将“一次性向动画内添加所有籽粒”改为“动画刚开始的一段时间内，每隔0.1秒添加4颗籽粒”，以缓解原作动画 播放一段时间后 籽粒运动速率会发生一次突变 的问题。</li>
 * <li>将籽粒从圆形改为方形，以适应本作品的像素风格。</li>
 * <li>将籽粒的颜色从固定（纯白）改为小范围内随机扰动。</li>
 * <li>将被建议废弃的TranslateTransitionBuilder方法替换成TranslateTransition方法。</li>
 * </ul>
 *
 * @author 分柿方橙
 * @version ver 0.1 (2021.7.12)
 * @since ver 1.1.5 (2021.7.12)
 */
public class Climate {

    /* 长方形数组：颗粒 */
    Rectangle[] particle = new Rectangle[2000];

    /**
     * 计时器：记录时间
     */
    static Timer timer = new Timer(0);

    /**
     * TranslateTransition队列，存放所有平移动画
     */
    static ArrayList<TranslateTransition> climateTranslation = new ArrayList<>();
    /**
     * Rectangle队列，存放所有籽粒
     */
    static ArrayList<Rectangle> climateRectangle = new ArrayList<>();

    /**
     * 含参建造器：添加气候动画
     * <p>
     * 以下以“落雪动画”为例，创建烟雾动画把所有“snow/Snow”改成“smog/Smog”即可
     * <p>
     * 基本用法：<br>
     * 　　Group snowSet = new Group();<br>
     * 　　new Snow(snowSet);<br>
     * 　　// 记得把snowSet添加进Group root。
     * <p>
     * 魔性用法：<br>
     * 1. 可以直接向Group root里添加本动画：<br>
     * 　　new Snow(root)<br>
     * 2. 可以对一个Group多次添加动画，以获得多倍的雪：<br>
     * 　　Group snowSet = new Group();<br>
     * 　　new Snow(snowSet);<br>
     * 　　new Snow(snowSet);<br>
     * 　　new Snow(snowSet);<br>
     * 　　new Snow(snowSet);<br>
     * 　　new Snow(snowSet);<br>
     * 　　......<br>
     * 　　// 记得把snowSet添加进Group root。
     *
     * @param climateSet “雪的集合”群组
     */
    public Climate(Group climateSet) {

    }

    /**
     * 停止所有气候动画
     * <p>
     * 令所有正在运动的籽粒的不透明度渐渐降低直至它们淡出，然后将它们删去。
     */
    public static void climateStop(){

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(100), e ->{
            timer.setValue(1000);
            for (Rectangle rectangle : climateRectangle) {
                if (!(rectangle.getOpacity() > 0)) {
                    continue;
                }
                rectangle.setOpacity(rectangle.getOpacity() - 0.04);
            }
        }));
        timeline.setCycleCount(50);
        timeline.setOnFinished(e -> {
            for (TranslateTransition translateTransition : climateTranslation) {
                translateTransition.stop();
            }
            climateTranslation.clear();
            climateRectangle.clear();
        });
        timeline.play();
    }
}
