package com.gevernova.producerconsumer;

import java.util.LinkedList;
import java.util.Queue;

public class Buffer {
    private final Queue<Integer> queue = new LinkedList<>();
    private final int capacity;

    public Buffer(int capacity) {
        this.capacity = capacity;
    }

    // Producer adds items to the buffer
    public synchronized void produce(int value) throws InterruptedException {
        while (queue.size() == capacity) {
            wait(); // Wait if buffer is full
        }
        queue.add(value);
        System.out.println("Produced: " + value);
        notifyAll(); // Notify consumers
    }

    // Consumer removes items from the buffer
    public synchronized int consume() throws InterruptedException {
        while (queue.isEmpty()) {
            wait(); // Wait if buffer is empty
        }
        int value = queue.poll();
        System.out.println("Consumed: " + value);
        notifyAll(); // Notify producers
        return value;
    }
}