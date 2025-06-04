package com.gevernova.producerconsumer;

public class Producer implements Runnable {
    private final Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }


    @Override
    public void run() {
        int value = 1;
        while (true) {
            try {
                buffer.produce(value++);
                Thread.sleep(500); // Simulate work
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
