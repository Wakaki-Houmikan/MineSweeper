package module.charaBox;

import graphics.ICSetter;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

/**
 * <strong><big>角色卡片·蓝  Character Card · Blue</big></strong>
 *
 * <p>展示在游戏运行界面的蓝队角色小卡片。</p>
 *
 * @author 分柿方橙
 * @version ver 1.1 (2021.7.16)
 * @since ver 1.1.7 (2021.7.15)
 */
public class BluCard extends CharaCard {

    /**
     * <p>含参构造器：往给定控件组中加入一个蓝队角色卡片</p>
     *
     * <p>基本用法：<br>
     * <code>
     *     Group bluCardGroup = new Group();<br>
     *     BluCard bluCard = new BluCard(bluCardGroup);<br>
     *     root.getChildren().addAll(bluCard);<br>
     * </code>
     * 能创建并向根组里加入一个蓝队角色卡片。
     * </p>
     *
     * <p>注：对该卡片进行后续使用前需确保已创建Save.game和Save.charaBlu并赋值，否则可能报错。</p>
     *
     * @param bluCardGroup 蓝队卡片
     */
    public BluCard(Group bluCardGroup) {
        super(bluCardGroup);

        /* 打开背景图 */
        ImageView bluCardBG = new ImageView(ICSetter.BluCardBG);
        bluCardBG.setX(0); bluCardBG.setY(0); bluCardBG.setOpacity(0.8);
        bluCardGroup.getChildren().addAll(bluCardBG);

        /* 使用共用方法创建角色卡片 */
        setCardCommon(bluCardGroup);

        /* 个性化设置 */
        timeLefLab.setFill(Color.DARKBLUE);
        stepLefLab.setFill(Color.DARKBLUE);
        scoreLab.setFill(Color.DARKBLUE);
        missLab.setFill(Color.DARKBLUE);
        lifeLab.setFill(Color.DARKBLUE);

        /* 托管 */
        robot.setOnAction(this::charaBluRobot);
        bluCardGroup.getChildren().addAll(robot);

    }

    private void charaBluRobot(ActionEvent actionEvent) {
    }
}