# [12. Integer to Roman][title]

## Problem Description

Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999. Detailed description can be found in [here][title].

**Example 1:**

```
Input: 3
Output: "III"
```

**Example 2:**

```
Input: 4
Output: "IV"
```

**Example 3:**

```
Input: 9
Output: "IX"
```

**Example 4:**

```
Input: 58
Output: "LVIII"
Explanation: L = 50, V = 5, III = 3.
```

**Example 5:**

```
Input: 1994
Output: "MCMXCIV"
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
```

## Solution


```java
private static int[]    numbers = { 1000,  900,  500,  400,  100,   90,  
                                      50,   40,   10,    9,    5,    4,    1 };

private static String[] letters = { "M",  "CM",  "D",  "CD", "C",  "XC",
                                    "L",  "XL",  "X",  "IX", "V",  "IV", "I" };

public String intToRoman(int num) {
    StringBuilder roman = new StringBuilder();  // The roman numeral.
    
    for (int i = 0; i < numbers.length; i++) {
       while (num >= numbers[i]) {
          roman.append(letters[i]);
          num -= numbers[i];
       }
    }
    return roman.toString();
}
```

## Test

Compile with `javac Solution.java` and run with `java -ea Solution`.

```java
class Solution {
    public String intToRoman(int num) {
        /* see previous code */
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        int n = 3;
        assert s.intToRoman(n).equals("III");

        n = 4;
        assert s.intToRoman(n).equals("IV");

        n = 9;
        assert s.intToRoman(n).equals("IX");

        n = 58;
        assert s.intToRoman(n).equals("LVIII");

        n = 1994;
        assert s.intToRoman(n).equals("MCMXCIV");

        n = 3999;
        assert s.intToRoman(n).equals("MMMCMXCIX");
    }
}
```

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/integer-to-roman/