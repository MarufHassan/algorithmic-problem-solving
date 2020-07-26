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