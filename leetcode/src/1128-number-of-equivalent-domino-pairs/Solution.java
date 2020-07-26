class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int[] dom : dominoes) {
            if (dom[0] > dom[1]) {
                int t = dom[0];
                dom[0] = dom[1];
                dom[1] = t;
            }
        }
        
        for (int[] dom : dominoes) {
            int code = Arrays.hashCode(dom);
            map.put(code, map.getOrDefault(code, 0) + 1);
        }
        int ans = 0;
        for (int dom : map.keySet()) {
            int count = map.get(dom);
            if (count > 1) {
                ans += (count * (count - 1) / 2);
            }
        }
        return ans;
    }
}