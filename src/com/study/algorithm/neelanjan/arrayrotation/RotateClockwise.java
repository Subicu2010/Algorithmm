package com.study.algorithm.neelanjan.arrayrotation;

import java.util.Arrays;

/**
 * Given an array, cyclically rotate the array clockwise by one.
 *
 * Examples:
 * Input: arr[] = {1, 2, 3, 4, 5}
 * Output: arr[] = {5, 1, 2, 3, 4}
 *
 * @author nilanjanc
 */
public class RotateClockwise {

    public static void main(String[] args) {
        //rotate the array using reversal approach
        int[] arr = {1,2,3,4,5};
        rotateClockwiseUsingReversal(arr, 1, arr.length);
        System.out.println(Arrays.toString(arr));

        //rotate using temp array
        arr = new int[]{1,2,3,4,5};
        rotateClockwiseUsingTempArray(arr, 2, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Complexity: O(n^2)
     *
     * @param arr
     * @param k
     * @param n
     */
    public static void rotateClockwiseUsingTempArray(int[] arr, int k, int n) {
        for (int i = 0; i < k; i++) {
            int temp = arr[n-1];
            for (int j = n - 2; j >= 0; j--) {
                arr[j+1] = arr[j];
            }
            arr[0] = temp;
        }
    }

    /**
     * Complexity: O(n)
     *
     * @param arr
     * @param i
     * @param n
     */
    private static void rotateClockwiseUsingReversal(int[] arr, int i, int n) {
        rotate(arr, 0, n - i - 1);
        rotate(arr, n - i, n - 1);
        rotate(arr, 0, n - 1);
    }

    private static void rotate(int[] arr, int i, int n) {
        while(i < n){
            int temp = arr[i];
            arr[i] = arr[n];
            arr[n] = temp;
            ++i;
            --n;
        }
    }


}
