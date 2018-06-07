package com.study.algorithm.neelanjan.arrayrotation;

import java.util.Arrays;

/**
 * Write a function rotate(ar[], d, n) that rotates arr[] of size n by d elements.
 *
 * @author nilanjan
 * @version %I% %G%
 */
public class ArrayRotation {

    public static void main(String[] args) {

        int[] arr = {2, 7, 3, 11, 34, 45};
        leftRotateArrayUsingNewArray(arr, 2);
        System.out.println(Arrays.toString(arr));

        arr = new int[]{2, 7, 3, 11, 34, 45};
        leftRotateSerially(arr, 2);
        System.out.println(Arrays.toString(arr));

        arr = new int[]{2, 7, 3, 11, 34, 45};
        rotateReversal(arr, 2, arr.length);
        System.out.println(Arrays.toString(arr));

    }

    /**
     * traverse the array up to rotation left, stores the 0th element in temp variable
     * and shifts the rest of the elements left and stores back the temp
     * variable at end
     *
     * Complexity: O(n^2)
     *
     * @param arr
     * @param rotationLength
     */
    private static void leftRotateSerially(int[] arr, int rotationLength) {
        int length = arr.length;
        for (int i = 0; i < rotationLength; i++) {
            int temp = arr[0];
            int j = 0;
            for (; j < length - 1; j++) {
                arr[j] = arr[j+1];
            }
            arr[j] = temp;
        }
    }

    /**
     * this approach creates a new Array and copies the post rotation length elements from
     * the source array first and then copies the rotate elements
     *
     * Complexity: O(n)
     *
     * @param arr
     * @param rotateLength
     * @return
     */
    public static void leftRotateArrayUsingNewArray(int[] arr, int rotateLength){
        int[] newArray = new int[rotateLength];
        //copy the rotate elements in a new array
        System.arraycopy(arr, 0, newArray, 0, rotateLength);
        //left shift the rest of elements
        System.arraycopy(arr, rotateLength, arr, 0, arr.length - rotateLength);
        //copy back the previous elements
        System.arraycopy(newArray, 0, arr, arr.length - rotateLength, rotateLength);
    }

    /**
     * In this approach the first part of the array is reversed till the rotate index. Then
     * reverses the second part separately and finally reverses the whole array
     *
     * Complexity: O(n)
     *
     * @param arr source array
     * @param k rotation length
     * @param n total length
     */
    public static void rotateReversal(int[] arr, int k , int n){
        reverse(arr, 0, k-1);
        reverse(arr, k, n-1);
        reverse(arr, 0, n-1);
    }

    private static void reverse(int[] arr, int i, int n) {
        while(i < n){
            int temp = arr[i];
            arr[i] = arr[n];
            arr[n] = temp;
            ++i;
            --n;
        }
    }


}