class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return 0;
        
        int answer = 0;
        int[][] cache = new int[matrix.length][matrix[0].length];
        
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                answer = Math.max(answer, dfs(matrix, i, j, cache, Integer.MAX_VALUE));
            }
        }
        
        return answer;
    }
    
    private int dfs(int[][] matrix, int i, int j, int[][] cache, int previous){
        if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] >= previous)
            return 0;
        
        if(cache[i][j] > 0)
            return cache[i][j];
        
        int current = matrix[i][j];
        int tempMax = 0;
        
        tempMax = Math.max(tempMax, dfs(matrix, i-1, j, cache, current));
        tempMax = Math.max(tempMax, dfs(matrix, i+1, j, cache, current));
        tempMax = Math.max(tempMax, dfs(matrix, i, j-1, cache, current));
        tempMax = Math.max(tempMax, dfs(matrix, i, j+1, cache, current));
        
        cache[i][j] = ++tempMax;
        
        return tempMax;
    }
}