# [1166. Design File System][title]

## Problem Description

You are asked to design a file system which provides two functions:

create(path, value): Creates a new path and associates a value to it if possible and returns True. Returns False if the path already exists or its parent path doesn't exist.
get(path): Returns the value associated with a path or returns -1 if the path doesn't exist.
The format of a path is one or more concatenated strings of the form: / followed by one or more lowercase English letters. For example, /leetcode and /leetcode/problems are valid paths while an empty string and / are not.

Implement the two functions.

Please refer to the examples for clarifications.

**Example 1:**

```
Input: 
["FileSystem","create","get"]
[[],["/a",1],["/a"]]
Output: 
[null,true,1]
Explanation: 
FileSystem fileSystem = new FileSystem();

fileSystem.create("/a", 1); // return true
fileSystem.get("/a"); // return 1
```

**Example 2:**

```
Input: 
["FileSystem","create","create","get","create","get"]
[[],["/leet",1],["/leet/code",2],["/leet/code"],["/c/d",1],["/c"]]
Output: 
[null,true,true,2,false,-1]
Explanation: 
FileSystem fileSystem = new FileSystem();

fileSystem.create("/leet", 1); // return true
fileSystem.create("/leet/code", 2); // return true
fileSystem.get("/leet/code"); // return 2
fileSystem.create("/c/d", 1); // return false because the parent path "/c" doesn't exist.
fileSystem.get("/c"); // return -1 because this path doesn't exist.
```

## Solution

```java
class FileSystem {
    Map<String, Integer> file = new HashMap<>(); 
    
    public FileSystem() {
        file.put("", -1);
    }
    
    public boolean create(String path, int value) {
        int idx = path.lastIndexOf("/");
        String parent = path.substring(0, idx);
        if (!file.containsKey(parent)) { return false; }
        return file.putIfAbsent(path, value) == null;   
    }
    
    public int get(String path) {
        return file.getOrDefault(path, -1);
    }
}
```

## Test

Compile with `javac FileSystem.java` and run with `java -ea FileSystem`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/design-file-system/