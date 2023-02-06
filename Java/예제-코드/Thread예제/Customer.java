package com.company;

public class Customer extends Thread{

    private TicketSystem ticketSystem;
    private String customerName;

    public Customer(TicketSystem ticketSystem, ThreadGroup threadGroup,String threadName){
        super(threadGroup,threadName);
        this.customerName = threadName;
        this.ticketSystem = ticketSystem;
    }

    @Override
    public void run() {
        // 5장 발행요청
        try {
            ticketSystem.publishTicket(5 , this.customerName);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}