/*
 * @(#)Main.java openjdk-19 10/04/22
 * Copyright (c) 1994-1999 Sun Microsystems, Inc.
 * 901 San Antonio Road, Palo Alto, California, 94303, U.S.A.
 * All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Sun
 * Microsystems, Inc. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Sun.
 */

package ai221.shevchenko;

/**
 * Contains methods for working with arrays and creating a game FizzBuzz
 *
 * @author Keiichi-Kun
 * @version openjdk-19 10 Oct 2022
 */
public class Main {

    /**
     * Checks if an array is sorted
     *
     * @param arr - An array that contains integers
     * @param size - An array size
     */
    private static boolean isSortedUpArray(int[] arr, final int size) {

        // Loop through the elements of an array starting from the second element
        for (int i = 1; i < size; ++i) {
            // Checking if the current element is greater than the last
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Launches the game FizzBuzz
     */
    private static void playFizzBuzz() {

        // Loop from 1 to 100
        for (int i = 1; i <= 100; ++i) {
            // If the current element is a multiple of 5 and 3
            if (i % 15 == 0) {
                System.out.print("FizzBuzz"); // Print "FizzBuzz"
            } else if (i % 3 == 0) {
                System.out.print("Fizz"); // Print "Fizz"
            } else if (i % 5 == 0) {
                System.out.print("Buzz"); // Print "Buzz"
            } else {
                System.out.print("Number: " + i);  // Print the current number
            }
            System.out.print("\n"); // New line
        }
    }

    /**
     * Compares the sums of two parts of an array whether they are equal
     *
     * @param arr - An array that contains integers
     * @param size - An array size
     */
    private static boolean compareHalvesOfArray(int[] arr, final int size) {

        int sumFirstHalve = 0; // The sum of the first part of the array
        int sumSecondHalve = 0; // The sum of the second part of the array

        //Calculates the sum of the first and second parts of an array
        for (int i = 0; i < size; ++i) {
            if (i < size / 2) {
                sumFirstHalve += arr[i];
            } else {
                sumSecondHalve += arr[i];
            }
        }
        return sumFirstHalve == sumSecondHalve;
    }

    /**
     * Prints an array of integers
     *
     * @param arr - An array that contains integers
     */
    private static void printArray(int[] arr) {
        System.out.print("Array: { ");
        // Iterates through the array
        for (int i : arr) {
            System.out.print(i + " "); // Prints the current element
        }
        System.out.println("}");
    }

    /**
     * Launches the application
     *
     * @param args - Application startup arguments
     */
    public static void main(String[] args) {

        System.out.println("Task 1");

        // Array initialization for task 1
        int[] arrTask1 = {1, 2};
        printArray(arrTask1);
        System.out.println("Result: " + isSortedUpArray(arrTask1, 2) + '\n'); // Output of the results of the first task

        System.out.println("Task 2");
        playFizzBuzz();
        System.out.print("\n");

        System.out.println("Task 3");

        // Array initialization for task 3
        int[] arrTask3 = {2, 1, 1, 1, 1};
        printArray(arrTask3);
        System.out.println("Result: " + compareHalvesOfArray(arrTask3, 5)); // Output of the results of the third task
    }
}