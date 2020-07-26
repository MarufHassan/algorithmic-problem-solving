class Solution {
    public int heightChecker(int[] heights) {
        int count = 0;
        
        int[] copy = Arrays.copyOf(heights, heights.length);
        Arrays.sort(copy);
        
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != copy[i])
                count++;
        }
        
        return count;
    }
}