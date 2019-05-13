public class Solution {
    public int kthSmallest(final int[][] matrix, int k) {
        int c = 0;
        
        PriorityQueue<int[]> queue = new PriorityQueue<>(
            k, (o1, o2) -> matrix[o1[0]][o1[1]] - matrix[o2[0]][o2[1]]);
        queue.offer(new int[] {0, 0});
        
        while (true) {
            int[] pair = queue.poll();
            if (++c == k) {
                return matrix[pair[0]][pair[1]];
            }
            if (pair[0] == 0 && pair[1] + 1 < matrix[0].length) {
                queue.offer(new int[] {0, pair[1] + 1});
            }
            if (pair[0] + 1 < matrix.length) {
                queue.offer(new int[] {pair[0] + 1, pair[1]});
            }
        }
    }
}