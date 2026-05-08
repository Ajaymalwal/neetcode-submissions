class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        for(int i=0; i < grid.length; i++){
            for(int j=0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                 int tempArea = countArea(i,j,grid);
                 maxArea = (maxArea >= tempArea)? maxArea : tempArea;
                }
            }
        }
        return maxArea;
    }

    int countArea(int row, int col, int[][] grid){
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0) return 0;

        grid[row][col] = 0;

        return 1+countArea(row+1,col,grid) + countArea(row-1,col,grid) + countArea(row,col+1,grid) + countArea(row,col-1,grid);
    }
}


