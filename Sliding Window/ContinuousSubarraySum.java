class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int start = 0;
        int end = 0;
        int sum = 0;
        
        while(end < nums.length){
            sum += nums[end];
            end++;
            
            while(sum > k && start < end - 1){
                sum -= nums[start];
                start++;
            }
            
            if(sum == k || (k != 0 && sum % k == 0) )
                return true;
        }
        
        return false;
    }
}