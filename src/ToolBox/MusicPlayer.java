package ToolBox;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class MusicPlayer {

    /* 音乐序列 */
    private final File[] musicFiles = { null,                                               // 0, 占位
            new File(String.valueOf(MusicPlayer.class.getResourceAsStream(
                    "src/Musics/Memories of the Great Tree.mp3"))),                   // 1
            new File(String.valueOf(MusicPlayer.class.getResourceAsStream(
                    "src/Musics/One Star by the Next.mp3"))),                         // 2
            new File(String.valueOf(MusicPlayer.class.getResourceAsStream(
                    "src/Musics/Pitch Black.mp3"))),                                  // 3
            new File(String.valueOf(MusicPlayer.class.getResourceAsStream(
                    "src/Musics/Song of the Hoarfrost.mp3"))),                        // 4
            new File(String.valueOf(MusicPlayer.class.getResourceAsStream(
                    "src/Musics/Flowers Blooming in the Empty Sky.mp3"))),            // 5
            new File(String.valueOf(MusicPlayer.class.getResourceAsStream(
                    "src/Musics/Verethraghna.mp3"))),                                 // 6
            new File(String.valueOf(MusicPlayer.class.getResourceAsStream(
                    "src/Musics/Blazing Earth.mp3"))),                                // 7
            new File(String.valueOf(MusicPlayer.class.getResourceAsStream(
                    "src/Musics/Exciting Cave Exploration.mp3"))),                    // 8
            new File(String.valueOf(MusicPlayer.class.getResourceAsStream(
                    "src/Musics/Crimson Omen.mp3")))};                                // 9

    /* 初始化 */
    Media[] musicList = { null,
        new Media(musicFiles[1].toURI().toString()),
        new Media(musicFiles[2].toURI().toString()),
        new Media(musicFiles[3].toURI().toString()),
        new Media(musicFiles[4].toURI().toString()),
        new Media(musicFiles[5].toURI().toString()),
        new Media(musicFiles[6].toURI().toString()),
        new Media(musicFiles[7].toURI().toString()),
        new Media(musicFiles[8].toURI().toString()),
        new Media(musicFiles[9].toURI().toString()),
    };
    MediaPlayer[] mediaPlayer = { null,
            new MediaPlayer(musicList[1]),
            new MediaPlayer(musicList[2]),
            new MediaPlayer(musicList[3]),
            new MediaPlayer(musicList[4]),
            new MediaPlayer(musicList[5]),
            new MediaPlayer(musicList[6]),
            new MediaPlayer(musicList[7]),
            new MediaPlayer(musicList[8]),
            new MediaPlayer(musicList[9]),
    };

    /* 序列号：最近一次播放的曲子 */
    byte latest;

    /* 音乐关闭 */
    public void musicOff(){
        for (byte i = 1; i <= 9; i++){
            mediaPlayer[i].pause();
        }
    }

    /* 音乐切换 */
    public void musicToggle(byte order, double volume){
        musicOff();
        latest = order;
        mediaPlayer[order].play();
        mediaPlayer[order].setCycleCount(999);
        mediaPlayer[order].setVolume(volume);
    }

    /* 音量调节 */
    public void musicVolume(double volume){
        for (byte i = 1; i <= 9; i++){
            mediaPlayer[i].setVolume(volume);
        }
    }
}
