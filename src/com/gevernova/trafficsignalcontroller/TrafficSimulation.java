package com.gevernova.trafficsignalcontroller;

public class TrafficSimulation {
    public static void main(String[] args) {
        TrafficSignalController controller = new TrafficSignalController();

        String[] directions = {"North", "East", "South", "West"};
        for (String dir : directions) {
            new SignalThread(controller, dir).start();
        }
    }
}

