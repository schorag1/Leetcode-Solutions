class Solution {
    public String longestPalindrome(String s) {
        int length = s.length();
        
        if (length == 0 || length == 1) {
            return s;
        }
        
        boolean[][] isPalindrome = new boolean[length][length];
  
        for (int i = 0; i < length; i++) {
            isPalindrome[i][i] = true;
        }
  
        int start = 0;
        int maxLength = 1;
  
        for (int i = 0; i < length - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                isPalindrome[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }
  
        for (int k = 3; k <= length; k++) {
            for (int i = 0; i < length - k + 1; i++) {
                int j = i + k - 1;
                if (isPalindrome[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                    start = i;
                    maxLength = k;
                    isPalindrome[i][j] = true;
                }
            }
        }
        
        return s.substring(start, start + maxLength);
    }
}