/**
 * 
 * Dazzler had an array of N distinct non-negative integers. Somehow he lost the array, but he knows the
 * bitwise XOR of all the elements in the array. You have to help him to retrieve the array.
 * 
 * You are given two positive integers N and X. Construct an array A of N elements with the following
 * conditions:
 * 
 * 1. For each i (1≤i≤N), 0≤Ai≤5⋅105.
 * 
 * 2. All the elements in the array A should be pairwise distinct, i.e, Ai≠Aj if i≠j
 * The bitwise XOR of all the N elements in the array should be equal to X, i.e, A1⊕A2⊕…⊕AN=X, where ⊕
 * denotes the bitwise XOR operation.
 * 
 * If there are multiple possible solutions, you may print any of them
 * 
 * Constraints
 * 1≤ T ≤2⋅10^5
 * 1≤ N ≤10^5
 * 1≤ X ≤5⋅10^5
 * 0≤ Ai ≤5⋅10^5
 * The sum of N over all test cases does not exceed 3⋅10^5
 * 
 */


// Solution -> 

// Here we are going to take all values from 0 to till n-2 values and do xor of them, ((n-2)'th element is the second last element). And last element will be calculated by doing the XOR between total xor of n-2 element and the required xor element.

// Lets say N = 3 and X = 1
// then we, need to get total XOR of 0 to 1 (N-2 -> 3-2 -> 1) element , and lets store it in a variable, say temp
// so , temp = 0 ⊕ 1 = 1
// and now we need one more element to result, as N = 3, so we need 3 element to result and we have got two elements (0 and 1) ,now we need to find the last element. To get last element -> 
// last_element  = X ⊕ temp
// By this way we will be able to get the last element.
// Now, we have a condition to not have any duplicate values.
// so we need to check if the last element is duplicate to any other previously stored values,
// Check if the last value is greater than or equal N-1 and less than 500000. 
// Why This check ? 
// First, As we have xored values till N-2 so, if the last element's value is >= N-1 then its definately not a duplicate number ,
// Second, From the constraint its given that the Ai should be <= 5⋅10^5. A is the array of elements we are going to result.

// if the above condition is true then store the last element as the last element of the whole result array
// if the above condition is false , then definately the last element is containing a duplicate value ->
// if false, then we have to do some things ->
    // As we know the Ai <= 500000,
    // lets observe ->
    // 2^18 = 262144, and 2^19 = 524288 
    // so 2^19 is the upper bound, which is beyond the Ai constraint value, which is containig 19 bits.
    // 2^18 is in the constraint , and having 18 bits.
    // lets do -> max18 = 1 << 18; It is storing a value which having 18 bits where only 18th bit is set and rest are unset . 
    // Now, if last element is duplicate then if we XOR that element with max18 then we will get a number which will be in the constraint range , but here we will not be able to get the desired total XOR   (i.e 1 , as X = 1 we have taken in the example input above) of all element .
    // for that, first check if the A0 is the same to last element or not
        // If same then set the 18th bit of A1 to 1,
        // Else set the 18th bit of A0 to 1.
    // Now the two bit 1s from (one 1 from A0 or A1 and another 1 from last element) will be xored to cancel each other , so that we will now be able to get the desired XOR from the result array.


/**
 * Main
 */
public class Main1 {

    public static void main(String[] args) {
        int N = 3;
        int X = 1;

        retriveTheArray(N, X);
        
    }

    private static void retriveTheArray(int N, int X) {
        if(N == 1){
            System.out.println(X);
        }
        
        int[] arr = new int[N];
        int temp = 0;
        for(int i = 0; i <= N - 2; i++){
            arr[i] = i;
            temp ^= i;
        }
        
        int last = X ^ temp;
        int max18 = 1 << 18;
        if(last >= N-1 && last < 500000){
            arr[N-1] = last;
        } else {
            arr[N-1] = last ^ max18;
            if((arr[0] ^ max18) == arr[N-1]) arr[1] ^= max18;
            else arr[0] ^= max18;
        }
        
        for(int i = 0; i < N; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}