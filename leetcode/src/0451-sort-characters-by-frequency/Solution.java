class Solution {
    public String frequencySort(String s) {
        int[] freq = new int[128];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            freq[c] += 1;
        }
        PriorityQueue<Character> pq = new PriorityQueue<>(new Comparator<Character>() {
            public int compare(Character c1, Character c2) {
                int f1 = freq[c1];
                int f2 = freq[c2];
                if (f1 != f2)
                    return f2 - f1;
                return Character.compare(c1, c2);
            }
        });
        for (int i = 0; i < 128; i++) {
            if (freq[i] != 0) {
                pq.offer((char)i);
            }
        }
        StringBuilder ans = new StringBuilder();
        while (pq.size() > 0) {
            char c = pq.poll();
            for (int i = 0; i < freq[c]; i++) {
                ans.append(c);
            }
        }
        return ans.toString();
    }
}