# [981. Time Based Key-Value Store][title]

## Problem Description

Create a timebased key-value store class TimeMap.

Detail instruction can be found [here][title].

**Example 1:**

```
Input: inputs = ["TimeMap","set","get","get","set","get","get"], inputs = [[],["foo","bar",1],["foo",1],["foo",3],["foo","bar2",4],["foo",4],["foo",5]]
Output: [null,null,"bar","bar",null,"bar2","bar2"]
Explanation:   
TimeMap kv;   
kv.set("foo", "bar", 1); // store the key "foo" and value "bar" along with timestamp = 1   
kv.get("foo", 1);  // output "bar"   
kv.get("foo", 3); // output "bar" since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 ie "bar"   
kv.set("foo", "bar2", 4);   
kv.get("foo", 4); // output "bar2"   
kv.get("foo", 5); //output "bar2"   
```

**Example 2:**

```
Input: inputs = ["TimeMap","set","set","get","get","get","get","get"], inputs = [[],["love","high",10],["love","low",20],["love",5],["love",10],["love",15],["love",20],["love",25]]
Output: [null,null,null,"","high","high","low","low"]
```

## Solution


```java
class TimeMap {
    private Map<String, TreeMap<Integer, String>> maps;
    
    public TimeMap() {
        maps = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!maps.containsKey(key))
            maps.put(key, new TreeMap<>());
        maps.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if (!maps.containsKey(key))
            return "";
        TreeMap<Integer, String> m = maps.get(key);
        Integer t = m.floorKey(timestamp);
        return (t == null) ? "" : m.get(t);
    }
}
```

## Test

Compile with `javac TimeMap.java` and run with `java TimeMap`.


**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/time-based-key-value-store/