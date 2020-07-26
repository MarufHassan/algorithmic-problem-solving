# [657. Robot Return to Origin][title]

## Problem Description

Detail instruction can be found [here][title].

**Example 1:**

```
Input: "UD"
Output: true 

Explanation: The robot moves up once, and then down once. All moves have the same magnitude, so it ended up at the origin where it started. Therefore, we return true.
```

**Example 2:**

```
Input: "LL"
Output: false

Explanation: The robot moves left twice. It ends up two "moves" to the left of the origin. We return false because it is not at the origin at the end of its moves.
```

## Solution

```java
public boolean judgeCircle(String moves) {
    int[] map = new int[128];
    map['L'] = -1; map['R'] = +1; map['U'] = +2; map['D'] = -2;
    
    int pos = 0;
    for (char c : moves.toCharArray()) {
        pos += map[c];
    }
    return pos == 0;
}
```

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/robot-return-to-origin/