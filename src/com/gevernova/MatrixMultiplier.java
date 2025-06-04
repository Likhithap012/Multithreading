package com.gevernova;

class MatrixMultiplier {
    static int[][] A = {
            {1, 2, 3},
            {4, 5, 6}
    };

    static int[][] B = {
            {7, 8},
            {9, 10},
            {11, 12}
    };

    static int[][] result = new int[A.length][B[0].length];

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[A.length];

        // Create and start a thread for each row of A
        for (int i = 0; i < A.length; i++) {
            int row = i; // effectively final for lambda
            threads[i] = new Thread(() -> multiplyRow(row));
            threads[i].start();
        }

        // Wait for all threads to finish
        for (Thread t : threads) {
            t.join();
        }

        // Print result
        System.out.println("Result Matrix:");
        for (int[] row : result) {
            for (int val : row) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }
    }

    // Method to compute one row of the result
    static void multiplyRow(int row) {
        for (int j = 0; j < B[0].length; j++) {
            for (int k = 0; k < B.length; k++) {
                result[row][j] += A[row][k] * B[k][j];
            }
        }
    }
}

