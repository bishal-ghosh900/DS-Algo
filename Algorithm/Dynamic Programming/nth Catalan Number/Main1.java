class Main1 {

    // catalan numbers -> 1 1 2 5 14 42 132...
    // if we index the above numbers using 0 based indexing, then
    // 0 -> 1, 1 -> 1, 2 -> 2, 3 -> 5, 4 -> 14, 5 -> 42, 6 -> 132,...
    // lets say we want to get the value of 5th index, formula for that is ->
    // C(5) = C(0)*C(4) + C(1)*C(3) + C(2)*C(2) + C(3)*C(1) + C(4)*C(0) 
    public static void main(String[] args) {
        int n = 5;

        long[] arr = new long[n + 1];
        arr[0] = 1l;
        arr[1] = 1l;


        for(int i = 2; i <= n; i++){
            arr[i] = 0;
            for(int j = 0; j < i; j++){
                arr[i] += arr[j] * arr[i-j-1];
            }
        }
        System.out.println(arr[n]);

    }
}