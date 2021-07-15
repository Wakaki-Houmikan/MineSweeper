package module.charaBox;

import graphics.ICSetter;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

/**
 * <strong><big>角色卡片·绿  Character Card · Green</big></strong>
 *
 * <p>展示在游戏运行界面的绿队角色小卡片。</p>
 *
 * @author 分柿方橙
 * @version ver 1.0 (2021.7.15)
 * @since ver 1.1.7 (2021.7.15)
 */
public class GreCard extends CharaCard {

    /**
     * 含参构造器：创建一个绿队角色卡片
     *
     * @param greCard 绿队卡片
     */
    public GreCard(Group greCard) {
        super(greCard);

        /* 打开背景图 */
        ImageView greCardBG = new ImageView(ICSetter.GreCardBG);
        greCardBG.setX(0); greCardBG.setY(0); greCardBG.setOpacity(0.8);
        greCard.getChildren().addAll(greCardBG);

        /* 使用共用方法创建角色卡片 */
        setCardCommon(greCard);

        /* 个性化设置 */
        timeLefLab.setFill(Color.DARKGREEN);
        stepLefLab.setFill(Color.DARKGREEN);
        scoreLab.setFill(Color.DARKGREEN);
        missLab.setFill(Color.DARKGREEN);
        lifeLab.setFill(Color.DARKGREEN);

    }
}