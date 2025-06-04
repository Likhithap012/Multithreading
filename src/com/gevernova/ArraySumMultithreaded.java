package com.gevernova;

import java.util.concurrent.atomic.AtomicInteger;

import java.util.concurrent.atomic.AtomicInteger;

public class ArraySumMultithreaded {

    // Worker class that sums a portion of the array
    static class SumWorker implements Runnable {
        private int[] array;
        private int start, end;
        private AtomicInteger globalSum;

        public SumWorker(int[] array, int start, int end, AtomicInteger globalSum) {
            this.array = array;
            this.start = start;
            this.end = end;
            this.globalSum = globalSum;
        }

        @Override
        public void run() {
            int localSum = 0;
            for (int i = start; i < end; i++) {
                localSum += array[i];
            }
            globalSum.addAndGet(localSum);  // Thread-safe update
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int[] array = new int[1000];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;  // Fill array with values from 1 to 1000
        }

        int numberOfThreads = 4;
        Thread[] threads = new Thread[numberOfThreads];
        AtomicInteger globalSum = new AtomicInteger(0);

        int chunkSize = array.length / numberOfThreads;

        // Create and start threads
        for (int i = 0; i < numberOfThreads; i++) {
            int start = i * chunkSize;
            int end = (i == numberOfThreads - 1) ? array.length : start + chunkSize;
            threads[i] = new Thread(new SumWorker(array, start, end, globalSum));
            threads[i].start();
        }

        // Wait for all threads to finish
        for (Thread thread : threads) {
            thread.join();
        }

        // Final result
        System.out.println("Sum of array = " + globalSum.get());
    }
}

