# [824. Goat Latin][title]

## Problem Description

Detail instruction can be found [here][title].

**Example 1:**

```
Input: "I speak Goat Latin"
Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
```

**Example 2:**

```
Input: "The quick brown fox jumped over the lazy dog"
Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
```

## Solution

```java
public String toGoatLatin(String S) {
    StringBuilder as = new StringBuilder();
    StringBuilder ans = new StringBuilder();
    
    for (String str : S.split(" ")) {
        if (isVowel(str.charAt(0))) {
            ans.append(str);
        } else {
            ans.append(str.substring(1));
            ans.append(str.charAt(0));
        }
        ans.append("ma");
        as.append('a');
        ans.append(as + " ");
    }
    ans.deleteCharAt(ans.length() - 1);
    return ans.toString();
}
```

**private helper method**

```java
private boolean isVowel(char c) {
    return "AEIOUaeiou".indexOf(c) != -1;
}
```

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/goat-latin/