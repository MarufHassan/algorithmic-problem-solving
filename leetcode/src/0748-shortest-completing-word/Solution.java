class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] reference = frequency(licensePlate);
        
        String ans = "";
        int min = 20;
        for (String word : words) {
            int[] freq = frequency(word);
            
            boolean found = true;
            for (int i = 0; i < 26; i++) {
                if (reference[i] == 0)  continue;
                if (freq[i] < reference[i]) {
                    found = false;
                    break;
                }
            }
            if (found) {
                if (min > word.length()) {
                    min = word.length();
                    ans = word;
                }
            }
        }
        return ans;
    }
    
    
    
    private int[] frequency(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            if (!Character.isLetter(c)) continue;
            
            c = Character.toLowerCase(c);
            count[c - 'a']++;
        }
        return count;
    }
}