package module.animation;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.Random;

/**
 * <strong><big>烟雾动画  Smog Animation</big></strong>
 *
 * <p>该动画借助TranslateTransition（位移动画）类，控制400个“烟粒”以随机的速率、起止点反复运动，以实现烟雾效果。</p>
 *
 * <p>关于该动画的主要技术原理，参见其父类（Climate类）帮助文档{@link /src/Module/Animation/Climate.java}。</p>
 *
 * <p>单粒烟雾的运动参数：<br>
 * <ul>
 * <li>起始点：X坐标为-500~2400像素间的随机值，Y坐标为1180像素；</li>
 * <li>终止点：X坐标为起始点X坐标左右1000像素内的随机值，Y坐标为随机值；</li>
 * <li>运动周期：10~40秒间的随机值；</li>
 * <li>运动速度：起始点与中止点间的直线距离 / 运动周期。</li>
 * </ul>
 * </p>
 *
 * @author 分柿方橙
 * @version ver 0.3 (2021.7.13)
 * @since ver 1.1.4 (2021.7.10)
 */
public class Smog extends Climate {

    /**
     * <p>含参建造器：添加烟雾动画</p>
     *
     * <p>用法参见Climate类帮助文档。</p>
     *
     * @param smogSet “烟的集合”群组
     */
    public Smog(Group smogSet){
        super(smogSet);

        /* 创建时间线动画：每1000毫秒（0.1秒）执行一次，并发生以下事件 */
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(100), e ->{
            timer.run(); // 时间值+1

            if (timer.getValue() < 100){
                for (int i = 0; i < 4; i++) {
                    double sideLength = (new Random()).nextDouble() * 6; //边长：6以内随机值
                    particle[timer.getValue() * 4 + i] = new Rectangle(-100, -100, sideLength, sideLength); //先创建在(-100,-100位置)
                    particle[timer.getValue() * 4 + i].setFill(Color.hsb(200,
                            new Random().nextDouble() / 15,
                            1 - new Random().nextDouble() / 15)); //颜色：随机的浅灰蓝

                    climateRectangle.add(particle[timer.getValue() * 4 + i]);

                    smogSet.getChildren().add(particle[timer.getValue() * 4 +i]);

                    SmogAnimation(particle[timer.getValue() * 4 +i]); //设置烟雾动画。
                }
            } // 增加4片雪花
        }));
        timeline.setCycleCount(Timeline.INDEFINITE); //无限循环
        timeline.play();
    }

    /**
     * 为每点烟雾设置动画
     *
     * @param smog 单点烟雾
     */
    private void SmogAnimation(Rectangle smog) {
        int time = 10 + (new Random()).nextInt(40); //周期：10~50秒中随机值

        /* 设置透明度 */
        if (time / 10 <= 2){
            smog.setOpacity(1);
        } else if (time / 10 < 4){
            smog.setOpacity(0.64);
        } else {
            smog.setOpacity(0.32);
        }

        /* 创建位移动画 */
        TranslateTransition smogAnimation = new TranslateTransition();
        smogAnimation.setNode(smog);
        smogAnimation.setDuration(Duration.seconds(time));

        int xInitial = new Random().nextInt(2900) - 500;
        int xFinal = new Random().nextInt(2000) - 1000 + xInitial;
        int yFinal = (int) (950 - Math.pow(new Random().nextDouble(),4) * 960);

        smogAnimation.setFromX(xInitial); // 起始位置X坐标：-500~2400内随机值
        smogAnimation.setToX(xFinal); // 终止位置X坐标：起始位置X坐标左右1000内随机值
        smogAnimation.setFromY(1180); //起始位置Y坐标：1180
        smogAnimation.setToY(yFinal); //终止位置Y坐标：随机值
        smogAnimation.setOnFinished(e -> SmogAnimation(smog)); //停止的时候重新播放该动画
        smogAnimation.play();

        climateTranslation.add(smogAnimation);
    }

}
