class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        
        int rows = grid.length;
        int cols = grid[0].length;
        int islands = 0;
        
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j] == '1'){
                    islands++;
                    search(grid,i,j);
                }
            }
        }
        
        return islands;
    }
    
    public void search(char grid[][], int r, int c){
         int rows = grid.length;
        int cols = grid[0].length;
        
        if(!isValid(r,c,rows,cols))
            return;
        
         if(grid[r][c] == '0')
            return;
        
        grid[r][c] = '0';
        search(grid,r-1,c);
        search(grid,r+1,c);
        search(grid,r,c-1);
        search(grid,r,c+1);
    }
    
    public boolean isValid(int r, int c, int rows, int cols){
        if(r<0 || c<0 || r >= rows || c >= cols)
            return false;
        return true;
    }
}