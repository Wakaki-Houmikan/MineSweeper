package module.charaBox;

import graphics.ICSetter;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

/**
 * <strong><big>角色卡片·紫  Character Card · Purple</big></strong>
 *
 * <p>展示在游戏运行界面的紫队角色小卡片。</p>
 *
 * @author 分柿方橙
 * @version ver 1.1 (2021.7.16)
 * @since ver 1.1.7 (2021.7.15)
 */
public class PurCard extends CharaCard {

    /**
     * <p>含参构造器：往给定控件组中加入一个紫队角色卡片</p>
     *
     * <p>基本用法：<br>
     * <code>
     *     Group purCardGroup = new Group();<br>
     *     PurCard purCard = new PurCard(purCardGroup);<br>
     *     root.getChildren().addAll(purCard);<br>
     * </code>
     * 能创建并向根组里加入一个紫队角色卡片。
     * </p>
     *
     * <p>注：对该卡片进行后续使用前需确保已创建Save.game和Save.charaPur并赋值，否则可能报错。</p>
     *
     * @param purCardGroup 紫队卡片
     */
    public PurCard(Group purCardGroup) {
        super(purCardGroup);

        /* 打开背景图 */
        ImageView purCardBG = new ImageView(ICSetter.GreCardBG);
        purCardBG.setX(0); purCardBG.setY(0); purCardBG.setOpacity(0.8);
        purCardGroup.getChildren().addAll(purCardBG);

        /* 使用共用方法创建角色卡片 */
        setCardCommon(purCardGroup);

        /* 个性化设置 */
        timeLefLab.setFill(Color.PURPLE);
        stepLefLab.setFill(Color.PURPLE);
        scoreLab.setFill(Color.PURPLE);
        missLab.setFill(Color.PURPLE);
        lifeLab.setFill(Color.PURPLE);

        /* 托管 */
        robot.setOnAction(this::charaPurRobot);
        purCardGroup.getChildren().addAll(robot);

    }

    private void charaPurRobot(ActionEvent actionEvent) {
    }
}