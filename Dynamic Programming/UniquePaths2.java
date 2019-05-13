class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        
        int[][] dp = new int[rows][cols];
        
        for(int j=0; j < cols; j++){
            if(obstacleGrid[0][j] == 1)
                break;
            
            dp[0][j] = 1;
        }
        
        for(int i=0; i < rows; i++){
            if(obstacleGrid[i][0] == 1)
                break;
            
            dp[i][0] = 1;
        }
        
        for(int i=1; i < rows; i++){
            for(int j=1; j < cols; j++){
                if(obstacleGrid[i][j] == 0)
                    dp[i][j] = dp[i-1][j] +  dp[i][j-1];
            }
        }
        
        return dp[rows-1][cols-1];
    }
}