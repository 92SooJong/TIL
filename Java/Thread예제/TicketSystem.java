package com.company;

public class TicketSystem{

    private int remainedTickets; // 남은 티켓
    private final int MAX_TICKETS = 15; // 7장까지만 발급 되도록 한다.

    public TicketSystem(int remainedTickets){
        this.remainedTickets = remainedTickets;
    }

    // 티켓 채워넣기
    public synchronized void addTicket(int tickets){


        this.remainedTickets += tickets;
        if(remainedTickets > MAX_TICKETS){
            remainedTickets = MAX_TICKETS;
        }
        notifyAll();
        //System.out.println("직원이 티켓을 채웠습니다. 남은 티켓은 " + remainedTickets + "장 입니다.");
        //notifyAll();

    }

    // 티켓 발급하기
    public synchronized void publishTicket(int tickets , String cusomerName) throws InterruptedException {

        while(true){

            if(this.remainedTickets > tickets && this.remainedTickets > 0){

                // 시간지연
                //for(long i =0L; i<100000000L; i++){ }

                this.remainedTickets =  this.remainedTickets - tickets;
                System.out.println(cusomerName + "에게 " + tickets + "장 발권 완료했습니다. " + " 남은 티켓은 " + this.remainedTickets + "장 입니다.");

                break;
            }
            wait();

        }


    }
}
