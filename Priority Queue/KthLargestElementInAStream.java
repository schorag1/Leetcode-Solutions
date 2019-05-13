class KthLargest {

    public PriorityQueue<Integer> heap = new PriorityQueue<Integer>((a,b) -> a - b);
    int k;
    
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int num:nums){
            heap.add(num);
            if(heap.size() > k)
                heap.poll();
        }
    }
    
    public int add(int val) {
        heap.add(val);
        if(heap.size() > k)
            heap.poll();
        return heap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */