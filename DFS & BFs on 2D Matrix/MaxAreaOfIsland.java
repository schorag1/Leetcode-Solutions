class Solution {
    int[][] grid;
    boolean[][] visited;
    
    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        visited = new boolean[grid.length][grid[0].length];
        int answer = 0;
        
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                answer = Math.max(answer, area(i,j));
            }
        }
        
        return answer;
    }
    
    private int area(int row, int col){
        if(!isValid(row,col))
            return 0;
        
        if(visited[row][col] || grid[row][col] == 0)
            return 0;
        
        visited[row][col] = true;
        
        return (1 + area(row+1,col) + area(row-1,col) + area(row, col+1) + area(row, col-1));
    }
    
    private boolean isValid(int row, int col){
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length)
            return false;
        return true;
    }
}