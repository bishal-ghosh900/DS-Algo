import java.util.*;

/**
 * 
Design a way to sort a list of positive integers in descending order based on the frequency of elements.

Eg: size 19
arr = {1,2,2,3,3,3,4,4,5,5,5,5,6,6,6,7,8,9,10}
O/p:
{5,5,5,5,3,3,3,6,6,6,2,2,4,4,1,7,8,9,10}

 */



class Solution{

    public int[] frequencyBasedSort(int[] arr, int n){
        int[] result = new int[n];
        HashMap<Integer, ArrayList<Integer>> freq = this.getFrequencyMap(arr, n);
        Stack<Integer> s = new Stack<>();
        int count = 0;

        while(n-- > 0){
            int maxKey = Integer.MIN_VALUE;
            int maxValue = Integer.MIN_VALUE;
            
            for(Map.Entry<Integer, ArrayList<Integer>> m: freq.entrySet()){
                int v = m.getKey();
                int k =  m.getValue().get(0);
                if(k > maxKey && !s.contains(v)){
                    maxKey = k;
                    maxValue = v;
                   
                }
            }

            for(int i = 0; i < maxKey; i++){
                result[count++] = maxValue;
            }

            s.add(maxValue);
        }
        return result;
    }

    public HashMap<Integer, ArrayList<Integer>> getFrequencyMap(int[] arr, int n){

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            if(!map.containsValue(arr[i])){
                ArrayList<Integer> l = new ArrayList<>();
                l.add(this.getFrequency(arr, n, arr[i]));
                map.put(arr[i], l );
            }
        }
        

        return map;
    }

    public int getFrequency(int[] arr, int n, int key){
        
        int count = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] == key){
                count++;
            }
        }
        return count;
    }
}

public class Main1{
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {1,2,2,3,3,3,4,4,5,5,5,5,6,6,6,7,8,9,10};
        int n = arr.length;
        int[] result = s.frequencyBasedSort(arr, n);
        System.out.println(Arrays.toString(result));
    }

   
}
