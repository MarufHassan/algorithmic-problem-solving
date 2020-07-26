class TopVotedCandidate {
    private TreeMap<Integer, Integer> index;
    private int[] leaders;
    
    public TopVotedCandidate(int[] persons, int[] times) {
        index = new TreeMap<>();
        leaders = new int[persons.length];
        
        for (int i = 0; i < times.length; i++) {
            index.put(times[i], i);
        }
        
        Map<Integer, Integer> freq = new HashMap<>();
        int leader = persons[0];
        for (int i = 0; i < persons.length; i++) {
            freq.put(persons[i], freq.getOrDefault(persons[i], 0) + 1);
            
            int votes = freq.get(persons[i]);
            if (votes >= freq.get(leader))
                leader = persons[i];
            leaders[i] = leader;
        }
    }
    
    public int q(int t) {
        int idx = index.floorEntry(t).getValue();
        return leaders[idx];
    }
}