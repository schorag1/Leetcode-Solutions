class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> results = new ArrayList<>();
        
        List<int[]> heights = new ArrayList<>();
        for(int[] b: buildings){
            heights.add(new int[] {b[0], -b[2]});
            heights.add(new int[] {b[1], b[2]});
        }
        
        Collections.sort(heights, (a,b) -> {
            if(a[0] != b[0])
                return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        pq.offer(0);
        int prev = 0;
        
        for(int[] height: heights){
            if(height[1] < 0)
                pq.offer(-height[1]);
            else
                pq.remove(height[1]);
            
            int current = pq.peek();
            
            if(prev != current){
                results.add(new int[] {height[0], current});
                prev = current;
            }
        }
        
        return results;
    }
}