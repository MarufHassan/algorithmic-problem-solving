# [937. Reorder Log Files][title]

## Problem Description

Detail instruction can be found [here][title].

**Example 1:**

```
Input: ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]

Output: ["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
```

## Solution

**Approach 1:**

```java
public String[] reorderLogFiles(String[] logs) {
    List<String> letterLogs = new ArrayList<>();
    List<String> digitLogs = new ArrayList<>();
    
    for (String log : logs) {
        log = log.trim();
        char c = log.charAt(log.length() - 1);
        if (Character.isDigit(c))
            digitLogs.add(log);
        else
            letterLogs.add(log);
    }
    Collections.sort(letterLogs, new Comparator<String>() {
        public int compare(String s1, String s2) {
            int pos1 = s1.indexOf(' ');
            int pos2 = s2.indexOf(' ');
            int cmp = s1.substring(pos1 + 1).compareTo(s2.substring(pos2 + 1));
            if (cmp != 0)
                return cmp;
            
            return s1.substring(0, pos1).compareTo(s2.substring(0, pos2));
        }
    });
    
    String[] ans = new String[logs.length];
    for (int i = 0; i < letterLogs.size(); i++) {
        ans[i] = letterLogs.get(i);
    }
    for (int i = 0, offset = letterLogs.size(); i < digitLogs.size(); i++) {
        ans[i + offset] = digitLogs.get(i);
    }
    return ans;
}
```

**Approach 2: Custom Sort**

```java
public String[] reorderLogFiles(String[] logs) {
    Arrays.sort(logs, new Comparator<String>() {
        public int compare(String s1, String s2) {
            String[] split1 = s1.split(" ", 2);
            String[] split2 = s2.split(" ", 2);
            
            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
            
            if (!isDigit1 && !isDigit2) {
                int cmp = split1[1].compareTo(split2[1]);
                if (cmp != 0)
                    return cmp;
                return split1[0].compareTo(split2[0]);
            }
            return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
        }
    });
    
    return logs;
}
```

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/reorder-log-files/