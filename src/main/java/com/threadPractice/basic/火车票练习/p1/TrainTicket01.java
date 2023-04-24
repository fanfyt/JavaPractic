package com.threadPractice.basic.火车票练习.p1;

public class TrainTicket01 {

    public static void main(String[] args) {

        Ticket ticket = new Ticket();

        for (int i = 0; i < 10; i++) {
            Thread.State state = ticket.getState();
            System.out.println(state);
            if (state.name().equals("RUNNABLE") || state.name().equals("NEW")) {
                ticket.start();
            } else {
                break;
            }

        }


    }

}
