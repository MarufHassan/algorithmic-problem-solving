class MyLinkedList {
    private class Node {
        int val;
        Node prev, next;
        public Node(int val) {
            this.val = val;
        }
    }

    private Node head, tail;
    private int size;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = null; tail = null;
        size = 0;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index < 0 || index >= size)
            return -1;
        Node x = head;
        while (index-- > 0) 
            x = x.next;
        return x.val;
    }
    
    /** Add a node of value val before the first element of the linked list. 
      * After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node n = new Node(val);
        n.next = head;
        if (head == null)
            tail = n;
        else
            head.prev = n;
        head = n;
        size++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node n = new Node(val);
        n.prev = tail;
        if (tail == null)
            head = n;
        else 
            tail.next = n;
        tail = n;
        size++;
    }
    
    /** Add a node of value val before the index-th node in the linked list.
      * If index equals to the length of linked list, the node will be appended to the end of linked list.
      * If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size)
            return;
        System.out.println(size);
        if (index == size) {
            addAtTail(val);
            return;
        }
        Node x = head;
        while (index-- > 0)
            x = x.next;
        addBefore(x, val);
    }

    private void addBefore(Node x, int val) {
        Node n = new Node(val);
        n.next = x;
        n.prev = x.prev;
        if (x.prev == null)
            head = n;
        else
            x.prev.next = n;
        x.prev = n;
        size++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size)
            return;
        Node x = head;
        while (index-- > 0) 
            x = x.next;
        if (x == head) {
            deleteFromHead();
            return;
        }
        if (x == tail) {
            deleteFromTail();
            return;
        }
        x.prev.next = x.next;
        x.next.prev = x.prev;
        size--;
    }

    private void deleteFromTail() {
        if (tail == null)
            return;
        if (head == tail) {
            head = null; tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
    }

    private void deleteFromHead() {
        if (head == null)
            return;
        if (head == tail) {
            head = null; tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
    }
}