package Module.Animation;

import Bean.TimeData;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.Random;

/**
 * <strong><big>下雪动画  Snow Animation</big></strong>
 *
 * <p>该动画借助TranslateTransition（位移动画）类，控制至多1200个“雪粒”以随机的速率、起止点循环运动，以实现下雪效果。</p>
 *
 * <p>雪粒：边长为6以内随机数的正方形，颜色在白色——浅灰蓝之间扰动。</p>
 *
 * <p>单个雪粒的运动：反复地以均匀速度从起始点直线运动到终止点。<br />
 * <ul>
 * <li>起始点：X坐标为-500~2400像素间的随机值，Y坐标为-20像素；</li>
 * <li>终止点：X坐标为起始点X坐标左右1000像素内的随机值，Y坐标为1180；</li>
 * <li>运动周期：10~50秒间的随机值；</li>
 * <li>运动速度：起始点与中止点间的直线距离 / 运动周期。</li>
 * </ul>
 * </p>
 *
 * <p>雪粒群：从动画开始运行的一瞬间起，在接下来的30秒内，每0.1秒新增4个雪粒，并令其进行上述运动，最多有1200个雪粒同时运动。由
 * 于雪花运动起止点在窗口范围外，窗口显示的雪粒个数小于该数。宏观上，降雪速率最终稳定在40雪粒/秒（含窗口的不可视区域）。</p>
 *
 * <p>作者制作本动画时，参考了<a href="https://github.com/ajithkp560/SnowFallingAnimationJavaFX">ajithkp560的作品</a>，
 * 并对其进行了大幅魔改和优化。代表性改动如下：
 * <ul>
 * <li>将“一次性向动画内添加所有雪粒”改为“前30秒内，每隔0.1秒添加4颗雪粒”，以缓解原作动画 播放一段时间后降雪速率会发生一次突变 的问题。</li>
 * <li>将雪粒从圆形改为方形，以适应本作品的像素风格。</li>
 * <li>将雪粒的颜色从纯白改为随机的浅灰蓝色。</li>
 * <li>将被建议废弃的TranslateTransitionBuilder方法替换成TranslateTransition方法。</li>
 * </ul>
 * </p>
 *
 * @author 分柿方橙
 * @version ver 1.1 (2021.7.10)
 * @since ver 1.1.3 (2021.7.9)
 *
 * <i>更新日志·摘要
 *
 * <p>ver 1.1  2021.7.10<br />
 * 1. [增]增加雪粒颜色扰动<br />
 * 2. [改]调整参数细节
 * </p>
 *
 * <p>ver 1.0  2021.7.9<br />
 * 1. [增]引入本类<br />
 * 2. [改]替换被建议废弃的TTB方法为TT方法（见上）<br />
 * 3. [改]设置动画播放前30秒内，每隔0.1秒添加4颗雪粒<br />
 * 4. [改]调整参数细节
 * </p>
 * </i>
 */
public class Snow {

    /**
     * <p>含参建造器：添加下雪动画</p>
     *
     * <p>基本用法：
     * <code>
     *     Group snowSet = new Group();
     *     new Snow(snowSet);
     *     // 记得把snowSet添加进Group root。
     * </code></p>
     *
     * <p>魔性用法：
     * <li>可以直接向Group root里添加本动画：
     * <code>
     *     new Snow(root)
     * </code>
     * </li>
     * <li>可以对一个Group多次添加动画，以获得多倍的雪：
     * <code>
     *     Group snowSet = new Group();
     *     new Snow(snowSet);
     *     new Snow(snowSet);
     *     new Snow(snowSet);
     *     new Snow(snowSet);
     *     new Snow(snowSet);
     *     ......
     *     // 记得把snowSet添加进Group root。
     * </code>
     * </li>
     * </p>
     *
     * @param snowSet “雪的集合”群组
     */
    public Snow(Group snowSet){
        /* 创建一个时间数据类，用于记录时间 */
        TimeData timeSnow = new TimeData(0);

        /* 创建时间线动画：每1000毫秒（0.1秒）执行一次，并发生以下事件 */
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(100), e ->{
            timeSnow.run(); // 时间值+1
            if (timeSnow.getValue() < 300){
                for (int i = 0; i < 4; i++) {
                    Rectangle[] snow = new Rectangle[4]; //创建一个长方形数组
                    double sideLength = (new Random()).nextDouble() * 6; //边长：6以内随机值
                    snow[i] = new Rectangle(-100, -100, sideLength, sideLength); //先创建在(-100,-100位置)
                    snow[i].setFill(Color.hsb(200,
                            new Random().nextDouble() / 15,
                            1 - new Random().nextDouble() / 15)); //颜色：随机的浅灰蓝
                    snowSet.getChildren().add(snow[i]);
                    SnowAnimation(snow[i]); //设置落雪动画。
                }
            } // 增加4片雪花
        }));
        timeline.setCycleCount(Timeline.INDEFINITE); //无限循环
        timeline.play();
    }

    /**
     * 为每片雪花设置落雪动画
     *
     * @param snow 单片雪花
     */
    private void SnowAnimation(Rectangle snow) {
        int time = 10 + (new Random()).nextInt(40); //周期：10~50秒中随机值
        /* 创建位移动画 */
        TranslateTransition snowAnimation = new TranslateTransition();
        snowAnimation.setNode(snow);
        snowAnimation.setDuration(Duration.seconds(time));

        int xInitial = new Random().nextInt(2900) - 500;
        int xFinal = new Random().nextInt(2000) - 1000 + xInitial;
        snowAnimation.setFromX(xInitial); // 起始位置X坐标：-500~2400内随机值
        snowAnimation.setToX(xFinal); // 终止位置X坐标：起始位置X坐标左右1000内随机值
        snowAnimation.setFromY(-20); //起始位置Y坐标：-20
        snowAnimation.setToY(1180); //终止位置Y坐标：1180
        snowAnimation.setOnFinished(t -> SnowAnimation(snow));
        snowAnimation.play();
    }
}
