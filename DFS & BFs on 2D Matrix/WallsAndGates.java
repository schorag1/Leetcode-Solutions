class Solution {
    public void wallsAndGates(int[][] rooms) {
        if(rooms.length == 0)
            return;
        
        int[] directions = new int[] {0, 1, 0, -1, 0};
        Queue<int[]> queue = new LinkedList<>();
        
        for(int row = 0; row < rooms.length; row++){
            for(int col = 0; col < rooms[0].length; col++){
                if(rooms[row][col] == 0)
                    queue.offer(new int[] {row, col});
            }
        }
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            
            for(int k=0; k<4; k++){
                int nextRow = current[0] + directions[k];
                int nextCol = current[1] + directions[k+1];
                
                if(!isValid(nextRow, nextCol, rooms.length, rooms[0].length) || rooms[nextRow][nextCol] != Integer.MAX_VALUE)
                    continue;
                
                rooms[nextRow][nextCol] = rooms[current[0]][current[1]] + 1;
                
                queue.add(new int[] {nextRow, nextCol});
            }
        }
    }
    
    private boolean isValid(int row, int col, int rows, int cols){
        if(row >= 0 && row < rows && col >= 0 && col < cols)
            return true;
        
        return false;
    }
}