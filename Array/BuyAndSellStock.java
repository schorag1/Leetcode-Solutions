class Solution {
    public int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        
        for(int i=0; i<prices.length; i++){
            if(prices[i] < minprice){
                minprice = prices[i];
                continue;
            }
            
            int profit = prices[i] - minprice;
            if(profit > maxprofit)
                maxprofit = profit;
        }
        
        return maxprofit;
    }
}