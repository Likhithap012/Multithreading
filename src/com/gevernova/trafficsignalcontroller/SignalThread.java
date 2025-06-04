package com.gevernova.trafficsignalcontroller;

class SignalThread extends Thread {
    private final TrafficSignalController controller;
    private final String direction;

    public SignalThread(TrafficSignalController controller, String direction) {
        this.controller = controller;
        this.direction = direction;
    }

    @Override
    public void run() {
        while (true) {
            controller.showGreen(direction);
        }
    }
}

