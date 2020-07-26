class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] index = new int[256];
        
        for (int i = 0; i < s.length(); i++) {
            int c1 = s.charAt(i);
            int c2 = t.charAt(i) + 128;
            if (index[c1] != index[c2])
                return false;
            index[c1] = index[c2] = i + 1;
        }
        return true;
    }
}