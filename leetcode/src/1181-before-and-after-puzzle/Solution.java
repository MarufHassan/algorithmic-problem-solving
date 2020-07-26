class Solution {
    public List<String> beforeAndAfterPuzzles(String[] phrases) {
        TreeSet<String> ans = new TreeSet<>();
        
        String[] first = new String[phrases.length];
        String[] last = new String[phrases.length];
        
        for (int i = 0; i < phrases.length; i++) {
            String[] splits = phrases[i].split(" ");
            first[i] = splits[0];
            last[i] = splits[splits.length - 1];
        }
        
        for (int i = 0; i < phrases.length; i++) {
            for (int j = 0; j < phrases.length; j++) {
                if (i == j) continue;
                if (last[i].equals(first[j])) {
                    int idx = phrases[j].indexOf(" ");
                    String make = phrases[i];
                    if (idx != -1) {
                        make += phrases[j].substring(idx, phrases[j].length());
                    }
                    ans.add(make);
                }
            }
        }
        
        return new ArrayList<>(ans);
    }
}