class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int r = grid.length;
        int c = grid[0].length;
        int fresh = 0;
        int time = 0;

        for(int i =0; i<r; i++){
            for(int j =0; j<c; j++){
                if(grid[i][j] == 2) q.offer(new int[]{i,j});
                if(grid[i][j] == 1) fresh++;
            }
        }

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        while(!q.isEmpty() && fresh > 0){
            int length = q.size();
            for(int i=0; i< length; i++){
                int[] curr = q.poll();
                for(int[] d : dirs){
                    int ni = curr[0] + d[0], nj = curr[1] + d[1];
                    if( ni >= 0 && nj >= 0 && ni < r && nj < c && grid[ni][nj] == 1){
                        grid[ni][nj] = 2;
                        fresh--;
                        q.offer(new int[]{ni,nj});
                    }
                }
            }
            time++;
        }
        
       return fresh == 0 ? time : -1;

    }
}
