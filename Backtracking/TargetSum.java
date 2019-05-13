class Solution {
    private int count;
    
    public int findTargetSumWays(int[] nums, int total) {
        dfs(nums, 0, 0 , total);
        return count;
    }
    
    private void dfs(int[] nums, int index, int sum, int total) {
        if(index == nums.length){
            if(sum == total)
                count++;
        }
        else{
            dfs(nums, index+1, sum + nums[index], total);
            dfs(nums, index+1, sum - nums[index], total);
        }
    }
}