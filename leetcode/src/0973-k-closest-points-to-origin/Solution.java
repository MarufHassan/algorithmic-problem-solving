class Solution {
    private class Point {
        int x, y, dist;
        Point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    
    public int[][] kClosest(int[][] points, int K) {
        int n = points.length;
        Point[] arr = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = points[i][0];
            int y = points[i][1];
            arr[i] = new Point(x, y, (x * x + y * y));
        }
        Arrays.sort(arr, new Comparator<Point>() {
            public int compare(Point a, Point b) {
                if (a.dist < b.dist)  return -1;
                if (a.dist > b.dist)  return +1;
                return 0;
            }
        });
        
        int[][] res = new int[K][2];
        for (int i = 0; i < K; i++) {
            res[i][0] = arr[i].x;
            res[i][1] = arr[i].y;
        }
        return res;
    }
}