import java.util.Arrays;

// Given an array A[] consisting 0s, 1s and 2s. The task is to write a function that sorts the given array. The functions should put all 0s first, then all 1s and all 2s in last.
// Examples: 
 

// Input: {0, 1, 2, 0, 1, 2}
// Output: {0, 0, 1, 1, 2, 2}

// Input: {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1}
// Output: {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2}


class Main1{
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 2, 1, 1, 0, 1, 0, 1, 0, 2};
        int n = arr.length;
        sortIt(arr, n);

        Arrays.stream(arr).forEach(d -> System.out.print(d+", "));
    }

    public static void sortIt(int[] arr, int n){
        int low = 0; // for 0
        int mid = 0; // for 1
        int hi = n - 1; // for 2

        int temp = 0;
        
        while(mid <= hi){
        
            if(arr[mid] == 0){
                temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                low++;
                mid++;
            }
            else if(arr[mid] == 1){
                mid++;
            }
            else if(arr[mid] == 2){
                temp = arr[hi];
                arr[hi] = arr[mid];
                arr[mid] = temp;
                hi--;
            }
        }

    }
}