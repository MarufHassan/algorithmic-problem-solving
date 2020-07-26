class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if (intervals.size() == 0) return res;
        
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        
        Interval interval = intervals.get(0);
        int start = interval.start, end = interval.end;
        
        for (int i = 1; i < intervals.size(); i++) {
            interval = intervals.get(i);
            if (interval.start > end) {
                res.add(new Interval(start, end));
                start = interval.start;
            }
            if (interval.end > end)
                end = interval.end;
        }
        res.add(new Interval(start, end));
        return res;
    }
}