package module.menubar;

import javafx.scene.Group;
import javafx.scene.control.*;

/**
 * <strong>菜单栏  Menu Bar</strong>
 *
 * <p>游戏运行界面的菜单栏，包含游戏、档案、音乐、图像、帮助五组内容。</p>
 *
 * @author 分柿方橙
 * @version ver 1.1 (2021.7.13)
 * @since ver 1.1.4 (2021.7.10)
 */
public class MenuBarInGame {

    /**
     * 建造器：为界面加上菜单栏，需要提供一个Group
     *
     * @param menuBar 控件组
     */
    public MenuBarInGame(Group menuBar){

        /* 菜单栏 */
        MenuBar bar = new MenuBar();

        Menu menuGame = new Menu("游戏");
        new MenuGame(menuGame);

        Menu menuProfile = new Menu("档案");
        new MenuProfile(menuProfile);

        Menu menuMusic = new Menu("音乐");
        new MenuMusic(menuMusic);

        Menu menuGraphic = new Menu("图像");
        new MenuGraphic(menuGraphic);

        Menu menuHelp = new Menu("帮助");
        new MenuHelp(menuHelp);

        bar.getMenus().addAll(menuGame, menuProfile, menuMusic, menuGraphic, menuHelp);
        bar.setPrefWidth(2000);
        menuBar.getChildren().add(bar);

    }

}
