# [622. Design Circular Queue][title]

## Problem Description

Design your implementation of the circular queue. Detailed description can be found [here][title]

**Example:**

```
MyCircularQueue circularQueue = new MyCircularQueue(3); // set the size to be 3
circularQueue.enQueue(1);  // return true
circularQueue.enQueue(2);  // return true
circularQueue.enQueue(3);  // return true
circularQueue.enQueue(4);  // return false, the queue is full
circularQueue.Rear();  // return 3
circularQueue.isFull();  // return true
circularQueue.deQueue();  // return true
circularQueue.enQueue(4);  // return true
circularQueue.Rear();  // return 4
```

## Solution

```java
class MyCircularQueue {
    private int front, rear, size;
    private int[] data;
    
    /** Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        front = 0; rear = -1; size = 0;
        data = new int[k];
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull()) return false;
        size += 1;
        rear = (rear + 1) % data.length;
        data[rear] = value;
        return true;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty()) return false;
        size -= 1;
        front = (front + 1) % data.length;
        return true;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        return size > 0 ? data[front] : -1;
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        return size > 0 ? data[rear] : -1;
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return size == data.length;
    }
}
```

## Test

```java
// Your MyCircularQueue object will be instantiated and called as such:
MyCircularQueue obj = new MyCircularQueue(k);
boolean param_1 = obj.enQueue(value);
boolean param_2 = obj.deQueue();
int param_3 = obj.Front();
int param_4 = obj.Rear();
boolean param_5 = obj.isEmpty();
boolean param_6 = obj.isFull();
```


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/design-circular-queue/