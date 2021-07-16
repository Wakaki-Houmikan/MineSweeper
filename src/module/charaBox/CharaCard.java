package module.charaBox;

import bean.Save;
import graphics.ICSetter;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * <strong><big>角色卡片  Character Card</big></strong>
 *
 * <p>展示在游戏运行界面的角色小卡片，展示角色状态头像、名字、剩余时间、剩余步数、得分、失误、生命值，状态头像表面配有一个全
 * 透明按钮，用于设置托管。</p>
 *
 * <p>以红队小卡片为例：</p>
 *
 * <p>首先需要创建并向根组里加入一个角色卡片：</p>
 * <code>
 *     Group redCardGroup = new Group();<br>
 *     CharaCard redCard = new RedCard(redCardGroup);<br>
 *     root.getChildren().addAll(redCard);<br>
 * </code>
 * </p>
 *
 * <p>卡片可以随时设置以下内容，举例如下：
 * <ul>
 *     <li>状态图像(Image)/生命值贴图(Image)：<br>
 *     <code>
 *         redCard.status.setImage(ICSetter.FishRed);<br>
 *         redCard.life4.setImage(null);
 *     </code>
 *     </li>
 *     <li>剩余时间(Text)、剩余步数(Text)、得分(Text)、失误(Text)：<br>
 *     <code>
 *         redCard.timeLeft.setText("222");
 *     </code>
 *     </li>
 * </ul>
 *
 * @author 分柿方橙
 * @version ver 1.1 (2021.7.16)
 * @since ver 1.1.7 (2021.7.15)
 */
public class CharaCard{

    Text timeLefLab = new Text("余时：");
    Text stepLefLab = new Text("余步：");
    Text scoreLab = new Text("得分：");
    Text missLab = new Text("失误：");
    Text lifeLab = new Text("生命值：");

    public ImageView status = new ImageView();

    public ImageView life1 = new ImageView(ICSetter.Life);
    public ImageView life2 = new ImageView(ICSetter.Life);
    public ImageView life3 = new ImageView(ICSetter.Life);
    public ImageView life4 = new ImageView(ICSetter.Life);
    public ImageView life5 = new ImageView(ICSetter.Life);

    /** 角色名字 */
    public Text name = new Text();
    /** 剩余时间 */
    public Text timeLeft = new Text();
    /** 剩余步数 */
    public Text stepLeft = new Text();
    /** 得分 */
    public Text score = new Text();
    /** 失误 */
    public Text miss = new Text();

    /** 托管按键 */
    public Button robot = new Button();

    /**
     * <p>含参构造器：往给定控件组中加入角色卡片</p>
     *
     * <p>基本用法（以红队角色为例）：<br>
     * <code>
     *     Group redCardGroup = new Group();<br>
     *     RedCard redCard = new RedCard(redCardGroup);<br>
     *     root.getChildren().addAll(redCard);<br>
     * </code>
     * 能创建并向根组里加入一个红色角色卡片。
     * </p>
     *
     * <p>注：对该卡片进行后续使用前需确保已创建Save.game和Save.(fourCharacters)并赋值，否则可能报错。</p>
     *
     * @param charaCardGroup 控件组
     */
    public CharaCard(Group charaCardGroup){
        charaCardGroup.getChildren(); //避免IDEA报charaCard没用上
    }

    /**
     * 方法：通用卡片设置，只允许包内类使用
     *
     * @param charaCardGroup 角色卡片
     */
    void setCardCommon(Group charaCardGroup){
        /* 角色状态 */
        status.setX(50); status.setY(15);
        /* 姓名框 */
        Rectangle nameRec = new Rectangle(30,115,120,25);
        nameRec.setFill(Color.color(1,1,1,0.5));
        name.setLayoutX(50); name.setLayoutY(133);
        /* 剩余时间 */
        timeLefLab.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        timeLefLab.setLayoutX(170); timeLefLab.setLayoutY(70);
        timeLeft.setLayoutX(215); timeLeft.setLayoutY(70);
        /* 剩余步数 */
        stepLefLab.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        stepLefLab.setLayoutX(280); stepLefLab.setLayoutY(70);
        stepLeft.setLayoutX(325); stepLeft.setLayoutY(70);
        /* 得分 */
        scoreLab.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        scoreLab.setLayoutX(170); scoreLab.setLayoutY(110);
        score.setLayoutX(215); score.setLayoutY(110);
        /* 失误 */
        missLab.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        missLab.setLayoutX(280); missLab.setLayoutY(110);
        miss.setLayoutX(325); miss.setLayoutY(110);
        /* 托管 */
        robot.setLayoutX(50); robot.setLayoutY(15);
        robot.setPrefWidth(90); robot.setPrefHeight(90);
        robot.setBackground(null);

        charaCardGroup.getChildren().addAll(nameRec, timeLefLab, stepLefLab, scoreLab, missLab,
                name, timeLeft, stepLeft, score, miss, status, robot);

        /* 选择生命值模组 */
        if (Save.game.isModLife()) {
            timeLefLab.setLayoutY(50); stepLefLab.setLayoutY(50);
            scoreLab.setLayoutY(90); missLab.setLayoutY(90);
            timeLeft.setLayoutY(50); stepLeft.setLayoutY(50);
            score.setLayoutY(90); miss.setLayoutY(90);
            /* 生命值 */
            lifeLab.setFont(Font.font("Arial", FontWeight.BOLD, 16));
            lifeLab.setLayoutX(170); lifeLab.setLayoutY(130);
            life1.setX(230); life1.setY(110);
            life2.setX(260); life2.setY(110);
            life3.setX(290); life3.setY(110);
            life4.setX(320); life4.setY(110);
            life5.setX(350); life5.setY(110);
            charaCardGroup.getChildren().addAll(lifeLab, life1, life2, life3, life4, life5);
        }

    }
}