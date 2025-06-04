package com.gevernova.printoddandeven;

public class Print {
    private int number=1;
    private final int Max;
    public Print(int max){
        this.Max=max;
    }
    public synchronized void printOdd() throws InterruptedException{
        while(number<=Max){
            if(number%2==0){
                wait();
            }else{
                System.out.println("odd "+number);
                number++;
                notify();
            }
        }
    }

    public synchronized void printEven() throws InterruptedException{
        while(number<=Max){
            if(number%2!=0){
                wait();
            }else{
                System.out.println("even "+number);
                number++;
                notify();
            }
        }
    }
}
