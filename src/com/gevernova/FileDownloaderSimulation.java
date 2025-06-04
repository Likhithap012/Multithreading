package com.gevernova;

import java.util.ArrayList;
import java.util.List;

public class FileDownloaderSimulation {

    static class DownloadThread extends Thread {
        private String fileName;

        public DownloadThread(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public void run() {
            System.out.println("Starting download: " + fileName);
            try {
                // Simulate download time by sleeping 1-5 seconds
                int sleepTime = 1000 + (int)(Math.random() * 4000);
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                System.out.println(fileName + " download interrupted.");
            }
            System.out.println("Finished download: " + fileName);
        }
    }

    public static void main(String[] args) {
        String[] files = {"file1.txt", "file2.mp4", "file3.jpg", "file4.pdf"};
        List<Thread> threads = new ArrayList<>();

        // Create and start one thread per file
        for (String file : files) {
            Thread t = new DownloadThread(file);
            t.start();
            threads.add(t);
        }

        // Wait for all threads to complete
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                System.out.println("Main thread interrupted while waiting.");
            }
        }

        System.out.println("All downloads completed.");
    }
}

