/*
Given an array A[] and a number x, check for pair in A[] with sum as x
Difficulty Level : Easy
Last Updated : 21 Jun, 2021
Write a program that, given an array A[] of n numbers and another number x, determines whether or not there exist two elements in S whose sum is exactly x. 

Examples: 

Input: arr[] = {0, -1, 2, -3, 1}
        sum = -2
Output: -3, 1
If we calculate the sum of the output,
1 + (-3) = -2

Input: arr[] = {1, -2, 1, 0, 5}
       sum = 0
Output: -1
No valid pair exists.
*/

/**
 * Main
 */

import java.util.*;
public class Main1 {

    public static void main(String[] args) {
        int[] arr = {1, -2, 1, 0, 5};
        int sum = 0;

        findSumPair(arr, sum);
    }

    public static void findSumPair(int[] arr, int sum){
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < arr.length; i++){
            Integer remain = sum - arr[i];
            if(set.contains(remain)){
                System.out.println("The pair is "+ remain + " and " + arr[i]);
                return;
            }
            
            set.add(arr[i]);
        }
        System.out.println("There is no pair for this sum");
    }
}