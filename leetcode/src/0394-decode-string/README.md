# [394. Decode String][title]

## Problem Description

Detailed description can be found [here][title]

**Example:**

```
s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
```

## Solution

**Approach 1:**

```java
public String decodeString(String s) {
    Stack<Integer> nums = new Stack<Integer>();
    Stack<String> vals = new Stack<String>();
    int len = s.length();
    
    for (int i = 0; i < len; i++) {
        char c = s.charAt(i);
        if (Character.isDigit(c)) {
            int n = 0;
            while (Character.isDigit(c)) {
                n = n * 10 + digit(c);
                c = s.charAt(++i);
            }
            nums.push(n);
        }
        if (c == ']') {
            String v = "";
            while (!vals.empty() && !vals.peek().equals("["))
                v = vals.pop() + v;
            vals.pop(); // remove [
            int times = nums.pop();
            vals.push(repeat(v, times));
        } else
            vals.push(c + "");
    }
    StringBuilder result = new StringBuilder();
    for (String str : vals) {
        result.append(str);
    }
    return result.toString();
}
```

**Helper Method**
```java
private static String repeat(String s, int times) {
    StringBuilder build = new StringBuilder();
    for (int i = 1; i <= times; i++) {
        build.append(s);
    }
    return build.toString();
}

private static int digit(char c) {
    return (c - '0');
}
```

**Approach 2:**

```java
public List<Integer> powerfulIntegers(int x, int y, int bound) {
    Set<Integer> seen = new HashSet<Integer>();
    
    for (int i = 0; i < 18 && Math.pow(x, i) <= bound; i++) {
        for (int j = 0; j < 18 && Math.pow(y, j) <= bound; j++) {
            int v = (int) Math.pow(x, i) + (int) Math.pow(y, j);
            if (v <= bound)
                seen.add(v);
        }
    }
    return new ArrayList<Integer>(seen);
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/decode-string/