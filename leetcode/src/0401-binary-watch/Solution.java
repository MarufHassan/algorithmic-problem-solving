class Solution {
    private int[] hours = {8, 4, 2, 1};
    private int[] minutes = {32, 16, 8, 4, 2, 1};
    
    private List<String> ans;
    
    public List<String> readBinaryWatch(int num) {
        ans = new ArrayList<>();
        
        for (int n = 0; n <= num; n++) {
            List<Integer> hourlist = new ArrayList<>();
            List<Integer> minutelist = new ArrayList<>();
            generateHours(n, 0, 0, hourlist);
            generateMinutes(num - n, 0, 0, minutelist);
            
            for (int h : hourlist) {
                if (h >= 12) continue;
                for (int m : minutelist) {
                    if (m > 59) continue;
                    String time = String.format("%d:%02d", h, m);
                    ans.add(time);
                }
            }
        }
        
        return ans;
    }
    
    private void generateHours(int num, int hour, int offset, List<Integer> collect) {
        if (num <= 0) {
            collect.add(hour);
            return;
        }
        if (offset >= hours.length) return;
        
        generateHours(num - 1, hour + hours[offset], offset + 1, collect);
        generateHours(num, hour, offset + 1, collect);
    }
    
    private void generateMinutes(int num, int minute, int offset, List<Integer> collect) {
        if (num <= 0) {
            collect.add(minute);
            return;
        }
        if (offset >= minutes.length) return;
        
        generateMinutes(num - 1, minute + minutes[offset], offset + 1, collect);
        generateMinutes(num, minute, offset + 1, collect);
    }
}