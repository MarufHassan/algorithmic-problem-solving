class Solution {
    private boolean matches(char[] query, char[] pat) {
        int ptr1 = 0, ptr2 = 0;
        for (; ptr1 < query.length; ptr1++) {
            if (ptr2 < pat.length && query[ptr1] == pat[ptr2]) 
                ptr2++;
            else if (Character.isUpperCase(query[ptr1]))
                return false;
        }
        return ptr2 == pat.length;
    }
    
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ans = new ArrayList<>();
        char[] pat = pattern.toCharArray();
        for (String word : queries) {
            ans.add(matches(word.toCharArray(), pat));
        }
        
        return ans;
    }
}