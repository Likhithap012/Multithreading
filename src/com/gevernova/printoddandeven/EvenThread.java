package com.gevernova.printoddandeven;

public class EvenThread extends Thread{
    private Print print;
    public EvenThread(Print print){
        this.print=print;
    }


    public void run()  {
        try {
            print.printEven();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }

}
