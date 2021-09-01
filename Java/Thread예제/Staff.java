package com.company;

public class Staff extends Thread{

    TicketSystem ticketSystem;
    
    public Staff(TicketSystem ticketSystem){
        this.ticketSystem = ticketSystem;
    }


    @Override
    public void run() {

        // 직원이 티켓을 시스템에 등록한다
        while(true){
            ticketSystem.addTicket(1);
            System.out.println("this = " + this.getThreadGroup());;
        }



    }
}
