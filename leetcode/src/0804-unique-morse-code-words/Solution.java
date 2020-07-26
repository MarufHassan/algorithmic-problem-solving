class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        Set<String> seen = new HashSet<>();
        
        for (String word : words) {
            StringBuilder transformed = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                transformed.append(codes[c - 'a']);
            }
            seen.add(transformed.toString());
        }
        
        return seen.size();
        
    }
}