class GfG
{
    boolean equal(String txt, String pat, int i) {
        int m = pat.length();
        for (int j = 0; j < m; j++) {
            if (pat.charAt(j) != txt.charAt(i + j))
                return false;
        }
        return true;
    }
    
    int strstr(String txt, String pat) {
        int n = txt.length(), m = pat.length();
        if (m <= 0)
            return m;
        if (n < m)
            return -1;
        
        for (int i = 0; i <= n - m; i++) {
            if (equal(txt, pat, i))
                return i;
        }
        return -1;
    }
}