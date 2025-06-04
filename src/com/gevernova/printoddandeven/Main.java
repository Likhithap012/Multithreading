package com.gevernova.printoddandeven;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the Number:");
        int number=scanner.nextInt();
        scanner.close();

        Print print=new Print(number);
        Thread oddThread=new OddThread(print);
        Thread evenThread=new EvenThread(print);
        oddThread.start();
        evenThread.start();
    }
}
