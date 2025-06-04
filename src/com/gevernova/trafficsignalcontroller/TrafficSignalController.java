package com.gevernova.trafficsignalcontroller;

class TrafficSignalController {
    private final String[] directions = {"North", "East", "South", "West"};
    private int currentGreenIndex = 0;

    // Method to control which signal is green
    public synchronized void showGreen(String direction) {
        while (!direction.equals(directions[currentGreenIndex])) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Signal is green
        System.out.println(direction + " signal is GREEN");
        try {
            Thread.sleep(2000); // green for 2 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println(direction + " signal is RED");

        // Move to next direction
        currentGreenIndex = (currentGreenIndex + 1) % directions.length;
        notifyAll(); // notify other threads
    }
}

