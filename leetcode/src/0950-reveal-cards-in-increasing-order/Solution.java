class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Deque<Integer> index = new LinkedList<>();
        for (int i = 0; i < deck.length; i++) {
            index.addLast(i);
        }
        Arrays.sort(deck);
        
        int[] ans = new int[deck.length];
        for (int i = 0; i < deck.length; i++) {
            ans[index.pollFirst()] = deck[i];
            if (!index.isEmpty())
                index.addLast(index.pollFirst());
        }
        
        return ans;
    }
}