class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        for (int i = 0; i < words.length - 1; i++) {
            int cmp = compare(words[i], words[i + 1], order);
            if (cmp > 0)
                return false;
        }
        return true;
    }
    
    public int compare(String a, String b, String order) {
        for (int i = 0; i < a.length() && i < b.length(); i++) {
            int m = order.indexOf(a.charAt(i));
            int n = order.indexOf(b.charAt(i));
            
            if (m != n)         return m - n;
        }
        return a.length() - b.length();
    }
}