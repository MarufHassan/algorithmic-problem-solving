# [804. Unique Morse Code Words][title]

## Problem Description

Detail instruction can be found [here][title].

**Example 1:**

```
Example:
Input: words = ["gin", "zen", "gig", "msg"]
Output: 2
Explanation: 
The transformation of each word is:
"gin" -> "--...-."
"zen" -> "--...-."
"gig" -> "--...--."
"msg" -> "--...--."

There are 2 different transformations, "--...-." and "--...--.".
```

## Solution

```java
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
```

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/unique-morse-code-words/