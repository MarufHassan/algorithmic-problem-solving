class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] freq = new int[128];
        
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            freq[c]++;
        }
        
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            freq[c]--;
            if (freq[c] < 0)
                return false;
        }
    
        return true;
    }
}