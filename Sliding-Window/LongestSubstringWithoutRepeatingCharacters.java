class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        
        int start = 0;
        int end = 0;
        int max = 0;
        
        while(start < s.length() && end < s.length()){
            if(!set.contains(s.charAt(end))){
                set.add(s.charAt(end));
                end++;
                
                max = Math.max(max, end - start);
            }
            else{
                set.remove(s.charAt(start));
                start++;
            }
        }
        
        return max;
    }
}