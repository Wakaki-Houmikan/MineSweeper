package module.menubar;

import javafx.event.ActionEvent;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;

/**
 * <strong><big>档案菜单  Profile Menu</big></strong>
 *
 * <p>可添加至菜单栏的档案相关控件组，包含存储档案、读取档案、查看档案三项内容。</p>
 *
 * @author 分柿方橙
 * @version ver 1.0 (2021.7.11)
 * @since ver 1.1.5 (2021.7.11)
 */
public class MenuProfile {

    /**
     * 建造器：为提供的菜单栏加上档案相关控件
     *
     * @param menuProfile 菜单组
     */
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
