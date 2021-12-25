/**
 * Main8
 */
public class Main1 {

    static int res = 0;
    public static void main(String[] args) {
        int arr[] = {15, 20, 17, 45, 11};
        int sum = 55;

        getAllCombination(arr, sum, 0);
        System.out.println(res);
    }

    private static void getAllCombination(int[] arr, int sum, int index) {

        if(sum == 0){
            res++;
        }
        for(int i = index; i < arr.length; i++){
            if(sum - arr[i] >= 0){
                getAllCombination(arr, sum - arr[i], i);
            }
        }
    }
}