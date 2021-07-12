package module.animation;

import bean.Timer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.ArrayList;

public class Climate {

    /* 长方形数组：颗粒 */
    Rectangle[] particle = new Rectangle[2000];

    /* 计时器：记录时间 */
    static Timer timer = new Timer(0);

    static ArrayList<TranslateTransition> climateTranslation = new ArrayList<>();
    static ArrayList<Rectangle> climateRectangle = new ArrayList<>();


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
        });
        timeline.play();
    }
}
