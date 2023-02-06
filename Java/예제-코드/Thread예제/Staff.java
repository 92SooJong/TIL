package com.company;

public class Staff extends Thread{

    private TicketSystem ticketSystem;
    private boolean workDone = false;

    public Staff(TicketSystem ticketSystem){
        this.ticketSystem = ticketSystem;
    }

    public void setWorkDone(boolean workDone) {
        this.workDone = workDone;
    }

    @Override
    public void run() {

        // 직원이 티켓을 시스템에 등록한다
        while(!workDone){
            ticketSystem.addTicket(1);
        }


    }
}
