class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int count = 0;
        int lo = 0, hi = people.length - 1;
        
        while (lo <= hi) {
            if (people[hi] + people[lo] <= limit)
                lo++;
            count++; hi--;
        }
        
        return count;
    }
}