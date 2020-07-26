class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> freq = new HashMap<>();
        
        for (String s : split(paragraph)) {
            freq.put(s, freq.getOrDefault(s, 0) + 1);
        }
        
        Set<String> banset = new HashSet<>();
        for (String s: banned) {
            banset.add(s);
        }
        
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            public int compare(String s1, String s2) {
                return freq.get(s2) - freq.get(s1);
            }
        });
        
        for (String key : freq.keySet()) {
            pq.offer(key);
        }
        
        while (!pq.isEmpty()) {
            String s = pq.poll();
            if (!banset.contains(s))
                return s;
        }
        
        return null;
    }
    
    private List<String> split(String s) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            while (i < s.length() && !Character.isLetter(s.charAt(i)))
                i++;
            
            StringBuilder word = new StringBuilder();
            
            while (i < s.length() && Character.isLetter(s.charAt(i))) {
                word.append(Character.toLowerCase(s.charAt(i)));
                i++;
            }
            if (word.length() > 0)
                list.add(word.toString());
        }
        return list;
    }
}