class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>((a,b) -> Integer.compare(b[0]*b[0] + b[1]*b[1], a[0]*a[0]                   + a[1]*a[1]));
        
        for(int[] point: points){
            maxHeap.add(point);
            if(maxHeap.size() > k)
                maxHeap.remove();
        }
        
        int[][] result = new int[k][2];
        while(k-- > 0){
            result[k] = maxHeap.remove();
        }
        
        return result;
    }
}