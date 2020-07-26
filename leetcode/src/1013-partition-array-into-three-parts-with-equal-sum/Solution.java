class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int v : A) {
            sum += v;
        }
        if (sum % 3 != 0)   return false;
        
        int count = 0, running = 0;
        for (int v : A) {
            running += v;
            if (running == sum / 3) {
                count++;
                running = 0;
            }
        }
        return count == 3;
    }
}