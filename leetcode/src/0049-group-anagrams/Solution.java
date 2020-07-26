class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> freq = new HashMap<>();
        
        for (String s : strs) {
            String key = codes(s);
            freq.putIfAbsent(key, new ArrayList<>());
            freq.get(key).add(s);
        }
        
        return new ArrayList<>(freq.values());
    }
    
    private String codes(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        return Arrays.toString(count);
    }
}