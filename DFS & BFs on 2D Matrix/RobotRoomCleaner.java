/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */
class Solution {
    int[][] directions = new int[][]{
        {-1,0}, {0,1}, {1,0}, {0,-1}
    };
    
    public void cleanRoom(Robot robot) {
        Set<String> visited = new HashSet<>();
        dfs(robot, visited, 0, 0, 0);
    }
    
    private void dfs(Robot robot, Set<String> visited, int row, int col, int curDir){
        visited.add(row + "->" + col);
        robot.clean();
        
        for(int i=0; i<4; i++){
            int direction = (curDir+i)%4;
            
            int[] next = directions[direction];
            int nextRow = row + next[0];
            int nextCol = col + next[1];
            
            if(!visited.contains(nextRow + "->" + nextCol) && robot.move()){
                dfs(robot, visited, nextRow, nextCol, direction);
                
                robot.turnLeft();
                robot.turnLeft();
                robot.move();
                robot.turnRight();
                robot.turnRight();
            }
            
            robot.turnRight();
        }
    }
}