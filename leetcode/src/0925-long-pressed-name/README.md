# [925. Long Pressed Name][title]

## Problem Description

Your friend is typing his name into a keyboard.  Sometimes, when typing a character c, the key might get long pressed, and the character will be typed 1 or more times.

You examine the typed characters of the keyboard.  Return True if it is possible that it was your friends name, with some characters (possibly none) being long pressed.

Detail instruction can be found [here][title].

**Example 1:**

```
Input: name = "alex", typed = "aaleex"
Output: true

Explanation: 'a' and 'e' in 'alex' were long pressed.
```

**Example 2:**

```
Input: name = "saeed", typed = "ssaaedd"
Output: false

Explanation: 'e' must have been pressed twice, but it wasn't in the typed output.
```

## Solution

**Approach 1: Two Pointers**

```java
public boolean isLongPressedName(String name, String typed) {
    int len1 = name.length();
    int len2 = typed.length();
    int i = 0, j = 0, count1 = 0, count2 = 0;
    
    while (i < len1) {
        char c = name.charAt(i);
        
        count1 = 0;
        while (i < len1 && c == name.charAt(i)) {
            count1++;
            i++;
        }
        
        count2 = 0;
        while (j < len2 && c == typed.charAt(j)) {
            count2++;
            j++;
        }
        if (count2 < count1)
            return false;
    }
    
    return i == len1 && j == len2;
}
```

**Approach 2: Group into Blocks**

```java
public boolean isLongPressedName(String name, String typed) {
    Group g1 = groupify(name);
    Group g2 = groupify(typed);
    
    if (!g1.key.equals(g2.key))
        return false;
    
    for (int i = 0; i < g1.count.size(); i++) {
        if (g1.count.get(i) > g2.count.get(i))
            return false;
    }
    return true;
}

private Group groupify(String s) {
    StringBuilder key = new StringBuilder();
    List<Integer> freq = new ArrayList<>();
    
    int count = 1;
    for (int i = 1; i < s.length(); i++) {
        if (s.charAt(i - 1) != s.charAt(i)) {
            key.append(s.charAt(i - 1));
            freq.add(count);
            count = 1;
        } else {
            count++;
        }
    }
    return new Group(key.toString(), freq);
}
```

**private helper class**

```java
class Group {
    String key;
    List<Integer> count;
    
    Group(String key, List<Integer> count) {
        this.key = key;
        this.count = count;
    }
}
```

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/long-pressed-name/