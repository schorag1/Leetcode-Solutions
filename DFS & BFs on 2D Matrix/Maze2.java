class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int[][] distance = new int[maze.length][maze[0].length];
        for(int[] row: distance)
            Arrays.fill(row, Integer.MAX_VALUE);
        
        distance[start[0]][start[1]] = 0;
        dijkstra(maze, start, distance);
        
        if(distance[destination[0]][destination[1]] == Integer.MAX_VALUE)
            return -1;
        else
            return distance[destination[0]][destination[1]];
    }
                                            
    private void dijkstra(int[][] maze, int[] start, int[][] distance){
        int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> Integer.compare(a[2], b[2]));
        queue.offer(new int[]{start[0], start[1], 0});
        
        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            
            if(distance[temp[0]][temp[1]] < temp[2])
                continue;
            
            for(int[] direction: directions){
                int x = temp[0] + direction[0];
                int y = temp[1] + direction[1];
                int count = 0;
                
                while(x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0){
                    x += direction[0];
                    y += direction[1];
                    count++;
                }
                
                x -= direction[0];
                y -= direction[1];
                
                if(distance[temp[0]][temp[1]] + count < distance[x][y]){
                    distance[x][y] = distance[temp[0]][temp[1]] + count;
                    queue.offer(new int[]{x, y, distance[x][y]});
                }
            }
        }
    }
}