class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        return robHouses(nums, nums.length-1, map);
    }
    
    private int robHouses(int[] nums, int i, Map<Integer, Integer> map){
        if(i < 0)
            return 0;
        
        if(map.containsKey(i))
            return map.get(i);
        
        int result = Math.max(robHouses(nums, i-2,map) + nums[i] , robHouses(nums, i-1, map));
        map.put(i, result);
        return result;
    }
}