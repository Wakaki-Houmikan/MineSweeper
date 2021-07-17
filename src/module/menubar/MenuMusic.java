package module.menubar;

import javafx.event.ActionEvent;
import javafx.scene.control.Menu;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.ToggleGroup;
import resources.musics.BGMPlayer;

/**
 * <strong>音乐菜单  Music Menu</strong>
 *
 * <p>可添加至菜单栏的音乐相关控件组，包含播放、停止、设置音量、设置曲目等16项内容。</p>
 *
 * @author 分柿方橙
 * @version ver 1.0 (2021.7.11)
 * @since ver 1.1.5 (2021.7.11)
 */
public class MenuMusic {

    /**
     * 建造器：为提供的菜单栏加上音乐相关控件
     *
     * @param menuMusic 菜单组
     */
    public MenuMusic(Menu menuMusic){
        /* 菜单栏 -> 音乐 */
        ToggleGroup itemOnOff = new ToggleGroup();
        RadioMenuItem itemMusicOn = new RadioMenuItem("播放");
        itemMusicOn.setToggleGroup(itemOnOff);
        itemMusicOn.setOnAction(this::pressItemOn);
        RadioMenuItem itemMusicOff = new RadioMenuItem("停止");
        itemMusicOff.setToggleGroup(itemOnOff);
        itemMusicOff.setOnAction(this::pressItemOff);
        itemMusicOn.setSelected(true);

        SeparatorMenuItem separM = new SeparatorMenuItem();

        ToggleGroup itemVolume = new ToggleGroup();
        RadioMenuItem itemVolume10 = new RadioMenuItem("音量 20%");
        RadioMenuItem itemVolume20 = new RadioMenuItem("音量 40%");
        RadioMenuItem itemVolume30 = new RadioMenuItem("音量 60%");
        RadioMenuItem itemVolume40 = new RadioMenuItem("音量 80%");
        RadioMenuItem itemVolume50 = new RadioMenuItem("音量 100%");
        itemVolume10.setToggleGroup(itemVolume);
        itemVolume20.setToggleGroup(itemVolume);
        itemVolume30.setToggleGroup(itemVolume);
        itemVolume40.setToggleGroup(itemVolume);
        itemVolume50.setToggleGroup(itemVolume);
        itemVolume10.setOnAction(this::pressItemVolume10);
        itemVolume20.setOnAction(this::pressItemVolume20);
        itemVolume30.setOnAction(this::pressItemVolume30);
        itemVolume40.setOnAction(this::pressItemVolume40);
        itemVolume50.setOnAction(this::pressItemVolume50);
        itemVolume30.setSelected(true);

        SeparatorMenuItem separV = new SeparatorMenuItem();

        ToggleGroup itemMusics = new ToggleGroup();
        RadioMenuItem itemMusic1 = new RadioMenuItem("Memories of the Great Tree");
        RadioMenuItem itemMusic2 = new RadioMenuItem("One Star by the Next");
        RadioMenuItem itemMusic3 = new RadioMenuItem("Pitch Black");
        RadioMenuItem itemMusic4 = new RadioMenuItem("Song of the Hoarfrost");
        RadioMenuItem itemMusic5 = new RadioMenuItem("Flowers Blooming in the Empty Sky");
        RadioMenuItem itemMusic6 = new RadioMenuItem("Verethraghna");
        RadioMenuItem itemMusic7 = new RadioMenuItem("Blazing Earth");
        RadioMenuItem itemMusic8 = new RadioMenuItem("Exciting Cave Exploration");
        RadioMenuItem itemMusic9 = new RadioMenuItem("Crimson Omen");
        itemMusic1.setToggleGroup(itemMusics);
        itemMusic2.setToggleGroup(itemMusics);
        itemMusic3.setToggleGroup(itemMusics);
        itemMusic4.setToggleGroup(itemMusics);
        itemMusic5.setToggleGroup(itemMusics);
        itemMusic6.setToggleGroup(itemMusics);
        itemMusic7.setToggleGroup(itemMusics);
        itemMusic8.setToggleGroup(itemMusics);
        itemMusic9.setToggleGroup(itemMusics);
        itemMusic1.setOnAction(this::pressItemMusic1);
        itemMusic2.setOnAction(this::pressItemMusic2);
        itemMusic3.setOnAction(this::pressItemMusic3);
        itemMusic4.setOnAction(this::pressItemMusic4);
        itemMusic5.setOnAction(this::pressItemMusic5);
        itemMusic6.setOnAction(this::pressItemMusic6);
        itemMusic7.setOnAction(this::pressItemMusic7);
        itemMusic8.setOnAction(this::pressItemMusic8);
        itemMusic9.setOnAction(this::pressItemMusic9);

        menuMusic.getItems().addAll(itemMusicOn, itemMusicOff,
                separM, itemVolume10, itemVolume20, itemVolume30, itemVolume40, itemVolume50,
                separV, itemMusic1, itemMusic2, itemMusic3, itemMusic4, itemMusic5, itemMusic6, itemMusic7, itemMusic8, itemMusic9);
    }

