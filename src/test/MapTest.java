package test;

import bean.Game;
import bean.Save;
import module.chessboard.MapGenerator;

public class MapTest {
    public static void main(String[] args) {

        Save.game = new Game(30,30,750,(byte)2,(byte)2,(byte)2,
                true,true,false,false,
                true,1,1,true,true,true,
                1,1,new byte[1][2],new String[2][3],false);

        byte[][] map = new MapGenerator().generateMap(3,5);

        for (int i = 0; i < 32; i++){
            for (int j = 0; j < 32; j++){
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
