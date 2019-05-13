class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
       return recursion(s, new HashSet(wordDict), 0, new Boolean[s.length()]);
    }
    
    public boolean recursion(String s, Set<String> dict, int start, Boolean[] memo){
        if(start == s.length())
            return true;
        
        if(memo[start] != null)
            return memo[start];
        
        for(int end = start + 1; end <= s.length(); end++){
            if(dict.contains(s.substring(start, end)) && recursion(s, dict, end, memo)){
                memo[start] = true;
                return memo[start];
            }
        }
        
        memo[start] = false;
        return memo[start];
    }
}