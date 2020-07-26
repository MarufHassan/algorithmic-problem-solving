class MinStack {
    private Stack<Integer> data;
    private Stack<Integer> min;
    
    public MinStack() {
        data = new Stack<Integer>();
        min = new Stack<Integer>();
    }
    
    public void push(int x) {
        data.push(x);
        if (min.empty() || x <= min.peek())
            min.push(x);
    }
    
    public void pop() {
        if (getMin() == top())
            min.pop();
        data.pop();
    }
    
    public int top() {
        return data.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}