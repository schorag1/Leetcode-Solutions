class Solution {
    public int maxSubArray(int[] nums) {
        int MaxSoFar = nums[0], MaxUntilHere = nums[0];
        for(int i=1; i<nums.length; i++){
            MaxUntilHere = Math.max(MaxUntilHere+nums[i], nums[i]);
            MaxSoFar = Math.max(MaxSoFar, MaxUntilHere);
        }
        
        return MaxSoFar;
    }
}