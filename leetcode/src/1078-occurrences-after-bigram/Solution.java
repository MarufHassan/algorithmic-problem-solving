class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        String[] strs = text.split(" ");
        List<String> ans = new ArrayList<>();
        
        for (int i = 2; i < strs.length; i++) {
            if (strs[i - 2].equals(first) && strs[i - 1].equals(second))
                ans.add(strs[i]);
        }
        return ans.toArray(new String[0]);
    }
}