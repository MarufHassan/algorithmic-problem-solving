class Solution {
    public int reverse(int x) {
        int num = 0;
        int tmax = Integer.MAX_VALUE / 10;
        int tmin = Integer.MIN_VALUE / 10;
        while (x != 0) {
            int pop = x % 10;
            
            if (num > tmax || (num == tmax / 10 && pop > 7))
                return 0;
            if (num < tmin || (num == tmin && pop < -8))
                return 0;

            num = (num * 10) + pop;            
            x = x / 10;
        }      
        return num;
    }
}