class Solution {
    private Set<String> perfect;
    private Map<String, String> lower;
    private Map<String, String> vowel;

    public Solution() {
        perfect = new HashSet<>();
        lower = new HashMap<>();
        vowel = new HashMap<>();
    }
    
    public String[] spellchecker(String[] wordlist, String[] queries) {
        for (String word : wordlist) {
            perfect.add(word);
            
            String lowercase = word.toLowerCase();
            
            lower.putIfAbsent(lowercase, word);
            vowel.putIfAbsent(devowel(lowercase), word);
        }
        
        String[] ans = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = solve(queries[i]);
        }
        return ans;
    }
    
    private String solve(String word) {
        if (perfect.contains(word))
            return word;
        
        String lo = word.toLowerCase();
        String ans = lower.get(lo);
        if (ans != null)
            return ans;
        
        String converted = devowel(word);
        ans = vowel.get(converted);
        if (ans != null)
            return ans;
        return "";
    }
    
    private String devowel(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (isVowel(chars[i]))
                chars[i] = '*';
            
        }
        return String.valueOf(chars);
    }
    
    private boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }
}