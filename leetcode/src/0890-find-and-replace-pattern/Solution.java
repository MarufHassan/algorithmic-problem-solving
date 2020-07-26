class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        int[] ref = codes(pattern);
        
        for (String word : words) {
            int[] t = codes(word);
            if (Arrays.equals(ref, t))
                res.add(word);
        }
        
        return res;
    }
    
    private int[] codes(String s) {
        int[] code = new int[s.length()];
        Map<Character, Integer> map = new HashMap<>();
        
        int i = 0;
        for (char c : s.toCharArray()) {
            map.putIfAbsent(c, map.size());
            code[i++] = map.get(c);
        }
        
        return code;
    }
}