package module.menubar;

import javafx.event.ActionEvent;
import javafx.scene.control.Menu;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.ToggleGroup;
import module.animation.Climate;
import module.animation.Smog;

public class MenuGraphic {
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
