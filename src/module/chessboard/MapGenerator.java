package module.chessboard;

import static bean.Save.game;

/**
 * <strong><big>地图生成器  Map Generator</big></strong>
 *
 * <p>用于生成随机、非密集游戏地图，并写入游戏数据game.mapMatrix。</p>
 *
 * <p>注：请在鼠标单击第一次后使用！</p>
 *
 * @author 分柿方橙
 * @version ver 2.0 (2021.7.17)
 * @since ver 1.1.8 (2021.7.16)
 */
public class MapGenerator {

    /**
     * 方法：生成地图
     *
     * <p>用于生成随机、非密集游戏地图。</p>
     *
     * <p>各记号含义：
     * <ul>
     *     <li>负数：-1表示地雷；-2表示虚拟雷</li>
     *     <li>非负数：最外圈表示空；内部表示周边雷数</li>
     * </ul>
     * </p>
     *
     * <p>注：请在鼠标单击第一次后使用！</p>
     *
     * @param xClicked 鼠标所单击的方块的X坐标
     * @param yClicked 鼠标所单击的方块的Y坐标
     * @return 生成好的游戏地图
     */
    public byte[][] generateMap (int xClicked, int yClicked){
        int mineSet = 0; //记录已经布了多少雷

        /* 使用随机数创建byte类型map，上下左右各留出1列余地 */
        byte[][] map = new byte[game.getBlockNumX() + 2][game.getBlockNumY() + 2];
        /* 最外周一圈赋值为-2，第二圈四角赋值5，其余赋值3 */
        setBoundaryMarks(map);

        /* 执行布雷操作 */
        do{
            /* 取1~x随机数、1~y随机数 */
            int ranX = (int)(1 + Math.random() * game.getBlockNumX());
            int ranY = (int)(1 + Math.random() * game.getBlockNumY());
            /* 若该位置先前没有雷、周边八格不都是雷、周边八格的周边雷数不为7，则布雷、对其周围八格重算雷数 */
            if (!(ranX == xClicked && ranY == yClicked) && map[ranX][ranY] != -1
                    && densityTest(map, ranX, ranY)){

                map[ranX][ranY] = -1; //布雷

                for (int i = ranX - 1; i <= ranX + 1; i++){
                    for (int j = ranY - 1; j <= ranY + 1; j++){
                        if (map[i][j] >= 0){
                            map[i][j]++;
                        }
                    }
                } //对其周边八格计算布雷数

                mineSet++;
            }
        } while (mineSet <= game.getMineNum() - 1);

        /* 去除边界标记 */
        removeBoundaryMarks(map);

        /* 写入游戏数据 */
        return map;
    }

    /**
     * <p>方法：密度测试</p>
     *
     * <p>如果该位点满足周边8格至少有1个大于0、周边雷的周边雷数不为7，返回true，否则返回false</p>
     *
     * @param map 地图
     * @param ranX 该位点X坐标
     * @param ranY 该位点Y坐标
     * @return true：可以在这里放雷；false：不可以在这里放雷
     */
    private boolean densityTest(byte[][] map, int ranX, int ranY){
        boolean testValue;

        /* 要求1：周边8格至少有1个大于0 */
        if(map[ranX - 1][ranY - 1] < 0 && map[ranX - 1][ranY + 1] < 0 &&
                map[ranX + 1][ranY - 1] < 0 && map[ranX + 1][ranY + 1] < 0 &&
                map[ranX - 1][ranY] < 0 && map[ranX + 1][ranY] < 0 &&
                map[ranX][ranY - 1] < 0 && map[ranX][ranY + 1] < 0){
            return false;
        }

        /* 要求2：周边雷的周边雷数不为7 */
        for (int i = ranX - 1; i <= ranX + 1; i++){
            for (int j = ranY - 1; j <= ranY + 1; j++){
                if (map[i][j] == -1){
                    byte count = 0;
                    if (map[i-1][j-1] < 0){ count++; }
                    if (map[i+1][j-1] < 0){ count++; }
                    if (map[i+1][j+1] < 0){ count++; }
                    if (map[i-1][j+1] < 0){ count++; }
                    if (map[i][j-1] < 0){ count++; }
                    if (map[i][j+1] < 0){ count++; }
                    if (map[i-1][j] < 0){ count++; }
                    if (map[i+1][j] < 0){ count++; }
                    if (count == 7){
                        return false;
                    }
                }
            }
        }
        return true;

    }

