# [232. Implement Queue using Stacks][title]

## Problem Description

Implement the following operations of a queue using stacks.

push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.

Detailed description can be found [here][title]

**Example:**

```
MyQueue queue = new MyQueue();

queue.push(1);
queue.push(2);  
queue.peek();  // returns 1
queue.pop();   // returns 1
queue.empty(); // returns false
```

## Solution

**Approach 1**

```java
class MyQueue {
    private Stack<Integer> s;
    private Stack<Integer> aux;
    
    public MyQueue() {
        s = new Stack<Integer>();
        aux = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        while (!s.empty())
            aux.push(s.pop());
        s.push(x);
        while (!aux.empty()) 
            s.push(aux.pop());
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return s.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        return s.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s.empty();
    }
}
```

**Approach 2**

```java
class MyQueue {
    private Stack<Integer> s1;
    private Stack<Integer> s2;
    private int front;
    
    public MyQueue() {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        if (s1.empty())
            front = x;
        s1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (s2.empty()) {
            while (!s1.empty()) 
                s2.push(s1.pop());
        }
        return s2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if (!s2.empty())
            return s2.peek();
        return front;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.empty() && s2.empty();
    }
}
```

## Test

```java
// Your MyQueue object will be instantiated and called as such:
MyQueue obj = new MyQueue();
obj.push(x);
int param_2 = obj.pop();
int param_3 = obj.peek();
boolean param_4 = obj.empty();
```


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/implement-queue-using-stacks