# [225. Implement Stack using Queues][title]

## Problem Description

Implement the following operations of a stack using queues.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.

Detailed description can be found [here][title]

**Example:**

```
MyStack stack = new MyStack();

stack.push(1);
stack.push(2);  
stack.top();   // returns 2
stack.pop();   // returns 2
stack.empty(); // returns false
```

## Solution

**Approach 1: Two Queues, push - O(n), pop O(1)**

```java
class MyStack {
    private Queue<Integer> q1;
    private Queue<Integer> q2;
    
    /** Initialize your data structure here. */
    public MyStack() {
        q1 = new LinkedList<Integer>();
        q2 = new LinkedList<Integer>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        q2.add(x);
        while (!q1.isEmpty())
            q2.add(q1.remove());
        while (!q2.isEmpty())
            q1.add(q2.remove());
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return q1.remove();
    }
    
    /** Get the top element. */
    public int top() {
        return q1.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }
}
```

**Approach 2: Two Queues, push - O(1), pop O(n)**

```java
class MyStack {
    private Queue<Integer> q1;
    private Queue<Integer> q2;
    private int top;
    
    /** Initialize your data structure here. */
    public MyStack() {
        q1 = new LinkedList<Integer>();
        q2 = new LinkedList<Integer>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        top = x;
        q1.add(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while (q1.size() > 1) {
            top = q1.remove();
            q2.add(top);
        }
        int r = q1.remove();
        Queue<Integer> t = q1;
        q1 = q2;
        q2 = t;
        return r;
    }
    
    /** Get the top element. */
    public int top() {
        return top;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }
}
```

**Approach 3: One Queue, push - O(n), pop O(1)**

```java
class MyStack {
    private Queue<Integer> q;
    private int top;
    
    /** Initialize your data structure here. */
    public MyStack() {
        q = new LinkedList<Integer>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        int n = q.size();
        q.add(x);
        for (int i = 0; i < n; i++)
            q.add(q.remove());
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return q.remove();
    }
    
    /** Get the top element. */
    public int top() {
        return q.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q.isEmpty();
    }
}
```

## Test

```java
// Your MyStack object will be instantiated and called as such:
MyStack obj = new MyStack();
obj.push(x);
int param_2 = obj.pop();
int param_3 = obj.top();
boolean param_4 = obj.empty();
```

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/implement-stack-using-queues/