package com.threadPractice.basic.火车票练习.p1;

public class Ticket extends Thread {

    int ticketNum = 10;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (ticketNum > 0) {
                System.out.println("第" + ticketNum + "张票");
                ticketNum--;
            } else {
                System.out.println("抱歉，没有票了");
            }
        }
    }
}
