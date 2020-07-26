class StockSpanner {
    private Stack<Integer> prices, weights;
    
    public StockSpanner() {
        prices = new Stack<>();
        weights = new Stack<>();
    }
    
    public int next(int price) {
        int weight = 1;
        
        while (!prices.isEmpty() && prices.peek() <= price) {
            weight += weights.pop();
            prices.pop();
        }
        
        prices.push(price);
        weights.push(weight);
        return weight;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */