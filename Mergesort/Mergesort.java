import java.lang.Math;
import java.util.*;

/**
 * Mergesort by Yohan Berg
 * 
 * A java program to perform mergesort on a random array of a given length.
 * Takes one integer input as the maximum value in the array.
 * The array will contain values from 1 to the given maximum.
 */
public class Mergesort {

    public static void main(String[] args) {
        // Receive input, generate random array of the given length.
        if (args.length < 1) {
            System.out.println("No arguments given!");
            return;
        }
        try {
            int len = Integer.parseInt(args[0]);
            if (len < 1) {
                System.out.println("The argument was an invalid length!");
                return;
            }
            int[] arr = new int[len];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = randomInt(100);
            }
            // Print array, before and after the sort.
            printArray(arr);
            
            // Sort the array.
            sort(arr);
            
            printArray(arr);
            System.out.println(isSorted(arr));
        } catch (NumberFormatException e) {
            System.out.println("The argument was not a valid integer!");
            return;
        }
    }

    /**
     * Generate a random integer from 1 to the given maximum.
     * 
     * @param max the maximum integer of the random number.
     * @return a random interger from 1 to the given maximum.
     */
    public static int randomInt(int max) {
        return (int) Math.floor(Math.random() * (max)) + 1;
    }

    /**
     * Checks if the given integer array is sorted.
     * 
     * @param arr the array to be checked.
     * @return whether or not the array is sorted.
     */
    public static boolean isSorted(int[] arr) {
        int prev = 0;
        
        for (int i = 0; i < arr.length; i++) {
            if (prev > arr[i]) return false;
            prev = arr[i];
        }

        return true;
    }

    /**
     * Prints the given array to the console.
     * 
     * @param arr the integer array to be printed.
     */
    public static void printArray(int[] arr) {
        System.out.println("===");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("===");
    }

    /**
     * Sorts the given array using mergesort.
     * This will replace the given array.
     *
     * @param arr the array to be sorted.
     */
    public static void sort(int[] arr) {
        // Base Case
        if (arr.length == 1) return;

        // Splitting the array
        int midpoint = arr.length / 2;
        int[] left_arr = Arrays.copyOfRange(arr, 0, midpoint);
        int[] right_arr = Arrays.copyOfRange(arr, midpoint, arr.length);

        // Sorting the subarrays    
        sort(left_arr);
        sort(right_arr);

        // Combining the subarrays
        int left_pointer = 0;
        int right_pointer = 0;
        /** 
         * Check which array has smaller value then 
         *  assign it to sorted array
         */ 
        while (left_pointer + right_pointer < arr.length) {
            // Left array has been traversed
            if (left_pointer >= left_arr.length) {
                arr[left_pointer + right_pointer] 
                    = right_arr[right_pointer];
                right_pointer++;
            }
            // Right array has been traversed
            else if (right_pointer >= right_arr.length) {
                arr[left_pointer + right_pointer]
                    = left_arr[left_pointer];
                left_pointer++;
            }
            // Both arrays still have values.
            else {
                // Left array has smaller or equal value
                if (left_arr[left_pointer] <= right_arr[right_pointer]) { 
                    arr[left_pointer + right_pointer]
                        = left_arr[left_pointer];
                    left_pointer++;
                }
                // Right array has smaller value
                else {
                    arr[left_pointer + right_pointer]
                        = right_arr[right_pointer];
                    right_pointer++;
                }
            }
        }
        // Array is sorted. Replace given array.
    }
}