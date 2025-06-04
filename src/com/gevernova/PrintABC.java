package com.gevernova;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintABC {
    private static final int N = 5; // number of iterations
    private int turn = 0; // 0 for A, 1 for B, 2 for C

    private final Lock lock = new ReentrantLock();
    private final Condition conditionA = lock.newCondition();
    private final Condition conditionB = lock.newCondition();
    private final Condition conditionC = lock.newCondition();

    public void printA() {
        for (int i = 0; i < N; i++) {
            lock.lock();
            try {
                while (turn != 0) {
                    conditionA.await();
                }
                System.out.print("A");
                turn = 1;
                conditionB.signal();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                lock.unlock();
            }
        }
    }

    public void printB() {
        for (int i = 0; i < N; i++) {
            lock.lock();
            try {
                while (turn != 1) {
                    conditionB.await();
                }
                System.out.print("B");
                turn = 2;
                conditionC.signal();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                lock.unlock();
            }
        }
    }

    public void printC() {
        for (int i = 0; i < N; i++) {
            lock.lock();
            try {
                while (turn != 2) {
                    conditionC.await();
                }
                System.out.print("C");
                turn = 0;
                conditionA.signal();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        PrintABC printer = new PrintABC();

        Thread threadA = new Thread(printer::printA);
        Thread threadB = new Thread(printer::printB);
        Thread threadC = new Thread(printer::printC);

        threadA.start();
        threadB.start();
        threadC.start();
    }
}
