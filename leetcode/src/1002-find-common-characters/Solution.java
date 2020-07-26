class Solution {
    public List<String> commonChars(String[] A) {
        List<String> ans = new ArrayList<>();
        
        int[] minCount = new int[26];
        Arrays.fill(minCount, Integer.MAX_VALUE);
        
        for (String s : A) {
            int[] count = new int[26];
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                count[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                minCount[i] = Math.min(minCount[i], count[i]);
            }
        }
        
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < minCount[i]; j++) {
                ans.add((char)(i + 'a') + "");
            }
        }
        
        return ans;
    }
}