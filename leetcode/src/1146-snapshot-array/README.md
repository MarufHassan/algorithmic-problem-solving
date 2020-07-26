# [1146. Snapshot Array][title]

## Problem Description

Implement a SnapshotArray that supports the following interface:

SnapshotArray(int length) initializes an array-like data structure with the given length.  Initially, each element equals 0.
void set(index, val) sets the element at the given index to be equal to val.
int snap() takes a snapshot of the array and returns the snap_id: the total number of times we called snap() minus 1.
int get(index, snap_id) returns the value at the given index, at the time we took the snapshot with the given snap_id

**Example 1:**

```
Input: ["SnapshotArray","set","snap","set","get"]
[[3],[0,5],[],[0,6],[0,0]]
Output: [null,null,0,null,5]

Explanation: 
SnapshotArray snapshotArr = new SnapshotArray(3); // set the length to be 3
snapshotArr.set(0,5);  // Set array[0] = 5
snapshotArr.snap();  // Take a snapshot, return snap_id = 0
snapshotArr.set(0,6);
snapshotArr.get(0,0);  // Get the value of array[0] with snap_id = 0, return 5
```

## Solution

```java
class SnapshotArray {
  private List<TreeMap<Integer, Integer>> maps;
  private int snaps;

  public SnapshotArray(int length) {
      maps = new ArrayList<>();
      for (int i = 0; i < length; i++) {
          maps.add(new TreeMap<>());
          maps.get(i).put(0, 0);
      }
      snaps = 0;
  }
  
  public void set(int index, int val) {
      maps.get(index).put(snaps, val);
  }
  
  public int snap() {
      return snaps++;
  }
  
  public int get(int index, int snap_id) {
      return maps.get(index).floorEntry(snap_id).getValue();
  }
}
```

## Test

Compile with `javac Solution.java` and run with `java -ea Solution`.

**This is only for discussion and communication. Please don't use this for submission of assignments.**

[title]: https://leetcode.com/problems/snapshot-array/