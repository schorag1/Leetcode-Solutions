class Solution {
    public boolean isMonotonic(int[] a) {
        boolean increasing = true;
        boolean decreasing = true;
        
        for(int i=0; i<a.length-1; i++){
            if(a[i] > a[i+1])
                increasing = false;
            
            if(a[i] < a[i+1])
                decreasing = false;
        }
        
        return increasing || decreasing;
    }
}