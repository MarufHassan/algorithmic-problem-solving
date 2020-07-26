class Solution {
    public int compress(char[] chars) {
        int read = 0, write = 0;
        
        while (read < chars.length) {
            int anchor = read + 1;
            
            while (anchor < chars.length && chars[read] == chars[anchor])
                anchor++;
            
            chars[write++] = chars[read];
            if (anchor - read > 1) {
                for (char c : ("" + (anchor - read)).toCharArray()) {
                    chars[write++] = c;
                }
            }
            read = anchor;
        }
        
        return write;
    }
}