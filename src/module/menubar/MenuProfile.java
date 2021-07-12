package module.menubar;

import javafx.event.ActionEvent;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;

public class MenuProfile {
    public MenuProfile(Menu menuProfile){
        /* 菜单栏 -> 档案 */
        MenuItem itemSave = new MenuItem("存储档案");
        itemSave.setOnAction(this::pressItemSave);

        MenuItem itemLoad = new MenuItem("读取档案");
        itemLoad.setOnAction(this::pressItemLoad);

        SeparatorMenuItem separP = new SeparatorMenuItem();

        MenuItem itemRead = new MenuItem("查看档案");

        menuProfile.getItems().addAll(itemSave, itemLoad, separP, itemRead);
    }

    private void pressItemSave(ActionEvent actionEvent) {

    }

    private void pressItemLoad(ActionEvent actionEvent) {

    }
}
