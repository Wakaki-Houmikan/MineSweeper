package Musics;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

/**
 * <big>背景音乐播放器工具  BGM Player</big>
 *
 * <p>可读取 src/Musics/BGM 里的音乐，进行音乐播放相关操作。</p>
 *
 * @author 分柿方橙
 * @version ver.0.1 (2021.7.5)
 * @since projVer.0.1 (2021.7.5)
 */
public class BGMPlayer {

    /**
     * File[]类型音乐列表：
     *    0   占位未使用
     *    1   平原 白天   巨树的记忆
     *    2   平原 夜晚   在一颗星的旁边
     *    3   平原 最终   漆黑
     *    4   雪山 白天   冰霜之诗
     *    5   雪山 夜晚   虚空中盛开的花
     *    6   雪山 最终   乌鲁斯拉格纳
     *    7   恶地 白天   炽热的大地
     *    8   恶地 夜晚   心惊胆战洞穴探险
     *    9   恶地 最终   绯红色的征兆
     */
    public static final File[] MUSIC_LIST = { null,                                         // 0, 占位
            new File(String.valueOf(BGMPlayer.class.getResourceAsStream(
                    "src/Musics/Memories of the Great Tree.mp3"))),                   // 1
            new File(String.valueOf(BGMPlayer.class.getResourceAsStream(
                    "src/Musics/One Star by the Next.mp3"))),                         // 2
            new File(String.valueOf(BGMPlayer.class.getResourceAsStream(
                    "src/Musics/Pitch Black.mp3"))),                                  // 3
            new File(String.valueOf(BGMPlayer.class.getResourceAsStream(
                    "src/Musics/Song of the Hoarfrost.mp3"))),                        // 4
            new File(String.valueOf(BGMPlayer.class.getResourceAsStream(
                    "src/Musics/Flowers Blooming in the Empty Sky.mp3"))),            // 5
            new File(String.valueOf(BGMPlayer.class.getResourceAsStream(
                    "src/Musics/Verethraghna.mp3"))),                                 // 6
            new File(String.valueOf(BGMPlayer.class.getResourceAsStream(
                    "src/Musics/Blazing Earth.mp3"))),                                // 7
            new File(String.valueOf(BGMPlayer.class.getResourceAsStream(
                    "src/Musics/Exciting Cave Exploration.mp3"))),                    // 8
            new File(String.valueOf(BGMPlayer.class.getResourceAsStream(
                    "src/Musics/Crimson Omen.mp3")))};                                // 9

    /**
     * MediaPlayer[]类型音乐播放列表：
     *    0   占位未使用
     *    1   平原 白天   巨树的记忆
     *    2   平原 夜晚   在一颗星的旁边
     *    3   平原 最终   漆黑
     *    4   雪山 白天   冰霜之诗
     *    5   雪山 夜晚   虚空中盛开的花
     *    6   雪山 最终   乌鲁斯拉格纳
     *    7   恶地 白天   炽热的大地
     *    8   恶地 夜晚   心惊胆战洞穴探险
     *    9   恶地 最终   绯红色的征兆
     */
    public static final MediaPlayer[] MEDIA_PLAYER = { null,
            new MediaPlayer(new Media(MUSIC_LIST[1].toURI().toString())),
            new MediaPlayer(new Media(MUSIC_LIST[2].toURI().toString())),
            new MediaPlayer(new Media(MUSIC_LIST[3].toURI().toString())),
            new MediaPlayer(new Media(MUSIC_LIST[4].toURI().toString())),
            new MediaPlayer(new Media(MUSIC_LIST[5].toURI().toString())),
            new MediaPlayer(new Media(MUSIC_LIST[6].toURI().toString())),
            new MediaPlayer(new Media(MUSIC_LIST[7].toURI().toString())),
            new MediaPlayer(new Media(MUSIC_LIST[8].toURI().toString())),
            new MediaPlayer(new Media(MUSIC_LIST[9].toURI().toString())),
    };

    /**
     *  最近一次播放的音乐的序号：
     *    0   占位未使用
     *    1   平原 白天   巨树的记忆
     *    2   平原 夜晚   在一颗星的旁边
     *    3   平原 最终   漆黑
     *    4   雪山 白天   冰霜之诗
     *    5   雪山 夜晚   虚空中盛开的花
     *    6   雪山 最终   乌鲁斯拉格纳
     *    7   恶地 白天   炽热的大地
     *    8   恶地 夜晚   心惊胆战洞穴探险
     *    9   恶地 最终   绯红色的征兆
     */
    public byte recentMusicIndex;

    /**
     * 暂停音乐：暂停正在播放的所有音乐。
     */
    public void musicOff(){
        for (byte i = 1; i <= 9; i++){
            MEDIA_PLAYER[i].pause();
        }
    }

    /**
     * 切换音乐：以当前音量无限循环播放指定音乐，并暂停其他所有音乐。
     *
     * @param order 设置音乐序号
     * @param volume 设置音量
     */
    public void musicCut(byte order, double volume){
        musicOff();
        recentMusicIndex = order;
        MEDIA_PLAYER[order].play();
        MEDIA_PLAYER[order].setCycleCount(999);
        MEDIA_PLAYER[order].setVolume(volume);
    }

    /**
     * 调节音量：将音量设置为给定百分值。
     *
     * @param volume 设置音量
     */
    public void musicVolume(double volume){
        for (byte i = 1; i <= 9; i++){
            MEDIA_PLAYER[i].setVolume(volume);
        }
    }
}