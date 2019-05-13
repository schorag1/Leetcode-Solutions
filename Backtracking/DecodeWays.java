class Solution {
    public int numDecodings(String s) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        return decodeWays(0, s, map);
    }
    
    private int decodeWays(int index, String s, Map<Integer, Integer> map){
        if(index >= s.length())
            return 1;
        
        if(map.containsKey(index))
            return map.get(index);
        
        int ways = 0;
        
        if(index+1 <= s.length()){
            if(isValid(s.substring(index, index+1)))
                ways += decodeWays(index+1, s, map);
        }
        
        if(index+2 <= s.length()){
            if(isValid(s.substring(index, index+2)))
                ways += decodeWays(index+2, s, map);
        }
        
        map.put(index, ways);
        return ways;
    }
    
    private boolean isValid(String s){
        if(s.length() == 0)
            return false;
        
        if(s.charAt(0) == '0')
            return false;
        
        int value = Integer.parseInt(s);
        
        if(value >= 1 && value <= 26)
            return true;
        
        return false;
    }
}