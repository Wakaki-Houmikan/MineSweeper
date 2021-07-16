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
 * @version ver 1.1 (2021.7.16)
 * @since ver 1.1.8 (2021.7.16)
 */
class MapGenerator {

    /**
     * 方法：生成地图
     *
     * <p>用于生成随机、非密集游戏地图，并写入游戏数据game.mapMatrix。</p>
     *
     * <p>注：请在鼠标单击第一次后使用！</p>
     *
     * @param xClicked 鼠标所单击的方块的X坐标
     * @param yClicked 鼠标所单击的方块的Y坐标
     */
    void generateMap (int xClicked, int yClicked){
        int mineSet = 0; //记录已经布了多少雷

        /* 使用随机数创建byte类型map */
        byte[][] map = new byte[game.getBlockNumX() + 2][game.getBlockNumY() + 2];
        do{
            int mineSetX = (int)(1 + Math.random() * game.getBlockNumX()); //取1~x随机数
            int mineSetY = (int)(1 + Math.random() * game.getBlockNumY()); //取1~y随机数
            if ((mineSetX != xClicked && mineSetY != yClicked && map[mineSetX][mineSetY] != -1) &&
                    !(map[mineSetX+1][mineSetY] == -1 && map[mineSetX-1][mineSetY] == -1 &&
                            map[mineSetX][mineSetY+1] == -1 && map[mineSetX][mineSetY-1] == -1 &&
                            map[mineSetX+1][mineSetY+1] == -1 && map[mineSetX+1][mineSetY-1] == -1 &&
                            map[mineSetX-1][mineSetY-1] == -1 && map[mineSetX-1][mineSetY+1] == -1)){
                map[mineSetX][mineSetY] = -1; // 若该位置先前没有雷、周边八格不都是雷，则布雷
                mineSet++;
            }
        } while (mineSet <= game.getMineNum() - 1);

        /* 根据地图计算周边雷数 */
        for (int x = 1; x <= game.getBlockNumX(); x++) {
            for (int y = 1; y <= game.getBlockNumX(); y++) {
                byte mineSide = 0; // 周边雷数
                /* 如果一个区块不是雷，计算周边雷数 */
                if (map[x][y] != -1){
                    if (map[x-1][y-1] == -1){ mineSide++; }
                    if (map[x-1][y] == -1){ mineSide++; }
                    if (map[x-1][y+1] == -1){ mineSide++; }
                    if (map[x][y-1] == -1){ mineSide++; }
                    if (map[x][y+1] == -1){ mineSide++; }
                    if (map[x+1][y-1] == -1){ mineSide++; }
                    if (map[x+1][y] == -1){ mineSide++; }
                    if (map[x+1][y+1] == -1){ mineSide++; }
                    map[x][y] = mineSide;
                }
            }
        }

        /* 写入游戏数据 */
        game.setMapMatrix(map);
    }

}
