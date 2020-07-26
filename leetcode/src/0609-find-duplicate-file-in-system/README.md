# [609. Find Duplicate File in System][title]

## Problem Description

Detail instruction can be found [here][title].

**Example 1:**

```
["root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"]
Output:  
[["root/a/2.txt","root/c/d/4.txt","root/4.txt"],["root/a/1.txt","root/c/3.txt"]]
```

## Solution


```java
public List<List<String>> findDuplicate(String[] paths) {
    Map<String, List<String>> contents = new HashMap<>();
    
    for (String path : paths) {
        String[] splits = path.split(" ");
        
        for (int i = 1; i < splits.length; i++) {
            int first =  splits[i].indexOf("(");
            int last =  splits[i].indexOf(")", first);
            String key = splits[i].substring(first + 1, last + 1);
            
            contents.putIfAbsent(key, new ArrayList<>());
            contents.get(key).add(splits[0] + "/" + splits[i].substring(0, first));
        }
    }
    
    List<List<String>> ans = new ArrayList<>();
    for (String key : contents.keySet()) {
        List<String> list = contents.get(key);
        if (list.size() > 1)
            ans.add(list);
    }
    
    return ans;
}
```

## Test

Compile with `javac Solution.java` and run with `java Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/find-duplicate-file-in-system/