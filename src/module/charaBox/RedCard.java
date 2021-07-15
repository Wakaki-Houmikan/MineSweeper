package module.charaBox;

import graphics.ICSetter;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

/**
 * <strong><big>角色卡片·红  Character Card · Red</big></strong>
 *
 * <p>展示在游戏运行界面的红队角色小卡片。</p>
 *
 * @author 分柿方橙
 * @version ver 1.0 (2021.7.15)
 * @since ver 1.1.7 (2021.7.15)
 */
public class RedCard extends CharaCard {

    /**
     * 含参构造器：创建一个红队角色卡片
     *
     * @param redCard 红队卡片
     */
    public RedCard(Group redCard) {
        super(redCard);

        /* 打开背景图 */
        ImageView redCardBG = new ImageView(ICSetter.RedCardBG);
        redCardBG.setX(0); redCardBG.setY(0); redCardBG.setOpacity(0.8);
        redCard.getChildren().addAll(redCardBG);

        /* 使用共用方法创建角色卡片 */
        setCardCommon(redCard);

        /* 个性化设置 */
        timeLefLab.setFill(Color.DARKRED);
        stepLefLab.setFill(Color.DARKRED);
        scoreLab.setFill(Color.DARKRED);
        missLab.setFill(Color.DARKRED);
        lifeLab.setFill(Color.DARKRED);
    }
}