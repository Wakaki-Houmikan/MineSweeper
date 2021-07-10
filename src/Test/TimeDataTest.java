package Test;

import Bean.TimeData;

public class TimeDataTest {
    public static void main(String[] args) {
        TimeData timeData = new TimeData();
        timeData.run();
        timeData.run();
        System.out.println(timeData.getValue());
    }
}
