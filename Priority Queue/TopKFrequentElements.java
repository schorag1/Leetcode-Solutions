class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int element:nums)
            map.put(element, map.getOrDefault(element,0) + 1);
        
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((a,b) -> map.get(b) - map.get(a));
        
        for(int element: map.keySet())
            heap.add(element);
        
        List<Integer> list = new ArrayList<Integer>();
        
        while(k-- != 0)
            list.add(heap.poll());
        
        return list;
    }
}