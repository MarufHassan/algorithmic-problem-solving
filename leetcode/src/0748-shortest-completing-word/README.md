# [748. Shortest Completing Word][title]

## Problem Description

Find the minimum length word from a given dictionary words, which has all the letters from the string licensePlate. Such a word is said to complete the given string licensePlate

Here, for letters we ignore case. For example, "P" on the licensePlate still matches "p" on the word.

It is guaranteed an answer exists. If there are multiple answers, return the one that occurs first in the array.

The license plate might have the same letter occurring multiple times. For example, given a licensePlate of "PP", the word "pair" does not complete the licensePlate, but the word "supper" does.

**Example 1:**

```
Input: licensePlate = "1s3 PSt", words = ["step", "steps", "stripe", "stepple"]
Output: "steps"

Explanation: The smallest length word that contains the letters "S", "P", "S", and "T".
Note that the answer is not "step", because the letter "s" must occur in the word twice.
Also note that we ignored case for the purposes of comparing whether a letter exists in the word.
```

**Example 2:**

```
Input: licensePlate = "1s3 456", words = ["looks", "pest", "stew", "show"]
Output: "pest"

Explanation: There are 3 smallest length words that contains the letters "s".
We return the one that occurred first.
```

## Solution

```java
public String shortestCompletingWord(String licensePlate, String[] words) {
    int[] reference = frequency(licensePlate);
    
    String ans = "";
    int min = 20;
    for (String word : words) {
        int[] freq = frequency(word);
        
        boolean found = true;
        for (int i = 0; i < 26; i++) {
            if (reference[i] == 0)  continue;
            if (freq[i] < reference[i]) {
                found = false;
                break;
            }
        }
        if (found) {
            if (min > word.length()) {
                min = word.length();
                ans = word;
            }
        }
    }
    return ans;
}
```

**private helper methods**

```java
private int[] frequency(String s) {
    int[] count = new int[26];
    for (char c : s.toCharArray()) {
        if (!Character.isLetter(c)) continue;
        
        c = Character.toLowerCase(c);
        count[c - 'a']++;
    }
    return count;
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/shortest-completing-word/