package com.gevernova.producerconsumer;

public class Consumer implements Runnable {
    private final Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            try {
                buffer.consume();
                Thread.sleep(800); // Simulate work
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
