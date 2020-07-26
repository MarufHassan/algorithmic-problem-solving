class MyCircularDeque {
    private int front, rear, size;
    private int[] data;
    
    /** Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        front = 0; rear = -1; size = 0;
        data = new int[k];
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()) return false;
        size += 1;
        front = (front - 1) % data.length;
        if (front < 0) front += data.length;
        data[front] = value;
        if (size == 1)
            rear = front;
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()) return false;
        size += 1;
        rear = (rear + 1) % data.length;
        data[rear] = value;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty())  return false;
        size -= 1;
        front = (front + 1) % data.length;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty())  return false;
        size -= 1;
        rear = (rear - 1) % data.length;
        if (rear < 0)
            rear += data.length;
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        return isEmpty() ? -1 : data[front];
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        return isEmpty() ? -1 : data[rear];
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == data.length;
    }
}