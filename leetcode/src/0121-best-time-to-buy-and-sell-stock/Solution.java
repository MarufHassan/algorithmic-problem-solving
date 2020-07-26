class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;
        int n = prices.length;
        int[] sells = new int[n];
        int minprice = prices[0], maxprofit = 0;
        
        for (int i = 1; i < n; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            maxprofit = Math.max(prices[i] - minprice, maxprofit);
        }
        
        return maxprofit;
    }
}