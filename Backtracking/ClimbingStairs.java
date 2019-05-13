class Solution {
    public int climbStairs(int n) {
        HashMap<Integer, Integer> hash = new HashMap<Integer,Integer>();
        
        return helper(n, hash);
    }
    
    private int helper(int n, HashMap<Integer, Integer> hash){
        if(n < 0)
            return 0;
        
        if(n ==  0)
            return 1;
        
        if(hash.containsKey(n))
            return hash.get(n);
        
        int answer = helper(n-1, hash) + helper(n-2, hash);
        hash.put(n, answer);
        return answer;
    }
}