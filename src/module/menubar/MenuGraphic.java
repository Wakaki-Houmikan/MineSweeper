package module.menubar;

import javafx.event.ActionEvent;
import javafx.scene.control.Menu;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.ToggleGroup;
import module.animation.Climate;

/**
 * <strong><big>图像菜单  Graphic Menu</big></strong>
 *
 * <p>可添加至菜单栏的图像相关控件组，包含图片背景、单色背景、动画开、动画关四项内容。</p>
 *
 * @author 分柿方橙
 * @version ver 1.0 (2021.7.11)
 * @since ver 1.1.5 (2021.7.11)
 */
public class MenuGraphic {

    /**
     * 建造器：为提供的菜单栏加上图像相关控件
     *
     * @param menuGraphic 菜单组
     */
    public MenuGraphic(Menu menuGraphic){
        /* 菜单栏 -> 图像 */
        ToggleGroup itemBG = new ToggleGroup();
        RadioMenuItem itemBGOn = new RadioMenuItem("图片背景");
        itemBGOn.setToggleGroup(itemBG);
        RadioMenuItem itemBGOff = new RadioMenuItem("单色背景");
        itemBGOff.setToggleGroup(itemBG);
        itemBGOn.setSelected(true);

        SeparatorMenuItem separG = new SeparatorMenuItem();

        ToggleGroup itemAnimation = new ToggleGroup();
        RadioMenuItem itemAnimationOn = new RadioMenuItem("动画开");
        itemAnimationOn.setToggleGroup(itemAnimation);
        itemAnimationOn.setOnAction(this::pressItemAnimationOn);
        RadioMenuItem itemAnimationOff = new RadioMenuItem("动画关");
        itemAnimationOff.setToggleGroup(itemAnimation);
        itemAnimationOff.setOnAction(this::pressItemAnimationOff);
        itemAnimationOn.setSelected(true);

        menuGraphic.getItems().addAll(itemBGOn, itemBGOff, separG, itemAnimationOn, itemAnimationOff);
    }

    private void pressItemAnimationOn(ActionEvent actionEvent) {
    }


    private void pressItemAnimationOff(ActionEvent actionEvent) {
        Climate.climateStop();
    }
}
