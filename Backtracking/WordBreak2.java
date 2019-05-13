class Solution {
    Map<Integer, List<String>> map = new HashMap<>();
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        return recursion(s, new HashSet(wordDict), 0);
    }
    
    private List<String> recursion(String s, Set<String> wordDict, int start){
        if(map.containsKey(start))
            return map.get(start);
        
        List<String> result = new LinkedList<>();
        if(start == s.length())
            result.add("");
        
        for(int end = start+1; end <= s.length(); end++){
            if(wordDict.contains(s.substring(start, end))){
                
                List<String> list = recursion(s, wordDict, end);
                for(String str: list)
                    result.add(s.substring(start, end) + (str.equals("") ? "" : " ") + str);
            }
        }
        
        map.put(start, result);
        
        return result;
    }
}