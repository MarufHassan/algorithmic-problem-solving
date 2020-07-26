# [13. Roman to Integer][title]

## Problem Description

Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999. Detailed description can be found in [here][title].

**Example 1:**

```
Input: "III"
Output: 3
```

**Example 2:**

```
Input: "IV"
Output: 4
```

**Example 3:**

```
Input: "IX"
Output: 9
```

**Example 4:**

```
Input: "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.
```

**Example 5:**

```
Input: "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
```

## Solution


```java
public int romanToInt(String s) {
    if (s.length() <= 0)
        return 0;

    int[] map = new int[26];
    map['I' - 'A'] = 1;
    map['V' - 'A'] = 5;
    map['X' - 'A'] = 10;
    map['L' - 'A'] = 50;
    map['C' - 'A'] = 100;
    map['D' - 'A'] = 500;
    map['M' - 'A'] = 1000;
    
    int c = s.charAt(s.length() - 1) - 'A';
    int result = map[c];

    for (int i = s.length() - 2; i >= 0; i--) {
        c = s.charAt(i) - 'A';
        int value = map[c];

        c = s.charAt(i + 1) - 'A';

        if (value < map[c])
            result -= value;
        else
            result += value;

    }
    return result;
}
```

## Test

Compile with `javac Solution.java` and run with `java -ea Solution`.

```java
class Solution {
    public int romanToInt(String s) {
        /* see previous code */
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        String str = "III";
        assert s.romanToInt(str) == 3;

        str = "IV";
        assert s.romanToInt(str) == 4;

        str = "VIII";
        assert s.romanToInt(str) == 8;

        str = "LVIII";
        assert s.romanToInt(str) == 58;

        str = "MCMXCIV";
        assert s.romanToInt(str) == 1994;

        str = "";
        assert s.romanToInt(str) == 0;

        str = "MMMCMXCIX";
        assert s.romanToInt(str) == 3999;
    }
}
```

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/roman-to-integer/