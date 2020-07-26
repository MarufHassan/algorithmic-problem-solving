# [Queues: A Tale of Two Stacks][title]

## Problem Description

Detail description can be found [here][title]. 

**Example 1:**

```
    Input: 
        10
        1 42
        2
        1 14
        3
        1 28
        3
        1 60
        1 78
        2
        2
    Output:
        14
        14
```

## Solution

**Approach 1:**

```java
public static class MyQueue<T> {
    Stack<T> stack = new Stack<T>();
    Stack<T> aux = new Stack<T>();

    public void enqueue(T value) {
        while (!stack.empty())
            aux.push(stack.pop());
        stack.push(value);
        while (!aux.empty())
            stack.push(aux.pop());
    }

    public T peek() {
         return stack.peek();
    }

    public T dequeue() {
        return stack.pop();
    }
}
```

**Approach 2:**

```java
public static class MyQueue<T> {
    Stack<T> stack = new Stack<T>();
    Stack<T> aux = new Stack<T>();
    T front;

    public void enqueue(T value) {
        if (stack.empty())
            front = value;
        stack.push(value);
    }

    public T peek() {
        if (!aux.empty())
            return aux.peek();
        return front;
    }

    public T dequeue() {
        if (aux.empty()) {
            while (!stack.empty())
                aux.push(stack.pop());
        }
        return aux.pop();
    }
}
```

**Driver Program**

```java
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static class MyQueue<T> {
        /* see previous code */
    }

    
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();
        
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        
        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://www.hackerrank.com/challenges/ctci-queue-using-two-stacks