class Solution {
    public String strWithout3a3b(int A, int B) {
        char[] ans = new char[A + B];
        int i = 0;
        while (A > 0 || B > 0) {
            boolean writeA = false;
            int len = i + 1;
            if (i >= 2 && ans[i - 1] == ans[i - 2]) {
                if (ans[i - 1] == 'b')
                    writeA = true;
            } else {
                if (A >= B)
                    writeA = true;
            }
            if (writeA) {
                ans[i] = 'a';
                A--;
            } else {
                ans[i] = 'b';
                B--;
            }
            i++;
        }
        return new String(ans);
    }
}