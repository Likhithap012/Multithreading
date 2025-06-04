package com.gevernova.producerconsumer;


public class ProducerConsumer {
    public static void main(String[] args) {
        Buffer buffer = new Buffer(5); // Shared buffer with capacity 5

        Thread producerThread = new Thread(new Producer(buffer));
        Thread consumerThread = new Thread(new Consumer(buffer));

        producerThread.start();
        consumerThread.start();
    }
}
