package bean;

import java.io.Serializable;

/**
 * <strong><big>计时器数据  Time Data</big></strong>
 *
 * <p>搭配时间线动画TimelimeGame和TimelineChara，利用自带变量value记录游戏内时间的变化。由于这些动画被设置成每0.1秒刷新一次，现实中每过1秒，
 * value值会增加10，使用时需注意数据转换。</p>
 *
 * @author 分柿方橙
 * @version ver 1.1 (2021.7.12)
 * @since ver 1.1.0 (2021.7.5)
 */
public class Timer implements Serializable {
    /**
     * 时间值
     */
    private int value;

    /**
     * 不含参建造器：创建一个当前时间值为0的计时器。
     */
    public Timer(){ value = 0; }

    /**
     * 含参建造器：创建一个当前时间值为给定数值的计时器。
     *
     * @param value 给定时间值
     */
    public Timer(int value){ this.value = value; }

    /**
     * 增加：每调用一次该方法，时间值增加1。
     */
    public void run() { value++; }

    /**
     * 清零：将时间值强制更改为初始值0。
     */
    public void clear() { value = 0; }

    /**
     * 获取值：获取计时器的时间值。
     */
    public int getValue() { return value; }

    /**
     * 设置值：获取计时器的时间值。
     */
    public void setValue(int value) { this.value = value; }

    /**
     * 时间值转换为字符串：
     *
     * @return 时间值的字符串
     */
    public String ValueToString() { return String.valueOf(value); }

    /**
     * 时间值转换为时分制时间：
     *
     * @return 时分制时间
     */
    public String ValuetoTime(byte mode){
        int hour; int minu;
        String h; String m;

        if (mode == 1){ return "09:00";
        } else if (mode == 2){ return "21:00";
        } else {
            if (( value / 10 ) % 480 < 300){ hour = (( value / 10 ) / 20 + 9) % 24;
            } else { hour = (( value / 10 ) / 20 + 9 - 24) % 24;
            }
            if (hour < 10){ h = "0" + hour;
            } else { h = String.valueOf(hour);
            }
            minu = ( value / 10 ) % 20;
            if (minu < 5){ m = "00";
            } else if (minu < 10) { m = "15";
            } else if (minu < 15) { m = "30";
            } else { m = "45";
            }
            return h + ":" + m;
        }
    }


}
