class Solution {
    public int distributeCandies(int[] candies) {
        Set<Integer> unique = new HashSet<>();
        for (int type : candies) {
            unique.add(type);
        }
        return Math.min(candies.length / 2, unique.size());
    }
}