    /**
     * 音乐开启
     *
     * @param actionEvent 鼠标点击该选项，下同
     */
    private void pressItemOn(ActionEvent actionEvent) {
        BGMPlayer.musicStart(BGMPlayer.recentMusicIndex);
    }

    /**
     * 音乐关闭
     */
    private void pressItemOff(ActionEvent actionEvent) {
        BGMPlayer.musicStop();
    }

    /**
     * 设置音量20%（实际为4%）
     */
    private void pressItemVolume10(ActionEvent actionEvent) {
        BGMPlayer.setVolume(0.04);
    }

    /**
     * 设置音量40%（实际为8%）
     */
    private void pressItemVolume20(ActionEvent actionEvent) {
        BGMPlayer.setVolume(0.08);
    }

    /**
     * 设置音量60%（实际为12%）
     */
    private void pressItemVolume30(ActionEvent actionEvent) {
        BGMPlayer.setVolume(0.12);
    }

    /**
     * 设置音量80%（实际为16%）
     */
    private void pressItemVolume40(ActionEvent actionEvent) {
        BGMPlayer.setVolume(0.16);
    }

    /**
     * 设置音量100%（实际为20%）
     */
    private void pressItemVolume50(ActionEvent actionEvent) {
        BGMPlayer.setVolume(0.20);
    }

    /**
     * 播放第1首音乐
     */
    private void pressItemMusic1(ActionEvent actionEvent) {
        BGMPlayer.musicStart(1);
    }

    /**
     * 播放第2首音乐
     */
    private void pressItemMusic2(ActionEvent actionEvent) {
        BGMPlayer.musicStart(2);
    }

    /**
     * 播放第3首音乐
     */
    private void pressItemMusic3(ActionEvent actionEvent) {
        BGMPlayer.musicStart(3);
    }

    /**
     * 播放第4首音乐
     */
    private void pressItemMusic4(ActionEvent actionEvent) {
        BGMPlayer.musicStart(4);
    }

    /**
     * 播放第5首音乐
     */
    private void pressItemMusic5(ActionEvent actionEvent) {
        BGMPlayer.musicStart(5);
    }

    /**
     * 播放第6首音乐
     */
    private void pressItemMusic6(ActionEvent actionEvent) {
        BGMPlayer.musicStart(6);
    }

    /**
     * 播放第7首音乐
     */
    private void pressItemMusic7(ActionEvent actionEvent) {
        BGMPlayer.musicStart(7);
    }

    /**
     * 播放第8首音乐
     */
    private void pressItemMusic8(ActionEvent actionEvent) {
        BGMPlayer.musicStart(8);
    }

    /**
     * 播放第9首音乐
     */
    private void pressItemMusic9(ActionEvent actionEvent) {
        BGMPlayer.musicStart(9);
    }

}
