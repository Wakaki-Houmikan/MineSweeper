package resources.graphics;


import javafx.scene.image.ImageView;

/**
 * <strong>背景设置器  Background Setter</strong>
 *
 * <p>内置src/resources/graphics/BG下用ImageView打包的大型图片，用于设置页面的背景图片。每张图只能使用一次。</p>
 *
 * @author 分柿方橙
 * @version ver 0.2 (2021.7.15)
 * @since ver 1.1.0 (2021.7.5)
 */
public class BGSetter {

    /* 15 background images */
    public static final ImageView Plain1 = new ImageView("/resources/graphics/BG/Plain1.png");
    public static final ImageView Plain2 = new ImageView("/resources/graphics/BG/Plain2.png");
    public static final ImageView Plain3 = new ImageView("/resources/graphics/BG/Plain3.png");
    public static final ImageView Plain4 = new ImageView("/resources/graphics/BG/Plain4.png");

    public static final ImageView Badld1 = new ImageView("/resources/graphics/BG/Badld1.png");
    public static final ImageView Badld2 = new ImageView("/resources/graphics/BG/Badld2.png");
    public static final ImageView Badld3 = new ImageView("/resources/graphics/BG/Badld3.png");
    public static final ImageView Badld4 = new ImageView("/resources/graphics/BG/Badld4.png");

    public static final ImageView Mount1 = new ImageView("/resources/graphics/BG/Mount1.png");
    public static final ImageView Mount2 = new ImageView("/resources/graphics/BG/Mount2.png");
    public static final ImageView Mount3 = new ImageView("/resources/graphics/BG/Mount3.png");
    public static final ImageView Mount4 = new ImageView("/resources/graphics/BG/Mount4.png");

    public static final ImageView Main = new ImageView("/resources/graphics/BG/bgMain.png");
    public static final ImageView Help = new ImageView("/resources/graphics/BG/bgHelp.png");
    public static final ImageView Develop = new ImageView("/resources/graphics/BG/bgUpdate.png");
}
