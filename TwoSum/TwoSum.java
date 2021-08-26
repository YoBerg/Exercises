import java.util.*;

public class TwoSum {
    
    public static void main(String[] args) {
        // Generate a random array of length n with values from 1 to 10 * n.
        int n = 10;
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = randomInt(n * 10);
        }

        // Find two random and different indeces from the array.
        int index1 = randomInt(arr.length) - 1;
        int index2;
        do {
            index2 = randomInt(arr.length) - 1;
        } while(index1 == index2);
        
        // Perform the TwoSum
        int target = arr[index1] + arr[index2];
        int[] ans = twoSum(arr, target);
        printArr(arr);

        // Prints results
        if (ans.length == 0) System.out.println("Error: Indeces not found."); // This should not occur.
        else System.out.println("Indeces found: " + ans[0] + ", " + ans[1] + ". Target: " + target + ". Match? " + (target == arr[ans[0]] + arr[ans[1]]));

        // FailCheck
        System.out.printf("Fail Check: " + failCheck());
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
     * Prints all the elements of an array.
     * 
     * @param arr the array to be printed.
     */
    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("\n");
    }

    /**
     * Runs a test that should fail. Expects an empty array output.
     * 
     * @return true if the returned array is empty.
     */
    public static boolean failCheck() {
        int[] nums = {1, 2, 3, 4, 5};
        int target = 100;
        int[] res = twoSum(nums, target);
        return res.length == 0;
    }

    /**
     * Brute-force TwoSum solution.
     * Finds the indeces of two numbers in the given array that sums to the target.
     * Up to (n^2 - n) / 2 comparisons (n choose 2). O(n^2) time.
     * 
     * @param nums the given array of integers.
     * @param target the target for the sum.
     * @return an array of indeces. An empty array if no solution is found.
     */
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        // No match found, return an empty array.
        return new int[] {};
    }
}