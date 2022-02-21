import java.util.*;

class Point {
    private Integer i;
    private Integer j;
    
    Point(int i, int j){
        this.i = i;
        this.j = j;
    }
    
    @Override
    public boolean equals(Object object){
        Point res = (Point) object;
        return i.equals(res.i) && j.equals(res.j) ? true : false;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(i, j);
    }
}

class Main1 {
    
    static int targetRow = 2, targetCol = 2;
    static HashMap<Point, Integer> DP = new HashMap<>();
    public static void main(String[] args) {
        int[][] cost = {
            {1, 2, 3},
            {4, 8, 2},
            {1, 5, 3}
        };
        int minCost = getMinCost(cost, 0, 0);
        System.out.println(minCost);
    }

    private static int getMinCost(int[][] cost, int i, int j) {

        if(i == targetRow && j == targetCol){
            return cost[i][j];
        }
        
        if(j == targetCol + 1){
            return Integer.MAX_VALUE;
        }

        if(i >= cost.length || j >= cost.length){
            return Integer.MAX_VALUE;
        }

        Point point = new Point(i, j);

        if(DP.getOrDefault(point, -1) != -1){
            return DP.get(point);
        }

        DP.put(point, cost[i][j] + min(getMinCost(cost, i + 1, j), getMinCost(cost, i, j + 1), getMinCost(cost, i + 1, j + 1)));
        
        return DP.get(point);
    }

    private static int min(int a, int b, int c) {
        if(a < b && a < c){
            return a;
            
        } else{
            if(c < b){
                return c;
            }else {
                return b;
            }
        }
    }
}