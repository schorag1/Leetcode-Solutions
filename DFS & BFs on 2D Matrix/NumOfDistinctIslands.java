class Solution {
    int[][] grid;
    boolean[][] seen;
    ArrayList<Integer> shape;
    
    public int numDistinctIslands(int[][] grid) {
        this.grid = grid;
        seen = new boolean[grid.length][grid[0].length];
        Set<ArrayList<Integer>> shapes = new HashSet<>();
        
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                shape = new ArrayList<Integer>();
                
                explore(i,j,0);
                
                if(!shape.isEmpty())
                    shapes.add(shape);
            }
        }
        
        return shapes.size();
    }
    
    private void explore(int row, int col, int d){
        if(!isValid(row,col))
            return;
        
        if(seen[row][col] || grid[row][col] == 0)
            return;
        
        seen[row][col] = true;
        shape.add(d);
        
        explore(row+1,col,1);
        explore(row-1,col,2);
        explore(row,col+1,3);
        explore(row,col-1,4);
        
        shape.add(0);
    }
    
    private boolean isValid(int row, int col){
        if(row < 0 || col <0 || row >= grid.length || col >= grid[0].length)
            return false;
        return true;
    }
}