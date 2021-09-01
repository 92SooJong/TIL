package com.company;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        // 티켓시스템 생성
        TicketSystem ticketSystem = new TicketSystem(0);

        // 스탭 쓰레드 1개 생성
        Staff staff = new Staff(ticketSystem);
        staff.start();

        // 고객 쓰레드를 담을 group을 생성한다
        ThreadGroup customerGroup = new ThreadGroup("customerGroup");
        // 10개 고객 쓰레드 생성과 시작
        for(int i=0; i<10; i++){
            String customerName = "customer".concat( String.valueOf(i)); // 쓰레드 이름 생성
            Customer customer = new Customer(ticketSystem , customerGroup , customerName); // 고객쓰레드 생성
            customer.start();
        }

        System.out.println("Thread.getAllStackTraces() = " + Thread.activeCount());

        // 고객 쓰레드가 모두 종료된 경우 스탭 쓰레드를 종료한다.
        while(true){
            if(customerGroup.activeCount() <= 0){
                staff.interrupt(); // 상태가 wait일때 정지수행.
                break;
            }
        }
    }
}
