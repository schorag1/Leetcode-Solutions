class Solution {
    public boolean isMatch(String string, String pattern) {
        boolean dp[][] = new boolean[string.length()+1][pattern.length()+1];
        
        dp[0][0] = true;
        
        for(int i=1; i<dp[0].length; i++){
            if(pattern.charAt(i-1) == '*')
                dp[0][i] = dp[0][i-2];
        }
        
        for(int i=1; i<dp.length; i++){
            for(int j=1; j < dp[0].length; j++){
                if(pattern.charAt(j-1) == '.' || string.charAt(i-1) == pattern.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else if(pattern.charAt(j-1) == '*'){
                    dp[i][j] = dp[i][j-2];
                    if(pattern.charAt(j-2) == '.' || pattern.charAt(j-2) == string.charAt(i-1)){
                        dp[i][j] = dp[i][j] || dp[i-1][j];
                    }
                }
                else{
                    dp[i][j] = false;
                }
            }
        }
        
        return dp[string.length()][pattern.length()];
    }
}