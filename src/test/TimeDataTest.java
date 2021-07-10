package test;

import bean.Timer;

public class TimeDataTest {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.run();
        timer.run();
        System.out.println(timer.getValue());
    }
}
