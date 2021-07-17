package module.menubar;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

/**
 * <strong>帮助菜单  Graphic Help</strong>
 *
 * <p>可添加至菜单栏的帮助相关控件组，包含关于扫雷、更新日志两项内容。</p>
 *
 * @author 分柿方橙
 * @version ver 1.0 (2021.7.13)
 * @since ver 1.1.6 (2021.7.13)
 */
public class MenuHelp {

    /**
     * 建造器：为提供的菜单栏加上帮助相关控件
     *
     * @param menuHelp 菜单组
     */
    public MenuHelp(Menu menuHelp){
        /* 菜单栏 -> 帮助 */
        MenuItem itemHelpDoc = new MenuItem("关于扫雷");
        MenuItem itemDevDoc = new MenuItem("更新日志");
        menuHelp.getItems().addAll(itemHelpDoc, itemDevDoc);
    }
}
