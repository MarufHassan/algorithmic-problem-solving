class RLEIterator {
    private int[] seq;
    private int ptr;
    
    public RLEIterator(int[] A) {
        seq = A;
        ptr = 0;
    }
    
    public int next(int n) {
        while (ptr < seq.length && n > seq[ptr]) {
            n -= seq[ptr];
            ptr += 2;
        }
        
        if (ptr >= seq.length)  return -1;
        
        seq[ptr] -= n;
        
        return seq[ptr + 1];
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(A);
 * int param_1 = obj.next(n);
 */