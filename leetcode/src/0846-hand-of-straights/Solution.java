class Solution {
    public boolean isNStraightHand(int[] hand, int W) {
        if (hand.length % W != 0)   return false;
        
        TreeMap<Integer, Integer> freq = new TreeMap<>();
        for (int card : hand) {
            freq.put(card, freq.getOrDefault(card, 0) + 1);
        }
        
        while (freq.size() > 0) {
            int first = freq.firstKey();
            for (int card = first; card < W + first; card++) {
                if (!freq.containsKey(card))    return false;
                int val = freq.get(card);
                if (val > 1)
                    freq.replace(card, val - 1);
                else
                    freq.remove(card);
            }
        }
        return true;
    }
}