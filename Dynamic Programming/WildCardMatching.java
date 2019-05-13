class Solution {
    public boolean isMatch(String string, String pattern) {
        if(string == null || pattern == null)
            return string == pattern;
        
        boolean[][] dp = new boolean[string.length()+1][pattern.length()+1];
        dp[0][0] = true;
        
        for(int j=1; j<dp[0].length; j++){
            if(pattern.charAt(j-1) == '*')
                dp[0][j] = true;
            else
                break;
        }
        
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                
                if(string.charAt(i-1) == pattern.charAt(j-1) || pattern.charAt(j-1) == '?')
                    dp[i][j] = dp[i-1][j-1];
                
                else if(pattern.charAt(j-1) == '*')
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                
                else
                    dp[i][j] = false;
            }
        }
        
        return dp[string.length()][pattern.length()];
    }
}