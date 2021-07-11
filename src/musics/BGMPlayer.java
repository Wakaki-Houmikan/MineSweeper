package musics;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

/**
 * <big>背景音乐播放器工具  BGM Player</big>
 *
 * <p>可读取 src/Musics/BGM 里的音乐，进行音乐播放相关操作。</p>
 *
 * @author 分柿方橙
 * @version ver 1.3 (2021.7.11)
 * @since ver 1.1.0 (2021.7.5)
 */
public class BGMPlayer {

    /**
     * MediaPlayer[]类型音乐播放列表：
     * <p>   0   占位未使用 </p>
     * <p>   1   平原 白天   巨树的记忆 </p>
     * <p>   2   平原 夜晚   在一颗星的旁边 </p>
     * <p>   3   平原 最终   漆黑 </p>
     * <p>   4   雪山 白天   冰霜之诗 </p>
     * <p>   5   雪山 夜晚   虚空中盛开的花 </p>
     * <p>   6   雪山 最终   乌鲁斯拉格纳 </p>
     * <p>   7   恶地 白天   炽热的大地 </p>
     * <p>   8   恶地 夜晚   心惊胆战洞穴探险 </p>
     * <p>   9   恶地 最终   绯红色的征兆 </p>
     */
    static final MediaPlayer[] MEDIA_PLAYER = { null,
            new MediaPlayer(new Media(new File("src/musics/BGM/Memories of the Great Tree.mp3").toURI().toString())),
            new MediaPlayer(new Media(new File("src/musics/BGM/One Star by the Next.mp3").toURI().toString())),
            new MediaPlayer(new Media(new File("src/musics/BGM/Pitch Black.mp3").toURI().toString())),
            new MediaPlayer(new Media(new File("src/musics/BGM/Song of the Hoarfrost.mp3").toURI().toString())),
            new MediaPlayer(new Media(new File("src/musics/BGM/Flowers Blooming in the Empty Sky.mp3").toURI().toString())),
            new MediaPlayer(new Media(new File("src/musics/BGM/Verethraghna.mp3").toURI().toString())),
            new MediaPlayer(new Media(new File("src/musics/BGM/Blazing Earth.mp3").toURI().toString())),
            new MediaPlayer(new Media(new File("src/musics/BGM/Exciting Cave Exploration.mp3").toURI().toString())),
            new MediaPlayer(new Media(new File("src/musics/BGM/Crimson Omen.mp3").toURI().toString()))
    };

    /**
     *  最近一次播放的音乐的序号，音乐顺序同上。
     */
    public static int recentMusicIndex;

    /**
     * 切换音乐：以当前音量无限循环播放指定音乐，并暂停其他所有音乐。
     *
     * @param order 设置音乐序号
     */
    public static void musicStart(int order){
        musicStop();
        recentMusicIndex = order;
        MEDIA_PLAYER[order].play();
        MEDIA_PLAYER[order].setCycleCount(999);
    }

    /**
     * 暂停音乐：暂停正在播放的所有音乐。
     */
    public static void musicStop(){
        for (byte i = 1; i <= 9; i++){
            MEDIA_PLAYER[i].pause();
        }
    }



    /**
     * 调节音量：将音量设置为给定值。
     *
     * @param volume 设置音量
     */
    public static void setVolume(double volume){
        for (byte i = 1; i <= 9; i++){
            MEDIA_PLAYER[i].setVolume(volume);
        }
    }
}
