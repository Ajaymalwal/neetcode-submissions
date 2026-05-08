class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int r = grid.length;
        int c = grid[0].length;
        for(int i=0; i < r; i++){
            for(int j=0; j < c; j++){
                if(grid[i][j] == 0){
                    q.add(new int[]{i, j});
                }
            }
        }

        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            for(int[] d : dirs) {
                int ni = curr[0] + d[0], nj = curr[1] + d[1];
                if(ni >= 0 && ni < r && nj >= 0 && nj < c && grid[ni][nj] == 2147483647) {
                    grid[ni][nj] = grid[curr[0]][curr[1]] + 1;
                    q.add(new int[]{ni, nj});
                }
            }
        }
    }
}