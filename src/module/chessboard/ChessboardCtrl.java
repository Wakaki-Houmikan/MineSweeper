package module.chessboard;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

import static bean.Save.game;

public class ChessboardCtrl {

    static ImageView[][] base;
    static ImageView[][] situation;
    static Button[][] block;

    public void initializeChessboard(){
        switch (game.getTimeAttri()) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
        }
    }

    public void layoutChessboard(){

    }
}
