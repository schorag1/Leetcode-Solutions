class Solution {
    Map<Integer, Integer> map;
    public int fib(int n) {
        map = new HashMap<>();
        map.put(0,0);
        map.put(1,1);
        
        return find(n);
    }
    
    private int find(int n){
        if(map.containsKey(n))
            return map.get(n);
        
        int answer = find(n-1) + find(n-2);
        map.put(n, answer);
        return answer;
    }
}