package module.menubar;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

/**
 * <strong><big>游戏菜单  Game Menu</big></strong>
 *
 * <p>可添加至菜单栏的游戏相关控件组，包含暂停游戏、继续游戏、排行榜、重玩本轮、新游戏、退出游戏六项内容。</p>
 *
 * @author 分柿方橙
 * @version ver 1.0 (2021.7.11)
 * @since ver 1.1.5 (2021.7.11)
 */
public class MenuGame {

    /**
     * 建造器：为提供的菜单栏加上游戏相关控件
     *
     * @param menuGame 菜单组
     */
    public MenuGame(Menu menuGame){
        /* 菜单栏 -> 游戏 */
        ToggleGroup itemPC = new ToggleGroup();
        RadioMenuItem itemPause = new RadioMenuItem("暂停游戏");
        itemPause.setToggleGroup(itemPC);
        itemPause.setOnAction(this::pressItemPause);
        RadioMenuItem itemContinue = new RadioMenuItem("继续游戏");
        itemContinue.setToggleGroup(itemPC);
        itemContinue.setOnAction(this::pressItemContinue);
        itemContinue.setDisable(true);//自动禁止继续游戏

        SeparatorMenuItem separG = new SeparatorMenuItem();

        MenuItem itemRankList = new MenuItem("排行榜");
        RadioMenuItem itemRestartThis = new RadioMenuItem("重玩本轮");
        MenuItem itemRestart = new MenuItem("新游戏");
        MenuItem itemExist = new MenuItem("退出游戏");
        menuGame.getItems().addAll(itemPause, itemContinue, separG, itemRankList, itemRestartThis, itemRestart, itemExist);
    }

    private void pressItemPause(ActionEvent actionEvent) {

    }

    private void pressItemContinue(ActionEvent actionEvent) {

    }


}
