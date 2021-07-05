package ToolBox;

import java.io.Serializable;

public class Timer implements Serializable {
    public int value; //时间值

    /* 建造器·不含参 */
    public Timer(){ value = 0; }

    /* 建造器·含参 */
    public Timer(int value){ this.value = value; }

    /* 方法·开始 */
    public void start() { value++; }

    /* 方法·清零 */
    public void clear() { value = 0; }

    /* 方法·获取值 */
    public int getValue() { return value; }

    /* 方法·将时间值转换为String */
    public String toString() { return String.valueOf(value); }

    /* 方法·转换成时分制时间 */
    public String toTime(byte mode){
        int hour; int minu;
        String h; String m;

        if (mode == 1){ return "09:00";
        } else if (mode == 2){ return "21:00";
        } else {
            if (( value / 10 ) % 480 < 300){ hour = (( value / 10 ) / 20 + 9) % 24;
            } else { hour = (( value / 10 ) / 20 + 9 - 24) % 24;
            }
            if (hour < 10){ h = "0" + String.valueOf(hour);
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
