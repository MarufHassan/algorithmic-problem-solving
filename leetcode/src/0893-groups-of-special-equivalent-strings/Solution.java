class Solution {
    public int numSpecialEquivGroups(String[] A) {
        Set<String> seen = new HashSet<>();
        
        for (String s : A) {
            int[] even = new int[26];
            int[] odd = new int[26];
            
            for (int i = 0; i < s.length(); i++) {
                int idx = s.charAt(i) - 'a';
                if (i % 2 == 0)
                    even[idx]++;
                else
                    odd[idx]++;
            }
            String seg = Arrays.toString(even) + Arrays.toString(odd);
            seen.add(seg);
        }
        return seen.size();
    }
}