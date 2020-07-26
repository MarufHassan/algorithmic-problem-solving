# [1002. Find Common Characters][title]

## Problem Description

Given an array A of strings made only from lowercase letters, return a list of all characters that show up in all strings within the list (including duplicates).  For example, if a character occurs 3 times in all strings but not 4 times, you need to include that character three times in the final answer.

You may return the answer in any order.

Detail instruction can be found [here][title].

**Example 1:**

```
Input: ["bella","label","roller"]
Output: ["e","l","l"]
```

**Example 2:**

```
Input: ["cool","lock","cook"]
Output: ["c","o"]
```

## Solution

**Approach 1: Brute Force(Accepted)**

```java
public List<String> commonChars(String[] A) {
    List<String> ans = new ArrayList<>();
    
    if (A.length == 0)
        return ans;
    
    String common = A[0];
    for (int i = 0; i < A.length; i++) {
         common = intersection(common, A[i]);
    }
    for (char c : common.toCharArray()) {
        ans.add(String.valueOf(c));
    }
    return ans;
}
```

**private helper methods**

```java
private String intersection(String wordA, String wordB) {
    StringBuilder common = new StringBuilder();
    int[] freq1 = new int[26];
    int[] freq2 = new int[26];
    
    for (int i = 0; i < wordA.length(); i++) {
        freq1[wordA.charAt(i) - 'a']++;
    }
    
    for (int i = 0; i < wordB.length(); i++) {
        freq2[wordB.charAt(i) - 'a']++;
    }
    
    for (int i = 0; i < 26; i++) {
        int min = (Math.min(freq1[i], freq2[i]));
        for (int j = 0; j < min; j++) {
            common.append((char)(i + 'a'));
        }
    }
    return common.toString();
}
```

**Approach 2: Linear time complexity**

```java
public List<String> commonChars(String[] A) {
    List<String> ans = new ArrayList<>();
    
    int[] minCount = new int[26];
    Arrays.fill(minCount, Integer.MAX_VALUE);
    
    for (String s : A) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            minCount[i] = Math.min(minCount[i], count[i]);
        }
    }
    
    for (int i = 0; i < 26; i++) {
        for (int j = 0; j < minCount[i]; j++) {
            ans.add((char)(i + 'a') + "");
        }
    }
    
    return ans;
}
```

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/find-common-characters/