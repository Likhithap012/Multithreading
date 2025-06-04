package com.gevernova;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DigitalClock {

    private static volatile boolean running = true; // Used to stop the thread gracefully

    public static void main(String[] args) {
        Thread clockThread = new Thread(() -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            while (running) {
                LocalTime now = LocalTime.now();
                System.out.println("Current Time: " + now.format(formatter));
                try {
                    Thread.sleep(1000); // Sleep for 1 second
                } catch (InterruptedException e) {
                    System.out.println("Clock interrupted.");
                    break;
                }
            }
            System.out.println("Clock stopped.");
        });

        clockThread.start();

        // Let the clock run for 10 seconds then stop it
        try {
            Thread.sleep(10000); // Main thread sleeps for 10 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        running = false; // Set flag to stop the clock thread
    }
}

