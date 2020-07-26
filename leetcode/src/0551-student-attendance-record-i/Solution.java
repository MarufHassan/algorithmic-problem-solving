class Solution {
    public boolean checkRecord(String s) {
        int absent = 0;
        for (char c : s.toCharArray()) {
            if (c == 'A')   absent++;
        }
        return absent <= 1 && !s.contains("LLL");
    }
}