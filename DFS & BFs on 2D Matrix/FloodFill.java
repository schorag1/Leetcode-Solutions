class Solution {
    public int[][] floodFill(int[][] image, int row, int col, int newColor) {
        int color = image[row][col];
        
        if(color != newColor)
            dfs(image, row, col, color, newColor);
        
        return image;
    }
    
    private void dfs(int[][] image, int row, int col, int color, int newColor){
        if(row < 0 || row >= image.length || col < 0 || col >= image[0].length)
            return;
        
        if(image[row][col] != color)
            return;
        
        image[row][col] = newColor;
            
        dfs(image, row-1, col, color, newColor);
        dfs(image, row+1, col, color, newColor);
        dfs(image, row, col-1, color, newColor);
        dfs(image, row, col+1, color, newColor);
    }
}