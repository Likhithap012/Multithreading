package com.gevernova;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class FizzBuzzMultithreaded {
    private final int n;
    private int current = 1;

    private final ReentrantLock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    public FizzBuzzMultithreaded(int n) {
        this.n = n;
    }

    public void fizz() {
        while (true) {
            lock.lock();
            try {
                while (current <= n && !(current % 3 == 0 && current % 5 != 0)) {
                    condition.await();
                }
                if (current > n) break;

                System.out.println("Fizz");
                current++;
                condition.signalAll();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                lock.unlock();
            }
        }
    }

    public void buzz() {
        while (true) {
            lock.lock();
            try {
                while (current <= n && !(current % 5 == 0 && current % 3 != 0)) {
                    condition.await();
                }
                if (current > n) break;

                System.out.println("Buzz");
                current++;
                condition.signalAll();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                lock.unlock();
            }
        }
    }

    public void fizzbuzz() {
        while (true) {
            lock.lock();
            try {
                while (current <= n && !(current % 15 == 0)) {
                    condition.await();
                }
                if (current > n) break;

                System.out.println("FizzBuzz");
                current++;
                condition.signalAll();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                lock.unlock();
            }
        }
    }

    public void number() {
        while (true) {
            lock.lock();
            try {
                while (current <= n && (current % 3 == 0 || current % 5 == 0)) {
                    condition.await();
                }
                if (current > n) break;

                System.out.println(current);
                current++;
                condition.signalAll();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        FizzBuzzMultithreaded fb = new FizzBuzzMultithreaded(20);

        Thread fizz = new Thread(fb::fizz);
        Thread buzz = new Thread(fb::buzz);
        Thread fizzbuzz = new Thread(fb::fizzbuzz);
        Thread number = new Thread(fb::number);

        fizz.start();
        buzz.start();
        fizzbuzz.start();
        number.start();
    }
}

