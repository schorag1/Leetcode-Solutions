class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze == null || maze.length == 0)
            return true;
        
        int[][] directions = {{0, 1}, {1,0}, {0,-1}, {-1, 0}};
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        visited[start[0]][start[1]] = true;
        
        while(!queue.isEmpty()){
            int[] temp = queue.remove();
            
            if(temp[0] == destination[0] && temp[1] == destination[1])
                return true;
            
            for(int[] direction: directions){
                int x = temp[0] + direction[0];
                int y = temp[1] + direction[1];
                
                while(x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
                    x += direction[0];
                    y += direction[1];
                }
                
                if(!visited[x - direction[0]][y - direction[1]]) {
                    queue.add(new int[] {x - direction[0], y - direction[1]});
                    visited[x - direction[0]][y - direction[1]] = true;
                }
            }
        }
        
        return false;
    }
}