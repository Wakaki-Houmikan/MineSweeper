package module.menubar;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class MenuGame {
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
