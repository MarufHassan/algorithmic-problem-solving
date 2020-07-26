class Solution {
    public int findMinDifference(List<String> timePoints) {
        int ans = Integer.MAX_VALUE;
        List<Integer> times = new ArrayList<>();
        
        for (String time : timePoints) {
            int minute = toMinute(time);
            times.add(minute);
        }
        
        Collections.sort(times);
        
        int minute1, minute2;
        for (int i = 1; i < timePoints.size(); i++) {
            
            minute1 = times.get(i);
            minute2 = times.get(i - 1);
            
            ans = Math.min(ans, diff(minute1, minute2));
            
        }
        minute1 = times.get(0);
        minute2 = times.get(times.size() - 1);
        ans = Math.min(ans, diff(minute1, minute2));
        return ans;
    }
    
    private int diff(int t1, int t2) {
        int a = Math.abs(t1 - t2);
        int b = t1 + (1440 - t2);
        int c = t2 + (1440 - t1);
        return Math.min(a, Math.min(b, c));
    }
    
    private int toMinute(String time) {
        String[] s = time.split(":");
        int h = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        return h * 60 + m;
    }
}