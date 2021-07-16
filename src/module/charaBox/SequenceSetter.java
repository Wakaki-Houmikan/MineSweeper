package module.charaBox;

import bean.Save;
import javafx.scene.Group;

/**
 * <strong><big>角色卡片·序列设置  Sequence Setter</big></strong>
 *
 * <p>为角色卡片设置排布次序。</p>
 *
 * @author 分柿方橙
 * @version ver 1.0 (2021.7.16)
 * @since ver 1.1.8 (2021.7.16)
 */
public class SequenceSetter {

    /**
     * <p>为角色框进行排序，保证从上到下次序为红、蓝、绿、紫</p>
     *
     * @param redCard 角色卡片组
     * @param bluCard 角色卡片组
     * @param greCard 角色卡片组
     * @param purCard 角色卡片组
     */
    public static void sequenceSetter (Group redCard, Group bluCard, Group greCard, Group purCard){
        byte hasAdded = 0;

        if (Save.game.getCharaNum() < 2) {
            return;
        }

        if (Save.game.isCharaPurChosen()){
            purCard.setLayoutX(50);
            purCard.setLayoutY(770);
            hasAdded++;
        }
        if (Save.game.isCharaGreChosen()){
            greCard.setLayoutX(50);
            greCard.setLayoutY(770 - hasAdded * 175);
            hasAdded++;
        }
        if (Save.game.isCharaBluChosen()){
            bluCard.setLayoutX(50);
            bluCard.setLayoutY(770 - hasAdded * 175);
            hasAdded++;
        }
        if (Save.game.isCharaRedChosen()){
            redCard.setLayoutX(50);
            redCard.setLayoutY(770 - hasAdded * 175);
        }
    }
}
