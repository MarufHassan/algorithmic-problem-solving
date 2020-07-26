class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        String[] ans = new String[100];
        int idx = 0;
        Map<String, Integer> freq = new HashMap<>();
        
        for (String word : A.split(" ")) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }
        
        for (String word : B.split(" ")) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }
        
        for (String word : freq.keySet()) {
            if (freq.get(word) == 1)
                ans[idx++] = word;
        }
        
        return Arrays.copyOf(ans, idx);
    }
}