package module.charaBox;

import graphics.ICSetter;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

/**
 * <strong><big>角色卡片·绿  Character Card · Green</big></strong>
 *
 * <p>展示在游戏运行界面的绿队角色小卡片。</p>
 *
 * @author 分柿方橙
 * @version ver 1.1 (2021.7.16)
 * @since ver 1.1.7 (2021.7.15)
 */
public class GreCard extends CharaCard {

    /**
     * <p>含参构造器：往给定控件组中加入一个绿队角色卡片</p>
     *
     * <p>基本用法：<br>
     * <code>
     *     Group greCardGroup = new Group();<br>
     *     GreCard greCard = new GreCard(greCardGroup);<br>
     *     root.getChildren().addAll(greCard);<br>
     * </code>
     * 能创建并向根组里加入一个绿队角色卡片。
     * </p>
     *
     * <p>注：对该卡片进行后续使用前需确保已创建Save.game和Save.charaGre并赋值，否则可能报错。</p>
     *
     * @param greCardGroup 绿队卡片
     */
    public GreCard(Group greCardGroup) {
        super(greCardGroup);

        /* 打开背景图 */
        ImageView greCardBG = new ImageView(ICSetter.GreCardBG);
        greCardBG.setX(0); greCardBG.setY(0); greCardBG.setOpacity(0.8);
        greCardGroup.getChildren().addAll(greCardBG);

        /* 使用共用方法创建角色卡片 */
        setCardCommon(greCardGroup);

        /* 个性化设置 */
        timeLefLab.setFill(Color.DARKGREEN);
        stepLefLab.setFill(Color.DARKGREEN);
        scoreLab.setFill(Color.DARKGREEN);
        missLab.setFill(Color.DARKGREEN);
        lifeLab.setFill(Color.DARKGREEN);

        /* 托管 */
        robot.setOnAction(this::charaGreRobot);

    }

    private void charaGreRobot(ActionEvent actionEvent) {
    }
}