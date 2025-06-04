package com.gevernova.printoddandeven;

public class OddThread extends Thread {
    private Print print;
    public OddThread(Print print){
        this.print=print;
    }

    public void run() {
        try{
            print.printOdd();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
