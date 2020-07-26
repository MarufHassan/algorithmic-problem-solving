class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int[] ans = new int[num_people];
        int used = 0, i = 1;
        
        while (used + i < candies) {
            ans[(i - 1) % num_people] += i;
            used += i;
            i++;
        }
        ans[(i - 1) % num_people] += (candies - used);
        return ans;
    }
}