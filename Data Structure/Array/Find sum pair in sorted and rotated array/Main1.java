
/**
 * Main
 */


/**
 * 
Given a sorted and rotated array, find if there is a pair with a given sum
Difficulty Level : Medium

Given an array that is sorted and then rotated around an unknown point. Find if the array has a pair with a given sum ‘x’. It may be assumed that all elements in the array are distinct.

Examples : 
Input: arr[] = {11, 15, 6, 8, 9, 10}, x = 16
Output: true
There is a pair (6, 10) with sum 16

Input: arr[] = {11, 15, 26, 38, 9, 10}, x = 35
Output: true
There is a pair (26, 9) with sum 35

Input: arr[] = {11, 15, 26, 38, 9, 10}, x = 45
Output: false
There is no pair with sum 45.
 */
public class Main1 {

    public static void main(String[] args) {
        int[] arr = {11, 15, 26, 38, 9, 10};
        int n = arr.length;
        int sum = 45;
        boolean check = IsSumPairExist(arr, n, sum);
        System.out.println(check);
    }

    public static boolean IsSumPairExist(int[] arr, int n, int sum){
        int remain;
        int index = -1;
        int l = 0;
        int h = n - 1;
        for(int i = 0; i < n; i++){
            remain = sum - arr[i]; 
            if(remain > 0){
                index = search(arr, l, h, remain);
            }

            if(index >= 0){
                return true;
            }
            else{
                continue;
            }
        }

        return false;
    }

    public static int search(int[] arr, int l, int h, int key){

        if(l > h){
            return -1;
        }

        int mid = l + (h - l) / 2;

        if(arr[mid] == key){
            return mid;
        }

        if(arr[mid] >= arr[l]){
            if(key >= arr[l] && key <= arr[mid]){
                return search(arr, l, mid - 1, key);
            }
            else{
                return search(arr, mid + 1, h, key);
            }
        }

        if(key >= arr[mid] && key <= arr[h]){
            return search(arr, mid + 1, h, key);
        }

        return search(arr, l, mid - 1, key);
        
    }
}