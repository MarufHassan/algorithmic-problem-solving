# [155. Min Stack][title]

## Problem Description

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time. Detailed description can be found [here][title]

**Example:**

```
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.
```

## Solution


```java
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
```


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/min-stack/