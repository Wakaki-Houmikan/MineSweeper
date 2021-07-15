package module.charaBox;

import graphics.ICSetter;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

/**
 * <strong><big>角色卡片·紫  Character Card · Purple</big></strong>
 *
 * <p>展示在游戏运行界面的紫队角色小卡片。</p>
 *
 * @author 分柿方橙
 * @version ver 1.0 (2021.7.15)
 * @since ver 1.1.7 (2021.7.15)
 */
public class PurCard extends CharaCard {

    /**
     * 含参构造器：创建一个紫队角色卡片
     *
     * @param purCard 紫队卡片
     */
    public PurCard(Group purCard) {
        super(purCard);

        /* 打开背景图 */
        ImageView purCardBG = new ImageView(ICSetter.GreCardBG);
        purCardBG.setX(0); purCardBG.setY(0); purCardBG.setOpacity(0.8);
        purCard.getChildren().addAll(purCardBG);

        /* 使用共用方法创建角色卡片 */
        setCardCommon(purCard);

        /* 个性化设置 */
        timeLefLab.setFill(Color.PURPLE);
        stepLefLab.setFill(Color.PURPLE);
        scoreLab.setFill(Color.PURPLE);
        missLab.setFill(Color.PURPLE);
        lifeLab.setFill(Color.PURPLE);

    }
}