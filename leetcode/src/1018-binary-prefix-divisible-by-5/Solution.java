class Solution {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> ans = new ArrayList<>();
        int n = 0;
        for (int d : A) {
            n = (n * 2 + d) % 5;
            ans.add(n == 0);
        }
        
        return ans;
    }
}