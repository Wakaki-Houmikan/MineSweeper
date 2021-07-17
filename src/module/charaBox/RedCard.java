package module.charaBox;

import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import resources.graphics.ICSetter;

/**
 * <strong>角色卡片·红  Character Card · Red</strong>
 *
 * <p>展示在游戏运行界面的红队角色小卡片。</p>
 *
 * @author 分柿方橙
 * @version ver 1.1 (2021.7.16)
 * @since ver 1.1.7 (2021.7.15)
 */
public class RedCard extends CharaCard {

    /**
     * <p>含参构造器：往给定控件组中加入一个红队角色卡片</p>
     *
     * <p>基本用法：<br>
     * <code>
     * 　　Group redCardGroup = new Group();<br>
     * 　　RedCard redCard = new RedCard(redCardGroup);<br>
     * 　　root.getChildren().addAll(redCard);<br>
     * </code>
     * 能创建并向根组里加入一个红队角色卡片。
     * </p>
     *
     * <p>注：对该卡片进行后续使用前需确保已创建Save.game和Save.charaRed并赋值，否则可能报错。</p>
     *
     * @param redCardGroup 红队卡片
     */
    public RedCard(Group redCardGroup) {
        super(redCardGroup);

        /* 打开背景图 */
        ImageView redCardBG = new ImageView(ICSetter.RedCardBG);
        redCardBG.setX(0); redCardBG.setY(0); redCardBG.setOpacity(0.8);
        redCardGroup.getChildren().addAll(redCardBG);

        /* 使用共用方法创建角色卡片 */
        setCardCommon(redCardGroup);

        /* 个性化设置 */
        timeLefLab.setFill(Color.DARKRED);
        stepLefLab.setFill(Color.DARKRED);
        scoreLab.setFill(Color.DARKRED);
        missLab.setFill(Color.DARKRED);
        lifeLab.setFill(Color.DARKRED);

        /* 托管 */
        robot.setOnAction(this::charaRedRobot);

    }

    private void charaRedRobot(ActionEvent actionEvent) {
    }
}