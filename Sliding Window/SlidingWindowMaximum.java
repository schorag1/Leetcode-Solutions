class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0)
            return nums;
        Deque<Integer> deque = new ArrayDeque<Integer>();
        int[] result = new int[nums.length-k+1];
        int index = 0;
        
        for(int i=0;i<nums.length;i++){
            if(!deque.isEmpty() && i-k >= 0 && deque.peekFirst() == nums[i-k])
                deque.removeFirst();
            
            while(!deque.isEmpty() && deque.peekLast() < nums[i])
                deque.removeLast();
            
            deque.addLast(nums[i]);
            if(i >= k-1)
                result[index++] = deque.peekFirst();
        }
        
        return result;
    }
}