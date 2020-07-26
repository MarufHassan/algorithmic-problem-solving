class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        LinkedList<Integer> ans = new LinkedList<>();
        
        int i = A.length - 1, c = 0;
        while (i >= 0 || K > 0) {
            int d1 = (i >= 0) ? A[i] : 0;
            int d2 = K % 10;
            int r = d1 + d2 + c;
            ans.addFirst(r % 10);
            c = r / 10;
            i--; K /= 10;
        }
        if (c > 0)
            ans.addFirst(c);
        return ans;
    }
}