class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length()+1;
        int len2 = word2.length()+1;
        
        if(len1-1 == 0)
            return len2-1;
        if(len2-1 == 0)
            return len1-1;
        
        int[][] dp = new int[len1][len2];
        
        dp[0][0] = 0;
        
        for(int i=1; i<len1; i++)
            dp[i][0] = i;
        for(int i=1; i<len2; i++)
            dp[0][i] = i;
        
        for(int i=1; i<len1; i++){
            for(int j=1; j<len2; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = 1 + min(dp[i-1][j-1], dp[i][j-1], dp[i-1][j]);
            }
        }
        
        return dp[len1-1][len2-1];
    }
    
    private int min(int a, int b, int c){
        if(a <= b && a<= c)
            return a;
        else if(b <= a && b <= c)
            return b;
        return c;
    }
}