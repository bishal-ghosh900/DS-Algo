class Main1 {

    // need to find maximum amount of gold.
    public static void main(String[] args) {
        int[][] mat = { {1, 3, 1, 5},
                        {2, 2, 4, 1},
                        {5, 0, 2, 3},
                        {0, 6, 1, 2} };

        int res = getMaxGold(mat);
        System.out.println(res);
    }

    private static int getMaxGold(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        int[][] gold = new int[mat.length][mat[0].length];

        for(int col = m - 1; col >= 0; col--){
            for(int row = 0; row < n; row++){
                int right_up = (row-1 < 0 || col+1 >= m) ? 0 : gold[row - 1][col + 1];
                int right = (col+1 >= m) ? 0 : gold[row][col + 1];
                int right_down = (row+1 >= n || col + 1 >= m) ? 0 : gold[row + 1][col + 1];
                
                gold[row][col] = mat[row][col] + Math.max(right, Math.max(right_up, right_down));
            }
        }

        int res = gold[0][0];
        for(int[] is: gold){
            res = Math.max(res, is[0]);
        }
        
        
        return res;
    }

}