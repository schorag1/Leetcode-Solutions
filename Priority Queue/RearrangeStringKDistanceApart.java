class Solution {
    public String rearrangeString(String s, int k) {
        StringBuilder result = new StringBuilder();
        
        Map<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
        
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));
        maxHeap.addAll(map.keySet());
        
        Queue<Character> waitQueue = new LinkedList<>();
        
        while(!maxHeap.isEmpty()){
            char c = maxHeap.poll();
            result.append(c);
            map.put(c, map.get(c) - 1);
            waitQueue.offer(c);
            
            if(waitQueue.size() < k)
                continue;
            
            char front = waitQueue.poll();
            if(map.get(front) > 0)
                maxHeap.offer(front);
        }
        
        return result.length() == s.length() ? result.toString() : "";
        
    }
}