class Solution {
    public int lastStoneWeight(int[] stones) {
        
        Queue<Integer> maxHeap = new PriorityQueue<Integer>((a,b) -> b - a);
        
        for(int weight: stones)
            maxHeap.offer(weight);
        
        while(!maxHeap.isEmpty()){
            
            if(maxHeap.size() == 1)
                return maxHeap.poll();
            
            int x = maxHeap.poll();
            int y = maxHeap.poll();
            
            if(x == y)
                continue;
            
            maxHeap.offer(x-y);
        }
        
        return 0;
    }
}