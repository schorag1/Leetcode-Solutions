class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length,i,j;
        
        for(j=1;j<n;j++)
            grid[0][j] += grid[0][j-1];
        
        for(i=1;i<m;i++)
            grid[i][0] += grid[i-1][0];
        
        for(i=1;i<m;i++){
            for(j=1;j<n;j++){
                grid[i][j] += minimum(grid[i-1][j] , grid[i][j-1]);
            }
        }
        
        return grid[m-1][n-1];
    }
    
    public int minimum(int a, int b){
        return (a < b ? a : b);
    }
}