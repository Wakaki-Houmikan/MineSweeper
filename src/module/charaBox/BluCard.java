package module.charaBox;

import graphics.ICSetter;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

/**
 * <strong><big>角色卡片·蓝  Character Card · Blue</big></strong>
 *
 * <p>展示在游戏运行界面的蓝队角色小卡片。</p>
 *
 * @author 分柿方橙
 * @version ver 1.0 (2021.7.15)
 * @since ver 1.1.7 (2021.7.15)
 */
public class BluCard extends CharaCard {

    /**
     * 含参构造器：创建一个蓝队角色卡片
     *
     * @param bluCard 蓝队卡片
     */
    public BluCard(Group bluCard) {
        super(bluCard);

        /* 打开背景图 */
        ImageView bluCardBG = new ImageView(ICSetter.BluCardBG);
        bluCardBG.setX(0); bluCardBG.setY(0); bluCardBG.setOpacity(0.8);
        bluCard.getChildren().addAll(bluCardBG);

        /* 使用共用方法创建角色卡片 */
        setCardCommon(bluCard);

        /* 个性化设置 */
        timeLefLab.setFill(Color.DARKBLUE);
        stepLefLab.setFill(Color.DARKBLUE);
        scoreLab.setFill(Color.DARKBLUE);
        missLab.setFill(Color.DARKBLUE);
        lifeLab.setFill(Color.DARKBLUE);

    }
}