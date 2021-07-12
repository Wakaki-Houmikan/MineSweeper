package module.menubar;

import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.control.*;
import musics.BGMPlayer;

public class MenuBarInGame {

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

        bar.getMenus().addAll(menuGame, menuProfile, menuMusic, menuGraphic, menuHelp);
        bar.setPrefWidth(2000);
        menuBar.getChildren().add(bar);





        /* 菜单栏 -> 帮助 */
        MenuItem itemHelpDoc = new MenuItem("关于扫雷");
        MenuItem itemDevDoc = new MenuItem("更新日志");
        menuHelp.getItems().addAll(itemHelpDoc, itemDevDoc);
    }







}
