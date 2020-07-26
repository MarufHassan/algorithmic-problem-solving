class Solution {
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        Map<Integer, TreeSet<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < colors.length; i++) {
            map.putIfAbsent(colors[i], new TreeSet<>());
            TreeSet<Integer> indices = map.get(colors[i]);
            indices.add(i);
        }
        
        List<Integer> ans = new ArrayList<>();
        for (int[] q : queries) {
            TreeSet<Integer> indices = map.get(q[1]);
            if (indices == null) {
                ans.add(-1);
                continue;
            }
            Integer ceil = indices.ceiling(q[0]);
            Integer floor = indices.floor(q[0]);
            int min;
            if (ceil == null && floor == null) {
                min = -1;
            } else if (ceil == null) {
                min = Math.abs(q[0] - floor);
            } else if (floor == null) {
                min = Math.abs(q[0] - ceil);
            } else {
                min = Math.min(Math.abs(ceil - q[0]), Math.abs(floor - q[0]));
            }
            ans.add(min);
        }
        
        return ans;
    }
}