    /**
     * <p>设置边界标记</p>
     *
     * <p>注：Save.game.map和定义在本类中的map比实际展示的游戏地图周围大一圈，以防判断周边雷相关方法发生数组
     * 越界，带来诸多麻烦。</p>
     *
     * <p>此方法将map的最外圈赋值为-2，第二圈除四角外赋值3，第二圈四角赋值5。</p>
     *
     * <p>可使用removeBoundaryMarks将该标记去除</p>
     *
     * @param map 地图
     */
    private void setBoundaryMarks(byte[][] map) {
        /* 最外圈赋值-2 */
        for (int i = 0; i < game.getBlockNumX() + 1; i++){
            map[i][0] = -2;
            map[i][game.getBlockNumY() + 1] = -2;
        }
        for (int i = 0; i < game.getBlockNumY() + 1; i++){
            map[0][i] = -2;
            map[game.getBlockNumX() + 1][i] = -2;
        }

        /* 次外圈非四角赋值3 */
        for (int i = 2; i < game.getBlockNumX() - 1; i++){
            map[i][1] = 3;
            map[i][game.getBlockNumY()] = 3;
        }
        for (int i = 2; i < game.getBlockNumY() - 1; i++){
            map[1][i] = 3;
            map[game.getBlockNumX()][i] = 3;
        }

        /* 次外圈四角赋值5 */
        map[1][1] = 5;
        map[1][game.getBlockNumY()] = 5;
        map[game.getBlockNumX()][1] = 5;
        map[game.getBlockNumX()][game.getBlockNumY()] = 5;

    }

    /**
     * <p>去除边界标记</p>
     *
     * <p>注：Save.game.map和定义在本类中的map比实际展示的游戏地图周围大一圈，以防判断周边雷相关方法发生数组
     * 越界，带来诸多麻烦。</p>
     *
     * <p>此方法将removeBoundaryMarks设置的标记回退。</p>
     *
     * @param map 地图
     */
    private void removeBoundaryMarks(byte[][] map) {
        /* 最外圈赋值0 */
        for (int i = 0; i <= game.getBlockNumX() + 1; i++){
            map[i][0] = 0;
            map[i][game.getBlockNumY() + 1] = 0;
        }
        for (int i = 0; i <= game.getBlockNumY() + 1; i++){
            map[0][i] = 0;
            map[game.getBlockNumX() + 1][i] = 0;
        }

        /* 次外圈非四角减3 */
        for (int i = 2; i < game.getBlockNumX() - 1; i++){
            if (map[i][1] > 0){ map[i][1] -= 3; }
            if (map[i][game.getBlockNumY()] > 0){ map[i][game.getBlockNumY()] -= 3; }
        }
        for (int i = 2; i < game.getBlockNumY() - 1; i++){
            if (map[1][i] > 0){ map[1][i] -= 3; }
            if (map[game.getBlockNumX()][i] > 0){ map[game.getBlockNumX()][i] -= 3; }
        }

        /* 次外圈四角减5 */
        if (map[1][1] > 0){ map[1][1] -= 5; }
        if (map[1][game.getBlockNumY()] > 0){ map[1][game.getBlockNumY()] -= 5; }
        if (map[game.getBlockNumX()][1] > 0) { map[game.getBlockNumX()][1] -= 5; }
        if (map[game.getBlockNumX()][game.getBlockNumY()] > 0) { map[game.getBlockNumX()][game.getBlockNumY()] -= 5; }

    }

}
