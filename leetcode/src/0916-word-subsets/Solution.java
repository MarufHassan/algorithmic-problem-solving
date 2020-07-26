class Solution {
    public List<String> wordSubsets(String[] A, String[] B) {
        int[] bmax = frequency("");
        
        for (String s : B) {
            int[] count = frequency(s);
            for (int i = 0; i < 26; i++) {
                bmax[i] = Math.max(bmax[i], count[i]);
            }
        }
        
        List<String> res = new ArrayList<>();
        for (String s : A) {
            int[] count = frequency(s);
            boolean found = true;
            for (int i = 0; i < 26; i++) {
                if (bmax[i] > count[i]) {
                    found = false;
                    break;
                }
            }
            if (found)
                res.add(s);
        }
        
        return res;
    }
    
    private int[] frequency(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        return count;
    }
}