class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int len1 = name.length();
        int len2 = typed.length();
        int i = 0, j = 0, count1 = 0, count2 = 0;
        
        while (i < len1) {
            char c = name.charAt(i);
            
            count1 = 0;
            while (i < len1 && c == name.charAt(i)) {
                count1++;
                i++;
            }
            
            count2 = 0;
            while (j < len2 && c == typed.charAt(j)) {
                count2++;
                j++;
            }
            if (count2 < count1)
                return false;
        }
        
        return i == len1 && j == len2;
    }
}