class Solution {
    private boolean isvalid(int[] sfreq, int[] tfreq) {
        for (int i = 0; i < sfreq.length; i++) {
            if (sfreq[i] < tfreq[i])
                return false;
        }
        return true;
    }
    
    public String minWindow(String s, String t) {
        int minLen = s.length() + 1;
        int n = s.length();
        
        int[] tfreq = new int[128];
        
        for (int i = 0; i < t.length(); i++) {
            tfreq[t.charAt(i)]++;
        }
        int ansleft = -1, ansright = -1;
        for (int i = 0; i < n; i++) {
            int[] sfreq = new int[128];
            for (int j = i; j < n; j++) {
                sfreq[s.charAt(j)]++;
                if (isvalid(sfreq, tfreq)) {
                    if (j - i + 1 < minLen) {
                        minLen = j - i + 1;
                        ansleft = i; ansright = j;
                    }
                }
            }
        }
        if (ansleft == -1 && ansright == -1)
            return "";
        return s.substring(ansleft, ansright + 1);
    }
}